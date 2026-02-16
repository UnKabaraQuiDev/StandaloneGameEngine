package lu.kbra.standalone.gameengine.graph.window;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageCallback;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.base.GL_W_GL43;
import lu.kbra.standalone.gameengine.utils.GameEngineLoggerUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.GLType;

public class GLWindow extends Window {

	private GLCapabilities capabilities;

	public GLWindow(WindowOptions options) {
		super(GLType.GL, options);
		GlobalLogger.log();
	}

	@Override
	protected void init() {
		if (!GLFW.glfwInit()) {
			throw new RuntimeException("Failed to initialize GLFW");
		}

		monitor = getQualifiedMonitor();

		GLFW.glfwDefaultWindowHints();

		handle = GLFW.glfwCreateWindow(options.windowSize.x, options.windowSize.y, options.title, MemoryUtil.NULL, MemoryUtil.NULL);
		if (handle == MemoryUtil.NULL) {
			throw new RuntimeException("Failed to create GLFW Window");
		}

		takeGLContext();
		if ((this.capabilities = GL.createCapabilities()) == null) {
			throw new RuntimeException("Failed to create OpenGL context.");
		}

		if ((GL_W.WRAPPER instanceof GL_W_GL43 || capabilities.GL_KHR_debug) && GL_DEBUG_OUTPUT) {
			GL_W.glEnable(GL_W.GL_DEBUG_OUTPUT);
			GL_W.glEnable(GL_W.GL_DEBUG_OUTPUT_SYNCHRONOUS);

			GL_W.glDebugMessageCallback((GLDebugMessageCallbackI) (source, type, id, severity, length, message, userParam) -> {
				final String msg = GLDebugMessageCallback.getMessage(length, message);
				GlobalLogger
						.info("GL DEBUG: " + msg + " (source=" + source + ", type=" + type + ", id=" + id + ", severity=" + severity + ")");
			}, 0);
		}

		try {
			GameEngineLoggerUtils.log(this.capabilities);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}

		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 4);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 6);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
		if (options.windowMultisample > 1) {
			GL_W.glEnable(GL_W.GL_MULTISAMPLE);
			GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, options.windowMultisample);
		}

		updateOptions();

		createCallbacks();

		if (options.visible) {
			GLFW.glfwShowWindow(handle);
		}
	}

	@Override
	public void takeGLContext() {
		GLFW.glfwMakeContextCurrent(handle);
		GL.setCapabilities(this.capabilities);
	}

	@Override
	public void cleanup() {
		if (GL.getCapabilities() != null) {
			GlobalLogger.log("Cleaning up: " + getClass().getName() + " (" + handle + ")");

			GL.setCapabilities(null);
		}
	}

	public void cleanupGLFW() {
		if (handle != -1) {
			GlobalLogger.log("Cleaning up: " + getClass().getName() + " (" + handle + ")");

			Callbacks.glfwFreeCallbacks(handle);

			if (errorCallback != null) {
				errorCallback.free();
			}
			joystickCallback.free();

			GLFW.glfwDestroyWindow(handle);
			GLFW.glfwTerminate();
			handle = -1;
		}
	}

}