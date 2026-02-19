package lu.kbra.standalone.gameengine.impl;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShader;

public interface FramebufferAttachment extends Cleanupable {

	void bind(int id);

	default void bindUniform(AbstractShader shader, String uniformName, int i) {
		final int loc = shader.getUniformLocation(uniformName);
		bindUniform(loc, i);
	}

	default void bindUniform(int loc, int i) {
		if (loc == -1) {
			return;
		}
		bind(i);

		GL_W.glUniform1i(loc, i);
	}

}
