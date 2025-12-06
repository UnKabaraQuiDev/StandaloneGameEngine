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
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWGamepadState;
import org.lwjgl.glfw.GLFWJoystickCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.gl.consts.GLType;

public abstract class Window implements Cleanupable {

	public static final String DEBUG_ESCAPE_TO_CLOSE_PROPERTY = Window.class.getSimpleName() + ".debug_escape_to_close";
	public static boolean DEBUG_ESCAPE_TO_CLOSE = Boolean.getBoolean(DEBUG_ESCAPE_TO_CLOSE_PROPERTY);

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

	protected int width, height;

	public Window(GLType glType, WindowOptions options) {
		this.glType = glType;
		this.options = options;
		this.ownerThread = Thread.currentThread();

		Arrays.fill(keyStates, KeyState.RELEASE);
		Arrays.fill(mouseButtonStates, KeyState.RELEASE);

		init();
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
			PointerBuffer ptb = GLFW.glfwGetMonitors();
			if (!ptb.hasRemaining()) {
				throw new RuntimeException("No primary monitor found");
			}
			monitor = ptb.get();
			ptb.free();
		}
		return monitor;
	}

	protected void createCallbacks() {
		keyCallback = GLFWKeyCallback
				.create((window, key, scancode, action, mods) -> callback_key(window, key, scancode, action, mods));
		GLFW.glfwSetKeyCallback(handle, keyCallback);

		joystickCallback = GLFWJoystickCallback.create((jid, event) -> callback_joystick(jid, event));
		GLFW.glfwSetJoystickCallback(joystickCallback);

		frameBufferCallback = GLFWFramebufferSizeCallback
				.create((window, width, height) -> callback_frameBuffer(window, width, height));
		GLFW.glfwSetFramebufferSizeCallback(handle, frameBufferCallback);

		scrollCallback = GLFWScrollCallback.create((window, sx, sy) -> callback_scroll(window, sx, sy));
		GLFW.glfwSetScrollCallback(handle, scrollCallback);

		cursorPosCallback = GLFWCursorPosCallback.create((window, sx, sy) -> callback_cursor_pos(window, sx, sy));
		GLFW.glfwSetCursorPosCallback(handle, cursorPosCallback);

		mouseButtonCallback = GLFWMouseButtonCallback
				.create((window, button, action, mods) -> callback_mouse_button(window, button, action, mods));
		GLFW.glfwSetMouseButtonCallback(handle, mouseButtonCallback);

		charCallback = GLFWCharCallback.create((window, codepoint) -> callback_char(window, codepoint));
		GLFW.glfwSetCharCallback(handle, charCallback);
	}

	protected void callback_char(long window, int codepoint) {
		if (codepoint > 0) {
			character = (char) codepoint;
		}
	}

	protected void callback_mouse_button(long window, int button, int action, int mods) {
		if (button >= 0 && button < mouseButtonStates.length) {
			if (action == GLFW.GLFW_PRESS) {
				mouseButtonStates[button] = KeyState.PRESS;
			} else if (action == GLFW.GLFW_RELEASE) {
				mouseButtonStates[button] = KeyState.RELEASE;
			}
		} else {
			GlobalLogger.severe("Unsupported mouse button: " + button);
		}
	}

	protected void callback_cursor_pos(long window, double sx, double sy) {
		cursorPosition.set(sx, sy);
	}

	protected void callback_scroll(long window, double sx, double sy) {
		if (window != handle)
			return;
		scroll.add(sx, sy);
	}

	protected void callback_frameBuffer(long window, int w, int h) {
		if (window != handle)
			return;
		if (!options.fullscreen)
			options.windowSize.set(w, h);
		if (onResize != null)
			onResize.accept(w, h);
		GL_W.glViewport(0, 0, w, h);
		this.width = w;
		this.height = h;
	}

	protected void callback_joystick(int jid, int event) {
		if (event == GLFW.GLFW_CONNECTED) {
			boolean isGamepad = GLFW.glfwJoystickIsGamepad(jid);
			connectedGamepads.put(jid, isGamepad);
			if (isGamepad) {
				GLFWGamepadState state = GLFWGamepadState.create();
				gamepadStates.put(jid, state);
			}
			GlobalLogger.log(Level.INFO,
					"Joystick connected: jid:" + jid + ", name:" + GLFW.glfwGetJoystickName(jid) + ", guid:"
							+ GLFW.glfwGetJoystickGUID(jid) + " -> name:" + GLFW.glfwGetGamepadName(jid)
							+ ", joystick as gamepad:" + GLFW.glfwJoystickIsGamepad(jid));
		} else if (event == GLFW.GLFW_DISCONNECTED) {
			connectedGamepads.remove(jid);
			gamepadStates.remove(jid);
			GlobalLogger.log(Level.INFO, "Joystick disconnected: jid:" + jid);
		}
	}

	protected void callback_key(long window, int key, int scancode, int action, int mods) {
		if (window != handle) {
			return;
		}

		if (DEBUG_ESCAPE_TO_CLOSE && key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_PRESS) {
			setWindowShouldClose(true);
		} else if (key == GLFW.GLFW_KEY_F11 && action == GLFW.GLFW_PRESS) {
			options.fullscreen = !options.fullscreen;
			updateOptions();
		}

		if (key > 0 && key < keyStates.length) {
			keyStates[key] = KeyState.byGLFWId(action);
		}
	}

	public void postPollEvents() {
		pollGamePadStates();
	}

	protected void pollGamePadStates() {
		for (Map.Entry<Integer, Boolean> entry : connectedGamepads.entrySet()) {
			final int jid = entry.getKey();
			if (!entry.getValue()) {
				return;
			}
			final GLFWGamepadState state = gamepadStates.get(jid);
			final boolean isValid = GLFW.glfwGetGamepadState(jid, state);
			if (!isValid) {
				connectedGamepads.put(entry.getKey(), false);
				gamepadStates.remove(entry.getKey());
			}
		}
	}

	public void setWindowShouldClose(boolean b) {
		GLFW.glfwSetWindowShouldClose(handle, b);
	}

	@Deprecated
	public boolean isJoystickPresent() {
		assert Thread.currentThread() == ownerThread;
		return GLFW.glfwJoystickPresent(GLFW.GLFW_JOYSTICK_1);
	}

	@Deprecated
	public float[] getJoystickAxis(int jid) {
		assert Thread.currentThread() == ownerThread;
		FloatBuffer fb = GLFW.glfwGetJoystickAxes(jid);
		float[] bb = new float[fb.remaining()];
		fb.get(bb);
		return bb;
	}

	@Deprecated
	public float getJoystickAxis(int jid, int axis) {
		assert Thread.currentThread() == ownerThread;
		FloatBuffer fb = GLFW.glfwGetJoystickAxes(jid);
		float[] bb = new float[fb.remaining()];
		fb.get(bb);
		return bb[axis];
	}

	@Deprecated
	public boolean getJoystickButton(int jid, int btn) {
		assert Thread.currentThread() == ownerThread;
		ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb[btn] == GLFW.GLFW_PRESS;
	}

	@Deprecated
	public byte[] getJoystickButtonsArray(int jid) {
		assert Thread.currentThread() == ownerThread;
		ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb;
	}

	@Deprecated
	public ByteBuffer getJoystickButtons(int jid) {
		assert Thread.currentThread() == ownerThread;
		return GLFW.glfwGetJoystickButtons(jid);
	}

	@Deprecated
	public byte getJoystickHat(int jid, int hat) {
		assert Thread.currentThread() == ownerThread;
		ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb[hat];
	}

	@Deprecated
	public boolean isMouseButtonPressed(int mbid) {
		assert Thread.currentThread() == ownerThread;
		return GLFW.glfwGetMouseButton(handle, mbid) == GLFW.GLFW_PRESS;
	}

	public KeyState getMouseButtonState(int mbid) {
		return mouseButtonStates[mbid];
	}

	public Vector2f getMousePosition() {
		return cursorPosition;
	}

	public boolean getJoystickHat(int jid, int hat, byte state) {
		return getJoystickHat(jid, hat) == state;
	}

	public ByteBuffer getJoystickHats(int jid) {
		return GLFW.glfwGetJoystickHats(jid);
	}

	public GLFWGamepadState getGamepad() {
		return gamepadState;
	}

	@Deprecated
	public boolean isKeyPressed(int code) {
		assert Thread.currentThread() == ownerThread;
		return GLFW.glfwGetKey(handle, code) == GLFW.GLFW_PRESS;
	}

	public KeyState getKeyState(int code) {
		return keyStates[code];
	}

	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(handle);
	}

	public void swapBuffers() {
		if (handle == MemoryUtil.NULL) {
			throw new IllegalStateException("Window wasn't initialized");
		}
		GL_W.glBindFramebuffer(GL_W.GL_FRAMEBUFFER, 0);
		assert GL_W.checkError("BindFramebuffer");
		GLFW.glfwSwapBuffers(handle);
	}

	public void pollEvents() {
		assert Thread.currentThread() == ownerThread;
		GLFW.glfwPollEvents();
	}

	@Deprecated
	public boolean updateGamepad(int jid) {
		assert Thread.currentThread() == ownerThread;
		return GLFW.glfwGetGamepadState(jid, gamepadState);
	}

	public void updateOptions() {
		assert Thread.currentThread() == ownerThread;

		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, options.resizable ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
		GLFW.glfwSwapInterval(options.vsync ? 1 : 0);
		GLFWVidMode vidMode = GLFW.glfwGetVideoMode(monitor);
		GLFW.glfwSetWindowMonitor(handle, options.fullscreen ? monitor : MemoryUtil.NULL, 0, 0,
				!options.fullscreen ? options.windowSize.x : vidMode.width(),
				!options.fullscreen ? options.windowSize.y : vidMode.height(), options.fps);

		this.width = !options.fullscreen ? options.windowSize.x : vidMode.width();
		this.height = !options.fullscreen ? options.windowSize.y : vidMode.height();
	}

	public Vector4f getBackground() {
		return background;
	}

	public void setBackground(Vector4f background) {
		this.background = background;
	}

	public WindowOptions getOptions() {
		return options;
	}

	public Character getCharacter() {
		return character;
	}

	public void clearCharacter() {
		character = null;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Vector2d getScroll() {
		return scroll;
	}

	public Vector2i getSize() {
		return new Vector2i(width, height);
	}

	public void clearScroll() {
		scroll.set(0, 0);
	}

	public void onResize(BiConsumer<Integer, Integer> object) {
		this.onResize = object;
	}

	public void runCallbacks() {
		assert Thread.currentThread() == ownerThread;
		if (onResize != null) {
			int[] w = new int[1];
			int[] h = new int[1];
			GLFW.glfwGetWindowSize(handle, w, h);
			onResize.accept(w[0], h[0]);
		}
	}

}
