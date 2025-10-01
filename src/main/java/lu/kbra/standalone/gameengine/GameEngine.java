package lu.kbra.standalone.gameengine;

import java.util.logging.Level;

import org.joml.Vector3f;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.audio.AudioMaster;
import lu.kbra.standalone.gameengine.cache.SharedCacheManager;
import lu.kbra.standalone.gameengine.graph.MaterialFactory;
import lu.kbra.standalone.gameengine.graph.window.GLESWindow;
import lu.kbra.standalone.gameengine.graph.window.GLWindow;
import lu.kbra.standalone.gameengine.graph.window.Window;
import lu.kbra.standalone.gameengine.graph.window.WindowOptions;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GameLogic;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.impl.nexttask.Dispatcher;
import lu.kbra.standalone.gameengine.utils.DebugOptions;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W_GL40;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W_GLES30;

public class GameEngine implements Cleanupable, UniqueID {

	private static final long MIN_NANO_TIME_TO_START_TASK = 10_000;

	public static final Vector3f X_POS = new Vector3f(1, 0, 0), X_NEG = new Vector3f(-1, 0, 0), Y_POS = new Vector3f(0, 1, 0),
			Y_NEG = new Vector3f(0, -1, 0), Z_POS = new Vector3f(0, 0, 1), Z_NEG = new Vector3f(0, 0, -1), ZERO = new Vector3f(0, 0, 0);

	public static final Vector3f UP = new Vector3f(Y_POS), DOWN = new Vector3f(Z_NEG), LEFT = new Vector3f(X_NEG),
			RIGHT = new Vector3f(X_POS), FORWARD = new Vector3f(Z_POS), BACK = new Vector3f(X_POS);

	public static final long POLL_EVENT_TIMEOUT = 500, BUFFER_SWAP_TIMEOUT = 500, WAIT_FRAME_END_TIMEOUT = 500,
			WAIT_FRAME_START_TIMEOUT = 500, WAIT_UPDATE_END_TIMEOUT = 500, WAIT_UPDATE_START_TIMEOUT = 500; // ms

	public static final int QUEUE_MAIN = 0, QUEUE_RENDER = 1, QUEUE_UPDATE = 2;

	public static DebugOptions DEBUG = new DebugOptions();

	private final String name;

	private WindowOptions windowOptions;
	private Window window;
	private AudioMaster audioMaster;
	private GameLogic gameLogic;

	private boolean running = false;
	private volatile boolean waitingForEvents = false;

	public int targetUps, targetFps;
	private double currentFps;

	private SharedCacheManager cache;

	private Dispatcher mainDispatcher, renderDispatcher, updateDispatcher;

	private ThreadGroup threadGroup;
	private Thread renderThread, updateThread, mainThread;

	private final Object waitForFrameEnd = new Object(), waitForUpdateEnd = new Object(), waitForFrameStart = new Object(),
			waitForUpdateStart = new Object();

	public GameEngine(String name, GameLogic game, WindowOptions options) {
		this.name = name;
		this.gameLogic = game;
		this.windowOptions = options;
	}

	private void updateRun() {
		if (!running) {
			try {
				Thread.sleep(Long.MAX_VALUE); // waiting for renderThread to finish GameLogic#init()
				if (!Thread.interrupted()) {
					GlobalLogger.severe("Update thread waiting too long for init");
					return;
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				GlobalLogger.info("Update thread interrupted, continuing");
			}
		}

		init: {
			this.audioMaster = new AudioMaster();
			gameLogic.register(this);

			gameLogic.updateInit();
		}

		try {

			this.targetUps = this.window.getOptions().ups;
			final long targetPerUps = (long) (1e9 / this.targetUps);
			long lastTime = System.nanoTime(); // nanos

			while (this.shouldRun()) {
				long now = System.nanoTime();

				long deltaUpdate = now - lastTime;
				if (deltaUpdate > targetPerUps) {
					synchronized (waitForUpdateStart) {
						waitForUpdateStart.notifyAll();
					}

					this.pollEvents();
					this.gameLogic.input(deltaUpdate / 1e9f);
					this.window.clearScroll();

					this.gameLogic.update(deltaUpdate / 1e9f);

					lastTime = now;

					synchronized (waitForUpdateEnd) {
						waitForUpdateEnd.notifyAll();
					}

					final long dispatcherBudgetNanos = Math.max(0, targetPerUps - deltaUpdate);
					updateDispatcher.pump((long) (dispatcherBudgetNanos * 1e6));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.cleanup();
		// this.stop();
	}

	private boolean pollEvents() {
		try {
			waitingForEvents = true;
			Thread.sleep(POLL_EVENT_TIMEOUT);
			return Thread.interrupted();
		} catch (InterruptedException e) {
			return false;
		}
	}

	private void renderRun() {
		this.window.takeGLContext();

		try {
			running = true;
			this.gameLogic.register(this);
			this.gameLogic.init(this);
			updateThread.interrupt();
			mainThread.interrupt();

			this.targetFps = this.window.getOptions().fps;
			final long targetPerFps = (long) (1e9 / this.targetFps);
			long lastTime = System.nanoTime(); // nanos
			float timeUps = this.targetFps > 0 ? 1e9f / this.targetFps : 0;

			while (this.shouldRun()) {
				long now = System.nanoTime();

				long deltaRender = now - lastTime;
				if (deltaRender > timeUps) {
					synchronized (waitForFrameStart) {
						waitForFrameStart.notifyAll(); // wake up waiting threads
					}

					long loopStart = System.nanoTime();
					this.gameLogic.render(deltaRender / 1e9f);
					this.window.swapBuffers();

					lastTime = now;

					this.currentFps = (double) 1 / ((double) deltaRender / 1e9);

					synchronized (waitForFrameEnd) {
						waitForFrameEnd.notifyAll(); // wake up waiting threads
					}

					GlobalLogger
							.info("FPS: " + PCUtils.round(this.currentFps, 5) + " delta: "
									+ PCUtils.round(((double) deltaRender / 1_000_000), 5) + "ms renderLoop: "
									+ PCUtils.round(((double) (System.nanoTime() - loopStart) / 1_000_000), 5) + "ms");
				}

				if (this.window.shouldClose()) {
					stop();
					break;
				}

				final long dispatcherBudgetNanos = Math.max(0, targetPerFps - deltaRender);
				renderDispatcher.pump((long) (dispatcherBudgetNanos * 1e6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.cleanup();
		// this.window.clearGLContext();
		// this.stop();
	}

	public void start() {
		if (running)
			throw new IllegalStateException("Already running");

		this.cache = new SharedCacheManager("GameEngineMain");
		MaterialFactory.INSTANCE = new MaterialFactory(cache);

		GlobalLogger.info("Starting using GLES: " + windowOptions.gles);
		if (windowOptions.gles) {
			new GL_W_GLES30().init();
			this.window = new GLESWindow(this.windowOptions);
		} else {
			new GL_W_GL40().init();
			this.window = new GLWindow(this.windowOptions);
		}

		this.window.runCallbacks();
		this.window.clearGLContext();

		this.mainDispatcher = new Dispatcher();
		this.renderDispatcher = new Dispatcher();
		this.updateDispatcher = new Dispatcher();

		this.threadGroup = new ThreadGroup(getClass().getSimpleName() + "#" + name);

		this.mainThread = Thread.currentThread();
		this.updateThread = new Thread(threadGroup, this::updateRun, threadGroup.getName() + ":update");
		this.renderThread = new Thread(threadGroup, this::renderRun, threadGroup.getName() + ":render");

		this.updateThread.start();
		this.renderThread.start();

		this.waitStop();

		// this.run();
	}

	// in main thread
	private void waitStop() {
		if (!running) {
			try {
				Thread.sleep(Long.MAX_VALUE); // waiting for renderThread to finish GameLogic#init()
				if (!Thread.interrupted()) {
					GlobalLogger.severe("Main thread waiting too long for init");
					return;
				}
			} catch (InterruptedException e) {
				GlobalLogger.info("Main thread interrupted, continuing");
				Thread.currentThread().interrupt();
			}
		}

		while (running) {
			if (waitingForEvents) {
				this.window.pollEvents();
				waitingForEvents = false;
				updateThread.interrupt();
			}

			renderDispatcher.pump(10);
		}

		Thread.interrupted();
		try {
			this.updateThread.join();
			this.renderThread.join();
		} catch (InterruptedException e) {
			GlobalLogger.severe("Main thread interrupted while joining subthreads");
		}

		// this.window.takeGLContext();
		this.cleanup();

		// TimeGraphPlot.main(new String[] {
		// PCUtils.appendFileName(GlobalLogger.getLogger().getLogFile().getPath(),
		// "-time")
		// });
	}

	public void stop() {
		GlobalLogger.getLogger().setForwardContent(true);
		GlobalLogger.getLogger().setMinForwardLevel(Level.ALL);
		GlobalLogger.log();
		GlobalLogger.info("Thread: " + Thread.currentThread().getName() + " stopped GameEngine");
		this.running = false;
	}

	private boolean shouldRun() {
		return this.running && updateThread.isAlive() && renderThread.isAlive();
	}

	@Override
	public String getId() {
		return name;
	}

	public GameLogic getGameLogic() {
		return this.gameLogic;
	}

	public Window getWindow() {
		return this.window;
	}

	public boolean isRunning() {
		return this.running;
	}

	public SharedCacheManager getCache() {
		return this.cache;
	}

	public double getCurrentFps() {
		return currentFps;
	}

	public AudioMaster getAudioMaster() {
		return audioMaster;
	}

	public Dispatcher getMainDispatcher() {
		return mainDispatcher;
	}

	public Dispatcher getRenderDispatcher() {
		return renderDispatcher;
	}

	public Dispatcher getUpdateDispatcher() {
		return updateDispatcher;
	}

	public boolean waitForFrameStart() {
		if (Thread.currentThread().equals(renderThread))
			throw new IllegalAccessError(renderThread.getName() + " cannot wait for itself");

		synchronized (waitForFrameStart) {
			try {
				waitForFrameStart.wait(WAIT_FRAME_START_TIMEOUT);
				return true;
			} catch (InterruptedException e) {
				return true;
			}
		}
	}

	public boolean waitForFrameEnd() {
		if (Thread.currentThread().equals(renderThread))
			throw new IllegalAccessError(renderThread.getName() + " cannot wait for itself");

		synchronized (waitForFrameEnd) {
			try {
				waitForFrameEnd.wait(WAIT_FRAME_END_TIMEOUT);
				return true;
			} catch (InterruptedException e) {
				return true;
			}
		}
	}

	public boolean waitForUpdateStart() {
		if (Thread.currentThread().equals(updateThread))
			throw new IllegalAccessError(updateThread.getName() + " cannot wait for itself");

		synchronized (waitForUpdateStart) {
			try {
				waitForUpdateStart.wait(WAIT_UPDATE_START_TIMEOUT);
				return true;
			} catch (InterruptedException e) {
				return true;
			}
		}
	}

	public boolean waitForUpdateEnd() {
		if (Thread.currentThread().equals(updateThread))
			throw new IllegalAccessError(updateThread.getName() + " cannot wait for itself");

		synchronized (waitForUpdateEnd) {
			try {
				waitForUpdateEnd.wait(WAIT_UPDATE_END_TIMEOUT);
				return true;
			} catch (InterruptedException e) {
				return true;
			}
		}
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name);

		if (Thread.currentThread().equals(updateThread)) {
			this.cache.cleanupSounds();
			this.audioMaster.cleanup();
			audioMaster = null;
		} else if (Thread.currentThread().equals(renderThread)) {
			this.cache.cleanup();

			this.window.cleanup();

			DEBUG.cleanup();
		} else if (Thread.currentThread().equals(mainThread)) {
			this.window.cleanupGLFW();
			window = null;

			cache = null;
		}
	}

}
