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
		gameLogic = game;
		windowOptions = options;

		if (GameLogic.INSTANCE != null)
			throw new IllegalStateException("GameLogic was already initialized.");
		GameLogic.INSTANCE = game;
	}

	private void updateRun() {
		try {
			startLatch.await();
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}

		init: {
			audioMaster = new AudioMaster();
			gameLogic.register(this);

			// gameLogic.updateInit();
		}

		try {

			targetUps = window.getOptions().ups;
			final long targetPerUps = (long) (1e9 / targetUps);
			long lastTime = System.nanoTime(); // nanos

			while (shouldRun()) {
				final long now = System.nanoTime();

				final long deltaUpdate = now - lastTime;
				if (deltaUpdate > targetPerUps) {
					synchronized (waitForUpdateStart) {
						waitForUpdateStart.notifyAll();
					}

					pollEvents();
					gameLogic.input(deltaUpdate / 1e9f);
					window.clearScroll();

					gameLogic.update(deltaUpdate / 1e9f);

					lastTime = now;

					synchronized (waitForUpdateEnd) {
						waitForUpdateEnd.notifyAll();
					}

					final long dispatcherBudgetNanos = Math.max(MIN_UPDATE_DISPATCHER_BUDGET_NANO, targetPerUps - deltaUpdate);
					updateDispatcher.pump((long) (dispatcherBudgetNanos * 1e6));
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			cleanup();
		}
	}

	private void pollEvents() {
		try {
			waitingForEvents = true;
			synchronized (waitingForEventsLock) {
				waitingForEventsLock.wait(POLL_EVENT_TIMEOUT);
			}
		} catch (final InterruptedException e) {
		}
	}

	private void renderRun() {
		window.takeGLContext();

		try {
			running = true;
			gameLogic.register(this);
			try {
				gameLogic.init();
			} catch (final Exception e) {
				throw new Exception("Caught exception in init method. Stopping.", e);
			}
			startLatch.countDown();

			targetFps = window.getOptions().fps;
			final long targetNanoPerFps = (long) (1e9 / targetFps);
			long lastFrameTime = System.nanoTime();
			final List<String> tasks = new ArrayList<>();

			while (shouldRun()) {
				final long currentTime = System.nanoTime();
				final long nanoTimeSinceLastFrame = currentTime - lastFrameTime;

				if (nanoTimeSinceLastFrame >= targetNanoPerFps) {
					synchronized (waitForFrameStart) {
						waitForFrameStart.notifyAll();
					}

					final long frameStartTime = System.nanoTime();

					// Render the game
					final float deltaSeconds = nanoTimeSinceLastFrame / 1e9f;
					gameLogic.render(deltaSeconds);
					window.swapBuffers();

					// Update frame timing
					lastFrameTime = currentTime;
					currentFps = 1.0 / deltaSeconds;

					synchronized (waitForFrameEnd) {
						waitForFrameEnd.notifyAll();
					}

					final long frameRenderDurationNano = System.nanoTime() - frameStartTime;
					final double frameRenderDurationMs = (double) frameRenderDurationNano / 1_000_000;
					final long dispatcherTimeBudgetNanos = Math.max(MIN_RENDER_DISPATCHER_BUDGET_NANO,
							targetNanoPerFps - frameRenderDurationNano);

					// Pump the render dispatcher
					final long dispatcherStartNano = System.nanoTime();
					renderDispatcher.pump((long) (dispatcherTimeBudgetNanos * 0.9f), tasks);
					final long dispatcherUsedNano = System.nanoTime() - dispatcherStartNano;

					if (DEBUG_RENDER_REPORT)
						GlobalLogger.info("FPS: " + PCUtils.roundFill(currentFps, 5) + " | Delta: "
								+ PCUtils.roundFill(nanoTimeSinceLastFrame / 1_000_000.0, 5) + " ms" + " | Render loop: "
								+ PCUtils.roundFill(frameRenderDurationMs, 5) + " ms | Dispatcher budget: "
								+ PCUtils.roundFill((double) dispatcherTimeBudgetNanos / 1e6, 5) + " ms | Used: "
								+ PCUtils.roundFill((double) dispatcherUsedNano / 1e6, 5) + " ms (" + tasks.size() + ") "
								+ PCUtils.progressBar(dispatcherTimeBudgetNanos, dispatcherUsedNano, true) + " " + tasks);
				}

				// Stop loop if window requests closure
				if (window.shouldClose()) {
					stop();
					break;
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			running = false;
			cleanup();
		}
	}

	public void start() {
		if (running)
			throw new IllegalStateException("Already running");

		cache = new SharedCacheManager("GameEngineMain");
		MaterialFactory.INSTANCE = new MaterialFactory(cache);

		GlobalLogger.info("Starting using GLES: " + windowOptions.gles);
		if (windowOptions.logging && windowOptions.debug) {
			if (windowOptions.gles)
				new GL_W_GLES30_LoggingDebug().init();
			else
				new GL_W_GL46_LoggingDebug().init();
		} else if (windowOptions.debug) {
			if (windowOptions.gles)
				new GL_W_GLES30_Debug().init();
			else
				new GL_W_GL46_Debug().init();
		} else if (windowOptions.logging) {
			if (windowOptions.gles)
				new GL_W_GLES30_Logging().init();
			else
				new GL_W_GL46_Logging().init();
		} else if (windowOptions.gles)
			new GL_W_GLES30().init();
		else
			new GL_W_GL46().init();

		// new GL_W_GL46_LoggingDebugFlush().init();
		// new GL_W_GL46_LoggingDebugSync().init();

		if (windowOptions.gles)
			window = new GLESWindow(windowOptions);
		else
			window = new GLWindow(windowOptions);

		window.runResizeCallbacks();
		window.clearGLContext();

		mainDispatcher = new Dispatcher("main");
		renderDispatcher = new Dispatcher("render");
		updateDispatcher = new Dispatcher("update");

		threadGroup = new ThreadGroup(this.getClass().getSimpleName() + "#" + name);

		mainThread = Thread.currentThread();
		updateThread = new Thread(threadGroup, this::updateRun, threadGroup.getName() + ":update");
		updateThread.setDaemon(true);
		renderThread = new Thread(threadGroup, this::renderRun, threadGroup.getName() + ":render");
		renderThread.setDaemon(true);

		updateThread.start();
		renderThread.start();

		mainRun();

		// this.run();
	}

	// in main thread
	private void mainRun() {
		try {
			startLatch.await();
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}

		try {
			while (running) {
				if (waitingForEvents) {
					window.pollEvents();
					waitingForEvents = false;
					synchronized (waitingForEventsLock) {
						waitingForEventsLock.notifyAll();
					}
				}

				totalTime = GLFW.glfwGetTime();

				gameLogic.main();

				mainDispatcher.pump(10);
			}
		} finally {
			Thread.interrupted();
			try {
				updateThread.join();
				renderThread.join();
			} catch (final InterruptedException e) {
				GlobalLogger.severe("Main thread interrupted while joining subthreads");
			} finally {
				cleanup();
			}
		}
	}

	public void stop() {
		GlobalLogger.getLogger().setForwardContent(true);
		GlobalLogger.getLogger().setMinForwardLevel(Level.ALL);
		GlobalLogger.log();
		GlobalLogger.info("Thread: " + Thread.currentThread().getName() + " stopped GameEngine");
		running = false;
	}

	private boolean shouldRun() {
		return running && updateThread.isAlive() && renderThread.isAlive();
	}

	@Override
	public String getId() {
		return name;
	}

	public GameLogic getGameLogic() {
		return gameLogic;
	}

	public Window getWindow() {
		return window;
	}

	public boolean isRunning() {
		return running;
	}

	public SharedCacheManager getCache() {
		return cache;
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

	public Thread getMainThread() {
		return mainThread;
	}

	public Thread getRenderThread() {
		return renderThread;
	}

	public Thread getUpdateThread() {
		return updateThread;
	}

	public double getTotalTime() {
		return totalTime;
	}

	public boolean waitForFrameStart() {
		if (Thread.currentThread().equals(renderThread))
			throw new IllegalAccessError(renderThread.getName() + " cannot wait for itself");

		synchronized (waitForFrameStart) {
			try {
				waitForFrameStart.wait(WAIT_FRAME_START_TIMEOUT);
				return true;
			} catch (final InterruptedException e) {
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
			} catch (final InterruptedException e) {
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
			} catch (final InterruptedException e) {
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
			} catch (final InterruptedException e) {
				return true;
			}
		}
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name);

		if (Thread.currentThread().equals(updateThread)) {
			cache.cleanupSounds();
			AutoCleanupable.cleanupAL();
			audioMaster.cleanup();
			audioMaster = null;
		} else if (Thread.currentThread().equals(renderThread)) {
			cache.cleanup();
			AutoCleanupable.cleanupGL();
			gameLogic.cleanup();
			window.cleanup();
		} else if (Thread.currentThread().equals(mainThread)) {
			window.cleanupGLFW();
			window = null;

			cache = null;
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
