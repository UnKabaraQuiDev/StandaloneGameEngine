package lu.kbra.standalone.gameengine.graph.window;

import org.lwjgl.glfw.GLFW;

public enum KeyState {

	PRESS,
	REPEAT,
	RELEASE;

	public static KeyState byGLFWId(int id) {
		switch (id) {
		case GLFW.GLFW_PRESS:
			return PRESS;
		case GLFW.GLFW_REPEAT:
			return REPEAT;
		case GLFW.GLFW_RELEASE:
			return RELEASE;
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);
		}
	}

}
