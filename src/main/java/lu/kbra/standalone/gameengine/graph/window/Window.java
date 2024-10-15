package lu.kbra.standalone.gameengine.graph.window;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.function.BiConsumer;
import java.util.logging.Level;

import org.joml.Vector2d;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWGamepadState;
import org.lwjgl.glfw.GLFWJoystickCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.consts.GLType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public abstract class Window implements Cleanupable {

	protected GLType glType;

	// Window options
	protected WindowOptions options;

	protected long monitor;
	protected long handle;

	protected GLFWGamepadState gamepadState;

	protected Vector4f background = new Vector4f(0, 0.1f, 0, 1);

	// Callbacks
	protected BiConsumer<Integer, Integer> onResize;
	
	private KeyState[] keyStates = new KeyState[GLFW.GLFW_KEY_LAST];
	protected GLFWKeyCallback keyCallback;
	protected GLFWJoystickCallback joystickCallback;
	protected GLFWFramebufferSizeCallback frameBufferCallback;
	protected GLFWErrorCallback errorCallback;
	protected Vector2d scroll = new Vector2d();
	protected GLFWScrollCallback scrollCallback;
	protected Vector2f cursorPos = new Vector2f();
	protected GLFWCursorPosCallback cursorPosCallback;

	protected int width, height;

	public Window(GLType glType, WindowOptions options) {
		this.glType = glType;
		this.options = options;

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
			// throw new RuntimeException("No primary monitor found");
			PointerBuffer ptb = GLFW.glfwGetMonitors();
			if (!ptb.hasRemaining()) {
				throw new RuntimeException("No primary monitor found");
			}
			monitor = ptb.get(); // get first monitor if no primary is found
			ptb.free();
		}
		return monitor;
	}

	protected void createCallbacks() {
		keyCallback = GLFWKeyCallback.create((window, key, scancode, action, mods) -> callback_key(window, key, scancode, action, mods));
		GLFW.glfwSetKeyCallback(handle, keyCallback);

		joystickCallback = GLFWJoystickCallback.create((jid, event) -> callback_joystick(jid, event));
		GLFW.glfwSetJoystickCallback(joystickCallback);

		frameBufferCallback = GLFWFramebufferSizeCallback.create((window, width, height) -> callback_frameBuffer(window, width, height));
		GLFW.glfwSetFramebufferSizeCallback(handle, frameBufferCallback);

		scrollCallback = GLFWScrollCallback.create((window, sx, sy) -> callback_scroll(window, sx, sy));
		GLFW.glfwSetScrollCallback(handle, scrollCallback);

		cursorPosCallback = GLFWCursorPosCallback.create((window, sx, sy) -> callback_cursor_pos(window, sx, sy));
		GLFW.glfwSetCursorPosCallback(handle, cursorPosCallback);

		gamepadState = GLFWGamepadState.create();
	}

	protected void callback_cursor_pos(long window, double sx, double sy) {
		cursorPos.set(sx, sy);
	}

	protected void callback_scroll(long window, double sx, double sy) {
		// System.err.println("scroll: " + sx + ", " + sy + " handle" + window);
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
			GlobalLogger.log(Level.INFO,
					"Joystick connected: jid:" + jid + ", name:" + GLFW.glfwGetJoystickName(jid) + ", guid:" + GLFW.glfwGetJoystickGUID(jid) + " -> name:" + GLFW.glfwGetGamepadName(jid) + ", joystick as gamepad:" + GLFW.glfwJoystickIsGamepad(jid));
		} else if (event == GLFW.GLFW_DISCONNECTED) {
			GlobalLogger.log(Level.INFO, "Joystick disconnected: jid:" + jid);
		}
	}

	protected void callback_key(long window, int key, int scancode, int action, int mods) {
		if (window != handle)
			return;
		
		if (key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_PRESS) {
			setWindowShouldClose(true);
		} else if (key == GLFW.GLFW_KEY_F11 && action == GLFW.GLFW_PRESS) {
			options.fullscreen = !options.fullscreen;
			updateOptions();
		}

		String strName = GLFW.glfwGetKeyName(key, scancode);
		if(strName == null || strName.isEmpty())
			return;
		
		char name = strName.toCharArray()[0];
		
		if (action == GLFW.GLFW_PRESS) {
			keyStates[name] = KeyState.PRESS;
		} else if (action == GLFW.GLFW_REPEAT) {
			keyStates[name] = KeyState.REPEAT;
		} else if (action == GLFW.GLFW_RELEASE) {
			keyStates[name] = KeyState.RELEASE;
		}
	}

	public void setWindowShouldClose(boolean b) {
		GLFW.glfwSetWindowShouldClose(handle, b);
	}

	public boolean isJoystickPresent() {
		return GLFW.glfwJoystickPresent(GLFW.GLFW_JOYSTICK_1);
	}

	public float[] getJoystickAxis(int jid) {
		FloatBuffer fb = GLFW.glfwGetJoystickAxes(jid);
		float[] bb = new float[fb.remaining()];
		fb.get(bb);
		return bb;
	}
	
	public float getJoystickAxis(int jid, int axis) {
		FloatBuffer fb = GLFW.glfwGetJoystickAxes(jid);
		float[] bb = new float[fb.remaining()];
		fb.get(bb);
		return bb[axis];
	}

	public boolean getJoystickButton(int jid, int btn) {
		ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb[btn] == GLFW.GLFW_PRESS;
	}
	
	public byte[] getJoystickButtonsArray(int jid) {
		ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb;
	}

	public ByteBuffer getJoystickButtons(int jid) {
		return GLFW.glfwGetJoystickButtons(jid);
	}

	public byte getJoystickHat(int jid, int hat) {
		ByteBuffer fb = GLFW.glfwGetJoystickButtons(jid);
		byte[] bb = new byte[fb.remaining()];
		fb.get(bb);
		return bb[hat];
	}

	public boolean isMouseButtonPressed(int mbid) {
		return GLFW.glfwGetMouseButton(handle, mbid) == GLFW.GLFW_PRESS;
	}

	public Vector2f getMousePos() {
		return cursorPos;
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
	
	public boolean isCharPress(int code) {
		return keyStates[code] == KeyState.PRESS;
	}
	
	public boolean isKeyPressed(int code) {
		return GLFW.glfwGetKey(handle, code) == GLFW.GLFW_PRESS;
	}
	
	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(handle);
	}

	public void swapBuffers() {
		GLFW.glfwSwapBuffers(handle);
	}

	public void pollEvents() {
		GLFW.glfwPollEvents();
	}

	public boolean updateGamepad(int jid) {
		return GLFW.glfwGetGamepadState(jid, gamepadState);
	}

	public void updateOptions() {
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, options.resizable ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
		GLFW.glfwSwapInterval(options.vsync ? 1 : 0);
		GLFWVidMode vidMode = GLFW.glfwGetVideoMode(monitor);
		GLFW.glfwSetWindowMonitor(handle, options.fullscreen ? monitor : MemoryUtil.NULL, 0, 0, !options.fullscreen ? options.windowSize.x : vidMode.width(), !options.fullscreen ? options.windowSize.y : vidMode.height(), options.fps);
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Vector2d getScroll() {
		return scroll;
	}

	public void clearScroll() {
		scroll.set(0, 0);
	}

	public void onResize(BiConsumer<Integer, Integer> object) {
		this.onResize = object;
	}

	public void runCallbacks() {
		if (onResize != null) {
			int[] w = new int[1];
			int[] h = new int[1];
			GLFW.glfwGetWindowSize(handle, w, h);
			onResize.accept(w[0], h[0]);
		}
	}

}
