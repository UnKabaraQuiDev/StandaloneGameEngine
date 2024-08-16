package lu.kbra.standalone.gameengine.graph.composition;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public interface FramebufferAttachment extends Cleanupable {

	void bind(int id);
	
	default void bindUniform(int loc, int i) {
		GL_W.glUniform1i(loc, i);
		GL_W.checkError("Uniform1i["+loc+"] = "+i);
	}

}
