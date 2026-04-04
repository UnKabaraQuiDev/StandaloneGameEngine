package lu.kbra.standalone.gameengine.graph.window;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.logging.Level;

import org.joml.Vector2d;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector4f;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCharCallbackI;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
import org.lwjgl.glfw.GLFWGamepadState;
import org.lwjgl.glfw.GLFWJoystickCallback;
import org.lwjgl.glfw.GLFWJoystickCallbackI;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.gl.consts.GLType;

public abstract class Window implements Cleanupable {

	public static final String DEBUG_ESCAPE_TO_CLOSE_PROPERTY = Window.class.getSimpleName() + ".debug_escape_to_close";
	public static boolean DEBUG_ESCAPE_TO_CLOSE = Boolean.getBoolean(Window.DEBUG_ESCAPE_TO_CLOSE_PROPERTY);

	public static final String GL_DEBUG_OUTPUT_PROPERTY = Window.class.getSimpleName() + ".gl_debug_output";
	public static boolean GL_DEBUG_OUTPUT = Boolean.getBoolean(Window.GL_DEBUG_OUTPUT_PROPERTY);
	public static final String GL_FAIL_ON_ERROR_PROPERTY = Window.class.getSimpleName() + ".gl_fail_on_error";
	public static boolean GL_FAIL_ON_ERROR = Boolean.getBoolean(Window.GL_FAIL_ON_ERROR_PROPERTY);

	public static final String GLFW_DEBUG_OUTPUT_PROPERTY = Window.class.getSimpleName() + ".glfw_debug_output";
	public static boolean GLFW_DEBUG_OUTPUT = Boolean.getBoolean(Window.GLFW_DEBUG_OUTPUT_PROPERTY);
	public static final String GLFW_FAIL_ON_ERROR_PROPERTY = Window.class.getSimpleName() + ".glfw_fail_on_error";
	public static boolean GLFW_FAIL_ON_ERROR = Boolean.getBoolean(Window.GLFW_FAIL_ON_ERROR_PROPERTY);

	protected GLType glType;

	// Window options
	protected WindowOptions options;

	protected long monitor;
	protected long handle;
	protected Thread ownerThread;

	protected GLFWGamepadState gamepadState;

	protected Vector4f background = new Vector4f(0, 0.1f, 0, 1);

	// Callbacks
	protected BiConsumer<Integer, Integer> onResize;

	protected KeyState[] keyStates = new KeyState[GLFW.GLFW_KEY_LAST + 1];
	protected GLFWKeyCallback keyCallback;
	protected Map<Integer, Boolean> connectedGamepads = new ConcurrentHashMap<>();
	protected Map<Integer, GLFWGamepadState> gamepadStates = new ConcurrentHashMap<>();
	protected GLFWJoystickCallback joystickCallback;
	protected GLFWFramebufferSizeCallback frameBufferCallback;
	protected GLFWErrorCallback errorCallback;
	protected Vector2d scroll = new Vector2d();
	protected GLFWScrollCallback scrollCallback;
	protected Vector2f cursorPosition = new Vector2f();
	protected GLFWCursorPosCallback cursorPosCallback;
	protected KeyState[] mouseButtonStates = new KeyState[GLFW.GLFW_MOUSE_BUTTON_LAST + 1];
	protected GLFWMouseButtonCallback mouseButtonCallback;
	protected Character character;
	protected GLFWCharCallback charCallback;

	protected int width;
	protected int height;

	public Window(final GLType glType, final WindowOptions options) {
		this.glType = glType;
		this.options = options;
		this.ownerThread = Thread.currentThread();

		Arrays.fill(this.keyStates, KeyState.RELEASE);
		Arrays.fill(this.mouseButtonStates, KeyState.RELEASE);

		if (Window.GLFW_DEBUG_OUTPUT) {
			if (Window.GLFW_FAIL_ON_ERROR) {
				this.errorCallback = GLFWErrorCallback.createPrint(System.err);
			} else {
				this.errorCallback = GLFWErrorCallback.createThrow();
			}
			GLFW.glfwSetErrorCallback(this.errorCallback);
		}

		this.init();
	}

	protected abstract void init();

	public abstract void cleanupGLFW();

	public void clearGLContext() {
		GLFW.glfwMakeContextCurrent(MemoryUtil.NULL);
	}

	public abstract void takeGLContext();

	protected long getQualifiedMonitor() {
		long monitor = GLFW.glfwGetPrimaryMonitor();
		if (monitor == MemoryUtil.NULL) {
			final PointerBuffer ptb = GLFW.glfwGetMonitors();
			if (!ptb.hasRemaining()) {
				throw new RuntimeException("No primary monitor found");
			}
			monitor = ptb.get();
			ptb.free();
		}
		return monitor;
	}

	protected void createCallbacks() {
		this.keyCallback = GLFWKeyCallback.create((GLFWKeyCallbackI) this::callback_key);
		GLFW.glfwSetKeyCallback(this.handle, this.keyCallback);

		this.joystickCallback = GLFWJoystickCallback.create((GLFWJoystickCallbackI) this::callback_joystick);
		GLFW.glfwSetJoystickCallback(this.joystickCallback);

		this.frameBufferCallback = GLFWFramebufferSizeCallback.create((GLFWFramebufferSizeCallbackI) this::callback_frameBuffer);
		GLFW.glfwSetFramebufferSizeCallback(this.handle, this.frameBufferCallback);

		this.scrollCallback = GLFWScrollCallback.create((GLFWScrollCallbackI) this::callback_scroll);
		GLFW.glfwSetScrollCallback(this.handle, this.scrollCallback);

		this.cursorPosCallback = GLFWCursorPosCallback.create((GLFWCursorPosCallbackI) this::callback_cursor_pos);
		GLFW.glfwSetCursorPosCallback(this.handle, this.cursorPosCallback);

		this.mouseButtonCallback = GLFWMouseButtonCallback.create((GLFWMouseButtonCallbackI) this::callback_mouse_button);
		GLFW.glfwSetMouseButtonCallback(this.handle, this.mouseButtonCallback);

		this.charCallback = GLFWCharCallback.create((GLFWCharCallbackI) this::callback_char);
		GLFW.glfwSetCharCallback(this.handle, this.charCallback);
	}

	protected void callback_char(final long window, final int codepoint) {
		if (codepoint > 0) {
			this.character = (char) codepoint;
		}
	}

	protected void callback_mouse_button(final long window, final int button, final int action, final int mods) {
		if (button >= 0 && button < this.mouseButtonStates.length) {
			if (action == GLFW.GLFW_PRESS) {
				this.mouseButtonStates[button] = KeyState.PRESS;
			} else if (action == GLFW.GLFW_RELEASE) {
				this.mouseButtonStates[button] = KeyState.RELEASE;
			}
		} else {
			GlobalLogger.severe("Unsupported mouse button: " + button);
		}
	}

	protected void callback_cursor_pos(final long window, final double sx, final double sy) {
		this.cursorPosition.set(sx, sy);
	}

	protected void callback_scroll(final long window, final double sx, final double sy) {
		if (window != this.handle) {
			return;
		}
		this.scroll.add(sx, sy);
	}

	protected void callback_frameBuffer(final long window, final int w, final int h) {
		if (window != this.handle) {
			return;
		}
//		if (!this.options.windowMode) {
//			this.options.windowSize.set(w, h);
//		}
		if (this.onResize != null) {
			this.onResize.accept(w, h);
		}
//		GL_W.glViewport(0, 0, w, h);
		this.width = w;
		this.height = h;
	}

	protected void callback_joystick(final int jid, final int event) {
		if (event == GLFW.GLFW_CONNECTED) {
			final boolean isGamepad = GLFW.glfwJoystickIsGamepad(jid);
			this.connectedGamepads.put(jid, isGamepad);
			if (isGamepad) {
				final GLFWGamepadState state = GLFWGamepadState.create();
				this.gamepadStates.put(jid, state);
			}
			GlobalLogger.log(Level.INFO,
					"Joystick connected: jid:" + jid + ", name:" + GLFW.glfwGetJoystickName(jid) + ", guid:" + GLFW.glfwGetJoystickGUID(jid)
							+ " -> name:" + GLFW.glfwGetGamepadName(jid) + ", joystick as gamepad:" + GLFW.glfwJoystickIsGamepad(jid));
		} else if (event == GLFW.GLFW_DISCONNECTED) {
			this.connectedGamepads.remove(jid);
			this.gamepadStates.remove(jid);
			GlobalLogger.log(Level.INFO, "Joystick disconnected: jid:" + jid);
		}
	}

	protected void callback_key(final long window, final int key, final int scancode, final int action, final int mods) {
		if (window != this.handle) {
			return;
		}

		if (Window.DEBUG_ESCAPE_TO_CLOSE && key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_PRESS) {
			this.setWindowShouldClose(true);
		} else if (key == GLFW.GLFW_KEY_F11 && action == GLFW.GLFW_PRESS) {
			this.options.windowMode = this.options.windowMode.next();
			GlobalLogger.info("Switched window mode to: " + this.options.windowMode);
			this.updateOptions();
		}

		if (key > 0 && key < this.keyStates.length) {
			this.keyStates[key] = KeyState.byGLFWId(action);
		}
	}

	public void postPollEvents() {
		this.pollGamePadStates();
	}

	protected void pollGamePadStates() {
		for (final Map.Entry<Integer, Boolean> entry : this.connectedGamepads.entrySet()) {
			final int jid = entry.getKey();
			if (!entry.getValue()) {
				return;
			}
			final GLFWGamepadState state = this.gamepadStates.get(jid);
			final boolean isValid = GLFW.glfwGetGamepadState(jid, state);
			if (!isValid) {
				this.connectedGamepads.put(entry.getKey(), false);
				this.gamepadStates.remove(entry.getKey());
			}
		}
	}

	public void setWindowShouldClose(final boolean b) {
		GLFW.glfwSetWindowShouldClose(this.handle, b);
	}

	@Deprecated
	public boolean isJoystickPresent() {
		assert Thread.currentThread() == this.ownerThread;
		return GLFW.glfwJoystickPresent(GLFW.GLFW_JOYSTICK_1);
	}

	@Deprecated
	public float[] getJoystickAxis(final int jid) {
		assert Thread.currentThread() == this.ownerThread;
		final FloatBuffer fb = GLFW.glfwGetJoystickAxes(jid);
		final float[] bb = new float[fb.remaining()];
		fb.get(bb);
		return bb;
	}

	@Deprecated
	public float getJoystickAxis(final int jid, final int axis) {
		assert Thread.currentThread() == this.ownerThread;
		final FloatBuffer fb = GLFW.glfwGetJoystickAxes(jid);
		final float[] bb = new float[fb.remaining()];
		fb.get(bb);
		return bb[axis];
	}

	@Deprecated
	public boolean getJoystickButton(final int jid, final int btn) {
		assert Thread.currentThread() == this.ownerThread;
		final ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		final byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb[btn] == GLFW.GLFW_PRESS;
	}

	@Deprecated
	public byte[] getJoystickButtonsArray(final int jid) {
		assert Thread.currentThread() == this.ownerThread;
		final ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		final byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb;
	}

	@Deprecated
	public ByteBuffer getJoystickButtons(final int jid) {
		assert Thread.currentThread() == this.ownerThread;
		return GLFW.glfwGetJoystickButtons(jid);
	}

	@Deprecated
	public byte getJoystickHat(final int jid, final int hat) {
		assert Thread.currentThread() == this.ownerThread;
		final ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		final byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb[hat];
	}

	@Deprecated
	public boolean isMouseButtonPressed(final int mbid) {
		assert Thread.currentThread() == this.ownerThread;
		return GLFW.glfwGetMouseButton(this.handle, mbid) == GLFW.GLFW_PRESS;
	}

	public KeyState getMouseButtonState(final int mbid) {
		return this.mouseButtonStates[mbid];
	}

	public Vector2f getMousePosition() {
		return this.cursorPosition;
	}

	public boolean getJoystickHat(final int jid, final int hat, final byte state) {
		return this.getJoystickHat(jid, hat) == state;
	}

	public ByteBuffer getJoystickHats(final int jid) {
		return GLFW.glfwGetJoystickHats(jid);
	}

	public GLFWGamepadState getGamepad() {
		return this.gamepadState;
	}

	@Deprecated
	public boolean isKeyPressed(final int code) {
		assert Thread.currentThread() == this.ownerThread;
		return GLFW.glfwGetKey(this.handle, code) == GLFW.GLFW_PRESS;
	}

	public KeyState getKeyState(final int code) {
		return this.keyStates[code];
	}

	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(this.handle);
	}

	public void swapBuffers() {
		if (this.handle == MemoryUtil.NULL) {
			throw new IllegalStateException("Window wasn't initialized");
		}
		GL_W.glBindFramebuffer(GL_W.GL_FRAMEBUFFER, 0);
		GLFW.glfwSwapBuffers(this.handle);
	}

	public void pollEvents() {
		assert Thread.currentThread() == this.ownerThread;
		GLFW.glfwPollEvents();
	}

	@Deprecated
	public boolean updateGamepad(final int jid) {
		assert Thread.currentThread() == this.ownerThread;
		return GLFW.glfwGetGamepadState(jid, this.gamepadState);
	}

	public void updateOptions() {
		assert Thread.currentThread() == this.ownerThread;

		GLFW.glfwSwapInterval(this.options.vsync ? 1 : 0);

		final GLFWVidMode vidMode = GLFW.glfwGetVideoMode(this.monitor);

		switch (this.options.windowMode) {

		case WINDOWED -> {
			GLFW.glfwSetWindowAttrib(this.handle, GLFW.GLFW_DECORATED, GLFW.GLFW_TRUE);

			GLFW.glfwSetWindowMonitor(this.handle,
					MemoryUtil.NULL,
					100,
					100,
					this.options.windowSize.x,
					this.options.windowSize.y,
					GLFW.GLFW_DONT_CARE);

			runResizeCallbacks();
		}

		case FULLSCREEN -> {
			GLFW.glfwSetWindowAttrib(this.handle, GLFW.GLFW_DECORATED, GLFW.GLFW_TRUE);

			GLFW.glfwSetWindowMonitor(this.handle,
					this.monitor,
					0,
					0,
					vidMode.width(),
					vidMode.height(),
					this.options.fps > 0 ? this.options.fps : vidMode.refreshRate());

			runResizeCallbacks();
		}
		}
	}

	public Vector4f getBackground() {
		return this.background;
	}

	public void setBackground(final Vector4f background) {
		this.background = background;
	}

	public WindowOptions getOptions() {
		return this.options;
	}

	public Character getCharacter() {
		return this.character;
	}

	public void clearCharacter() {
		this.character = null;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Vector2d getScroll() {
		return this.scroll;
	}

	public Vector2i getSize() {
		return new Vector2i(this.width, this.height);
	}

	public long getHandle() {
		return this.handle;
	}

	public void clearScroll() {
		this.scroll.set(0, 0);
	}

	public void onResize(final BiConsumer<Integer, Integer> object) {
		this.onResize = object;
	}

	public void runResizeCallbacks() {
		assert Thread.currentThread() == this.ownerThread;

		final int[] w = new int[1];
		final int[] h = new int[1];
		GLFW.glfwGetWindowSize(this.handle, w, h);
		this.width = w[0];
		this.height = h[0];
		if (this.onResize != null) {
			this.onResize.accept(w[0], h[0]);
		}
	}

}
