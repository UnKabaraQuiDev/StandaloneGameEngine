package lu.kbra.standalone.gameengine.graph.window;

import java.lang.reflect.Field;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageCallback;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.MemoryUtil;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.utils.consts.GLType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W_GL43;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W_GLES32;

public class GLWindow extends Window {

	private GLCapabilities capabilities;

	public GLWindow(WindowOptions options) {
		super(GLType.GL, options);
		GlobalLogger.log();
	}

	@Override
	protected void init() {
		errorCallback = GLFWErrorCallback.createPrint(System.err);
		// GLFW.glfwSetErrorCallback(errorCallback);

		if (!GLFW.glfwInit())
			throw new RuntimeException("Failed to initialize GLFW");

		monitor = getQualifiedMonitor();

		handle = GLFW.glfwCreateWindow(options.windowSize.x, options.windowSize.y, options.title, MemoryUtil.NULL, MemoryUtil.NULL);
		if (handle == MemoryUtil.NULL)
			throw new RuntimeException("Failed to create GLFW Window");

		takeGLContext();
		if ((this.capabilities = GL.createCapabilities()) == null) {
			throw new RuntimeException("Failed to create OpenGL context");
		}

		// TODO: add option to disable debug output
		if (GL_W.WRAPPER instanceof GL_W_GL43 || capabilities.GL_KHR_debug) {
			GL_W.glEnable(GL_W.GL_DEBUG_OUTPUT);
			GL_W.glEnable(GL_W.GL_DEBUG_OUTPUT_SYNCHRONOUS);

			// Register callback
			GL_W.glDebugMessageCallback((GLDebugMessageCallbackI) (source, type, id, severity, length, message, userParam) -> {
				final String msg = GLDebugMessageCallback.getMessage(length, message);
				GlobalLogger
						.severe("GL DEBUG: " + msg + " (source=" + source + ", type=" + type + ", id=" + id + ", severity=" + severity
								+ ")");
			}, 0);
		}

		try {
			GlobalLogger.log("OpenGL Capabilities:");
			for (Field f : GLCapabilities.class.getFields()) {
				if (f.getType() == boolean.class) {
					if (f.get(this.capabilities).equals(Boolean.TRUE)) {
						GlobalLogger.log("\t" + f.getName());
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		GLFW.glfwDefaultWindowHints();
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 4);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 0);
		// GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
		if (options.windowMultisample > 1) {
			GL_W.glEnable(GL_W.GL_MULTISAMPLE);
			GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, options.windowMultisample);
		}
		GL_W.glEnable(GL_W.GL_DEPTH_TEST);

		updateOptions();

		createCallbacks();

		GLFW.glfwShowWindow(handle);
	}

	@Override
	public void takeGLContext() {
		GLFW.glfwMakeContextCurrent(handle);
		GL.setCapabilities(this.capabilities);
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + getClass().getName() + " (" + handle + ")");

		if (GL.getCapabilities() != null) {
			GL.setCapabilities(null);
		}
	}

	public void cleanupGLFW() {
		GlobalLogger.log("Cleaning up: " + getClass().getName() + " (" + handle + ")");

		if (handle != -1) {
			Callbacks.glfwFreeCallbacks(handle);

			errorCallback.free();
			joystickCallback.free();

			GLFW.glfwDestroyWindow(handle);
			GLFW.glfwTerminate();
			handle = -1;
		}
	}

}