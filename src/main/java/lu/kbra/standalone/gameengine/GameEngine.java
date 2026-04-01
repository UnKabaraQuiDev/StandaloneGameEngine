package lu.kbra.standalone.gameengine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;

import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.lwjgl.glfw.GLFW;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.audio.AudioMaster;
import lu.kbra.standalone.gameengine.cache.SharedCacheManager;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.base.GL_W_GL46;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.base.GL_W_GLES30;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.debug.GL_W_GL46_Debug;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.debug.GL_W_GLES30_Debug;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.logging.GL_W_GL46_Logging;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.logging.GL_W_GLES30_Logging;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.logging_debug.GL_W_GL46_LoggingDebug;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.logging_debug.GL_W_GLES30_LoggingDebug;
import lu.kbra.standalone.gameengine.graph.MaterialFactory;
import lu.kbra.standalone.gameengine.graph.window.GLESWindow;
import lu.kbra.standalone.gameengine.graph.window.GLWindow;
import lu.kbra.standalone.gameengine.graph.window.Window;
import lu.kbra.standalone.gameengine.graph.window.WindowOptions;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GameLogic;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.impl.future.Dispatcher;

public final class GameEngine implements Cleanupable, UniqueID {

	public static final String DEBUG_RENDER_REPORT_PROPERTY = GameEngine.class.getSimpleName() + ".debug_render_report";
	public static boolean DEBUG_RENDER_REPORT = Boolean.getBoolean(DEBUG_RENDER_REPORT_PROPERTY);

	public static final String MIN_RENDER_DISPATCHER_BUDGET_NANO_PROPERTY = GameEngine.class.getSimpleName()
			+ ".min_render_dispatcher_budget_nano";
	public static long MIN_RENDER_DISPATCHER_BUDGET_NANO = Long.getLong(MIN_RENDER_DISPATCHER_BUDGET_NANO_PROPERTY, 500_000);

	public static final String MIN_UPDATE_DISPATCHER_BUDGET_NANO_PROPERTY = GameEngine.class.getSimpleName()
			+ ".min_update_dispatcher_budget_nano";
	public static long MIN_UPDATE_DISPATCHER_BUDGET_NANO = Long.getLong(MIN_UPDATE_DISPATCHER_BUDGET_NANO_PROPERTY, 500_000);

	public static final Vector3fc X_POS = new Vector3f(1, 0, 0), X_NEG = new Vector3f(-1, 0, 0), Y_POS = new Vector3f(0, 1, 0),
			Y_NEG = new Vector3f(0, -1, 0), Z_POS = new Vector3f(0, 0, 1), Z_NEG = new Vector3f(0, 0, -1), ZERO = new Vector3f(0);

	public static final Vector3fc UP = new Vector3f(Y_POS), DOWN = new Vector3f(Z_NEG), LEFT = new Vector3f(X_NEG),
			RIGHT = new Vector3f(X_POS), FORWARD = new Vector3f(Z_POS), BACK = new Vector3f(X_POS);

	public static final Vector2fc IDENTITY_VECTOR2F = new Vector2f(1);
	public static final Vector3fc IDENTITY_VECTOR3F = new Vector3f(1);
	public static final Vector2ic IDENTITY_VECTOR2I = new Vector2i(1);
	public static final Vector3ic IDENTITY_VECTOR3I = new Vector3i(1);
	public static final Matrix4fc IDENTITY_MATRIX4F = new Matrix4f().identity();
	public static final Quaternionfc IDENTITY_QUATERNIONF = new Quaternionf().identity();

	public static final long POLL_EVENT_TIMEOUT = 500, BUFFER_SWAP_TIMEOUT = 500, WAIT_FRAME_END_TIMEOUT = 500,
			WAIT_FRAME_START_TIMEOUT = 500, WAIT_UPDATE_END_TIMEOUT = 500, WAIT_UPDATE_START_TIMEOUT = 500; // ms

	public static final int QUEUE_MAIN = 0, QUEUE_RENDER = 1, QUEUE_UPDATE = 2;

	private final String name;

	private final WindowOptions windowOptions;
	private Window window;
	private AudioMaster audioMaster;
	private final GameLogic gameLogic;

	private volatile boolean running = false;
	private volatile boolean waitingForEvents = false;
	private final Object waitingForEventsLock = new Object();
	private final CountDownLatch startLatch = new CountDownLatch(1);
	private volatile double totalTime = 0d;

	public int targetUps, targetFps;
	private double currentFps;

	private SharedCacheManager cache;

	private Dispatcher mainDispatcher, renderDispatcher, updateDispatcher;
	private ThreadGroup threadGroup;
	private Thread renderThread, updateThread, mainThread;

	private final Object waitForFrameEnd = new Object(), waitForUpdateEnd = new Object(), waitForFrameStart = new Object(),
			waitForUpdateStart = new Object();

	public GameEngine(final String name, final GameLogic game, final WindowOptions options) {
		this.name = name;
		this.gameLogic = game;
		this.windowOptions = options;

		if (GameLogic.INSTANCE != null) {
			throw new IllegalStateException("GameLogic was already initialized.");
		}
		GameLogic.INSTANCE = game;
	}

	private void updateRun() {
		try {
			this.startLatch.await();
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}

		init: {
			this.audioMaster = new AudioMaster();
			this.gameLogic.register(this);

//			gameLogic.updateInit();
		}

		try {

			this.targetUps = this.window.getOptions().ups;
			final long targetPerUps = (long) (1e9 / this.targetUps);
			long lastTime = System.nanoTime(); // nanos

			while (this.shouldRun()) {
				final long now = System.nanoTime();

				final long deltaUpdate = now - lastTime;
				if (deltaUpdate > targetPerUps) {
					synchronized (this.waitForUpdateStart) {
						this.waitForUpdateStart.notifyAll();
					}

					this.pollEvents();
					this.gameLogic.input(deltaUpdate / 1e9f);
					this.window.clearScroll();

					this.gameLogic.update(deltaUpdate / 1e9f);

					lastTime = now;

					synchronized (this.waitForUpdateEnd) {
						this.waitForUpdateEnd.notifyAll();
					}

					final long dispatcherBudgetNanos = Math.max(MIN_UPDATE_DISPATCHER_BUDGET_NANO, targetPerUps - deltaUpdate);
					this.updateDispatcher.pump((long) (dispatcherBudgetNanos * 1e6));
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			this.cleanup();
		}
	}

	private void pollEvents() {
		try {
			this.waitingForEvents = true;
			synchronized (this.waitingForEventsLock) {
				this.waitingForEventsLock.wait(POLL_EVENT_TIMEOUT);
			}
		} catch (final InterruptedException e) {
		}
	}

	private void renderRun() {
		this.window.takeGLContext();

		try {
			this.running = true;
			this.gameLogic.register(this);
			try {
				this.gameLogic.init();
			} catch (final Exception e) {
				throw new Exception("Caught exception in init method. Stopping.", e);
			}
			this.startLatch.countDown();

			this.targetFps = this.window.getOptions().fps;
			final long targetNanoPerFps = (long) (1e9 / this.targetFps);
			long lastFrameTime = System.nanoTime();
			final List<String> tasks = new ArrayList<>();

			while (this.shouldRun()) {
				final long currentTime = System.nanoTime();
				final long nanoTimeSinceLastFrame = currentTime - lastFrameTime;

				if (nanoTimeSinceLastFrame >= targetNanoPerFps) {
					synchronized (this.waitForFrameStart) {
						this.waitForFrameStart.notifyAll();
					}

					final long frameStartTime = System.nanoTime();

					// Render the game
					final float deltaSeconds = nanoTimeSinceLastFrame / 1e9f;
					this.gameLogic.render(deltaSeconds);
					this.window.swapBuffers();

					// Update frame timing
					lastFrameTime = currentTime;
					this.currentFps = 1.0 / deltaSeconds;

					synchronized (this.waitForFrameEnd) {
						this.waitForFrameEnd.notifyAll();
					}

					final long frameRenderDurationNano = System.nanoTime() - frameStartTime;
					final double frameRenderDurationMs = (double) frameRenderDurationNano / 1_000_000;
					final long dispatcherTimeBudgetNanos = Math.max(MIN_RENDER_DISPATCHER_BUDGET_NANO,
							targetNanoPerFps - frameRenderDurationNano);

					// Pump the render dispatcher
					final long dispatcherStartNano = System.nanoTime();
					this.renderDispatcher.pump((long) (dispatcherTimeBudgetNanos * 0.9f), tasks);
					final long dispatcherUsedNano = System.nanoTime() - dispatcherStartNano;

					if (DEBUG_RENDER_REPORT) {
						GlobalLogger.info("FPS: " + PCUtils.roundFill(this.currentFps, 5) + " | Delta: "
								+ PCUtils.roundFill(nanoTimeSinceLastFrame / 1_000_000.0, 5) + " ms" + " | Render loop: "
								+ PCUtils.roundFill(frameRenderDurationMs, 5) + " ms | Dispatcher budget: "
								+ PCUtils.roundFill((double) dispatcherTimeBudgetNanos / 1e6, 5) + " ms | Used: "
								+ PCUtils.roundFill((double) dispatcherUsedNano / 1e6, 5) + " ms (" + tasks.size() + ") "
								+ PCUtils.progressBar(dispatcherTimeBudgetNanos, dispatcherUsedNano, true) + " " + tasks);
					}
				}

				// Stop loop if window requests closure
				if (this.window.shouldClose()) {
					this.stop();
					break;
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			running = false;
			this.cleanup();
		}
	}

	public void start() {
		if (this.running) {
			throw new IllegalStateException("Already running");
		}

		this.cache = new SharedCacheManager("GameEngineMain");
		MaterialFactory.INSTANCE = new MaterialFactory(this.cache);

		GlobalLogger.info("Starting using GLES: " + this.windowOptions.gles);
		if (this.windowOptions.logging && this.windowOptions.debug) {
			if (this.windowOptions.gles) {
				new GL_W_GLES30_LoggingDebug().init();
			} else {
				new GL_W_GL46_LoggingDebug().init();
			}
		} else if (this.windowOptions.debug) {
			if (this.windowOptions.gles) {
				new GL_W_GLES30_Debug().init();
			} else {
				new GL_W_GL46_Debug().init();
			}
		} else if (this.windowOptions.logging) {
			if (this.windowOptions.gles) {
				new GL_W_GLES30_Logging().init();
			} else {
				new GL_W_GL46_Logging().init();
			}
		} else {
			if (this.windowOptions.gles) {
				new GL_W_GLES30().init();
			} else {
				new GL_W_GL46().init();
			}
		}

		// new GL_W_GL46_LoggingDebugFlush().init();
		// new GL_W_GL46_LoggingDebugSync().init();

		if (this.windowOptions.gles) {
			this.window = new GLESWindow(this.windowOptions);
		} else {
			this.window = new GLWindow(this.windowOptions);
		}

		this.window.runCallbacks();
		this.window.clearGLContext();

		this.mainDispatcher = new Dispatcher("main");
		this.renderDispatcher = new Dispatcher("render");
		this.updateDispatcher = new Dispatcher("update");

		this.threadGroup = new ThreadGroup(this.getClass().getSimpleName() + "#" + this.name);

		this.mainThread = Thread.currentThread();
		this.updateThread = new Thread(this.threadGroup, this::updateRun, this.threadGroup.getName() + ":update");
		this.updateThread.setDaemon(true);
		this.renderThread = new Thread(this.threadGroup, this::renderRun, this.threadGroup.getName() + ":render");
		this.renderThread.setDaemon(true);

		this.updateThread.start();
		this.renderThread.start();

		this.mainRun();

		// this.run();
	}

	// in main thread
	private void mainRun() {
		try {
			this.startLatch.await();
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}

		while (this.running) {
			if (this.waitingForEvents) {
				this.window.pollEvents();
				this.waitingForEvents = false;
				synchronized (this.waitingForEventsLock) {
					this.waitingForEventsLock.notifyAll();
				}
			}

			this.totalTime = GLFW.glfwGetTime();

			this.gameLogic.main();

			// TODO: enable main dispatcher ?
			this.mainDispatcher.pump(10);
		}

		Thread.interrupted();
		try {
			this.updateThread.join();
			this.renderThread.join();
		} catch (final InterruptedException e) {
			GlobalLogger.severe("Main thread interrupted while joining subthreads");
		} finally {
			this.cleanup();
		}
	}

	public void stop() {
		GlobalLogger.getLogger().setForwardContent(true);
		GlobalLogger.getLogger().setMinForwardLevel(Level.ALL);
		GlobalLogger.log();
		GlobalLogger.info("Thread: " + Thread.currentThread().getName() + " stopped GameEngine");
		this.running = false;
	}

	private boolean shouldRun() {
		return this.running && this.updateThread.isAlive() && this.renderThread.isAlive();
	}

	@Override
	public String getId() {
		return this.name;
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
		return this.currentFps;
	}

	public AudioMaster getAudioMaster() {
		return this.audioMaster;
	}

	public Dispatcher getMainDispatcher() {
		return this.mainDispatcher;
	}

	public Dispatcher getRenderDispatcher() {
		return this.renderDispatcher;
	}

	public Dispatcher getUpdateDispatcher() {
		return this.updateDispatcher;
	}

	public Thread getMainThread() {
		return this.mainThread;
	}

	public Thread getRenderThread() {
		return this.renderThread;
	}

	public Thread getUpdateThread() {
		return this.updateThread;
	}

	public double getTotalTime() {
		return this.totalTime;
	}

	public boolean waitForFrameStart() {
		if (Thread.currentThread().equals(this.renderThread)) {
			throw new IllegalAccessError(this.renderThread.getName() + " cannot wait for itself");
		}

		synchronized (this.waitForFrameStart) {
			try {
				this.waitForFrameStart.wait(WAIT_FRAME_START_TIMEOUT);
				return true;
			} catch (final InterruptedException e) {
				return true;
			}
		}
	}

	public boolean waitForFrameEnd() {
		if (Thread.currentThread().equals(this.renderThread)) {
			throw new IllegalAccessError(this.renderThread.getName() + " cannot wait for itself");
		}

		synchronized (this.waitForFrameEnd) {
			try {
				this.waitForFrameEnd.wait(WAIT_FRAME_END_TIMEOUT);
				return true;
			} catch (final InterruptedException e) {
				return true;
			}
		}
	}

	public boolean waitForUpdateStart() {
		if (Thread.currentThread().equals(this.updateThread)) {
			throw new IllegalAccessError(this.updateThread.getName() + " cannot wait for itself");
		}

		synchronized (this.waitForUpdateStart) {
			try {
				this.waitForUpdateStart.wait(WAIT_UPDATE_START_TIMEOUT);
				return true;
			} catch (final InterruptedException e) {
				return true;
			}
		}
	}

	public boolean waitForUpdateEnd() {
		if (Thread.currentThread().equals(this.updateThread)) {
			throw new IllegalAccessError(this.updateThread.getName() + " cannot wait for itself");
		}

		synchronized (this.waitForUpdateEnd) {
			try {
				this.waitForUpdateEnd.wait(WAIT_UPDATE_END_TIMEOUT);
				return true;
			} catch (final InterruptedException e) {
				return true;
			}
		}
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + this.name);

		if (Thread.currentThread().equals(this.updateThread)) {
			this.cache.cleanupSounds();
			AutoCleanupable.cleanupAL();
			this.audioMaster.cleanup();
			this.audioMaster = null;
		} else if (Thread.currentThread().equals(this.renderThread)) {
			this.cache.cleanup();
			AutoCleanupable.cleanupGL();
			this.gameLogic.cleanup();
			this.window.cleanup();
		} else if (Thread.currentThread().equals(this.mainThread)) {
			this.window.cleanupGLFW();
			this.window = null;

			this.cache = null;
		}
	}

	@Override
	public String toString() {
		return "GameEngine@" + System.identityHashCode(this) + " [name=" + name + ", windowOptions=" + windowOptions + ", window=" + window
				+ ", audioMaster=" + audioMaster + ", gameLogic=" + gameLogic + ", running=" + running + ", waitingForEvents="
				+ waitingForEvents + ", waitingForEventsLock=" + waitingForEventsLock + ", startLatch=" + startLatch + ", totalTime="
				+ totalTime + ", targetUps=" + targetUps + ", targetFps=" + targetFps + ", currentFps=" + currentFps + ", cache=" + cache
				+ ", mainDispatcher=" + mainDispatcher + ", renderDispatcher=" + renderDispatcher + ", updateDispatcher=" + updateDispatcher
				+ ", threadGroup=" + threadGroup + ", renderThread=" + renderThread + ", updateThread=" + updateThread + ", mainThread="
				+ mainThread + ", waitForFrameEnd=" + waitForFrameEnd + ", waitForUpdateEnd=" + waitForUpdateEnd + ", waitForFrameStart="
				+ waitForFrameStart + ", waitForUpdateStart=" + waitForUpdateStart + "]";
	}

}
