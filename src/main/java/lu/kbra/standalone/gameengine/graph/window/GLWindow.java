package lu.kbra.standalone.gameengine.graph.window;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageCallback;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLRuntimeException;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.base.GL_W_GL43;
import lu.kbra.standalone.gameengine.utils.GameEngineLoggerUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.GLType;

public class GLWindow extends Window {

	private GLCapabilities capabilities;

	public GLWindow(final WindowOptions options) {
		super(GLType.GL, options);
		GlobalLogger.log();
	}

	@Override
	protected void init() {
		if (!GLFW.glfwInit()) {
			throw new RuntimeException("Failed to initialize GLFW");
		}

		this.monitor = this.getQualifiedMonitor();

		GLFW.glfwDefaultWindowHints();

		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 4);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 6);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);

		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, options.resizable ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);

		if (options.windowMultisample > 1) {
			GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, options.windowMultisample);
		}

		this.handle = GLFW.glfwCreateWindow(this.options.windowSize.x,
				this.options.windowSize.y,
				this.options.title,
				MemoryUtil.NULL,
				MemoryUtil.NULL);
		if (this.handle == MemoryUtil.NULL) {
			throw new RuntimeException("Failed to create GLFW Window");
		}

		this.takeGLContext();
		if ((this.capabilities = GL.createCapabilities()) == null) {
			throw new RuntimeException("Failed to create OpenGL context.");
		}

		if ((GL_W.WRAPPER instanceof GL_W_GL43 || this.capabilities.GL_KHR_debug) && Window.GL_DEBUG_OUTPUT) {
			GL_W.glEnable(GL_W.GL_DEBUG_OUTPUT);
			GL_W.glEnable(GL_W.GL_DEBUG_OUTPUT_SYNCHRONOUS);

			if (Window.GL_FAIL_ON_ERROR) {
				GL_W.glDebugMessageCallback((GLDebugMessageCallbackI) (source, type, id, severity, length, message, userParam) -> {
					final String msg = GLDebugMessageCallback.getMessage(length, message);
					final String level = switch (severity) {
					case GL43.GL_DEBUG_SEVERITY_HIGH -> "HIGH";
					case GL43.GL_DEBUG_SEVERITY_MEDIUM -> "MEDIUM";
					case GL43.GL_DEBUG_SEVERITY_LOW -> "LOW";
					case GL43.GL_DEBUG_SEVERITY_NOTIFICATION -> "INFO";
					default -> "?";
					};
					final String str = "[" + level + "]: " + msg + " (source=" + source + ", type=" + type + ", id=" + id + ")";
					if (severity == GL_W.GL_DEBUG_SEVERITY_HIGH) {
						throw new GLRuntimeException(str);
					}
					GlobalLogger.info(str);
				}, 0);
			} else {
				GL_W.glDebugMessageCallback((GLDebugMessageCallbackI) (source, type, id, severity, length, message, userParam) -> {
					final String msg = GLDebugMessageCallback.getMessage(length, message);
					final String level = switch (severity) {
					case GL43.GL_DEBUG_SEVERITY_HIGH -> "HIGH";
					case GL43.GL_DEBUG_SEVERITY_MEDIUM -> "MEDIUM";
					case GL43.GL_DEBUG_SEVERITY_LOW -> "LOW";
					case GL43.GL_DEBUG_SEVERITY_NOTIFICATION -> "INFO";
					default -> "?";
					};
					final String str = "[" + level + "]: " + msg + " (source=" + source + ", type=" + type + ", id=" + id + ")";
					GlobalLogger.info(str);
				}, 0);
			}
		}

		try {
			GameEngineLoggerUtils.log(this.capabilities);
		} catch (final IllegalAccessException e) {
			throw new RuntimeException(e);
		}


		this.updateOptions();

		this.createCallbacks();

		if (this.options.visible) {
			GLFW.glfwShowWindow(this.handle);
		}
	}

	@Override
	public void takeGLContext() {
		GLFW.glfwMakeContextCurrent(this.handle);
		GL.setCapabilities(this.capabilities);
	}

	@Override
	public void cleanup() {
		if (GL.getCapabilities() != null) {
			GlobalLogger.log("Cleaning up: " + this.getClass().getName() + " (" + this.handle + ")");

			GL.setCapabilities(null);
		}
	}

	@Override
	public void cleanupGLFW() {
		if (this.handle != -1) {
			GlobalLogger.log("Cleaning up: " + this.getClass().getName() + " (" + this.handle + ")");

			Callbacks.glfwFreeCallbacks(this.handle);

			if (this.errorCallback != null) {
				this.errorCallback.free();
			}
			this.joystickCallback.free();

			GLFW.glfwDestroyWindow(this.handle);
			GLFW.glfwTerminate();
			this.handle = -1;
		}
	}

}
