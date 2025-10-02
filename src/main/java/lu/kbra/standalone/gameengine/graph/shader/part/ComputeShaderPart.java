package lu.kbra.standalone.gameengine.graph.shader.part;

import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class ComputeShaderPart extends AbstractShaderPart {

	public ComputeShaderPart(String file) {
		super(file, GL_W.GL_COMPUTE_SHADER);
	}

}
