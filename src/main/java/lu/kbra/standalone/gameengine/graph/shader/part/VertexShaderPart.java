package lu.kbra.standalone.gameengine.graph.shader.part;

import java.util.Map;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;

public class VertexShaderPart extends AbstractShaderPart {

	public VertexShaderPart(String file) {
		super(file, GL_W.GL_VERTEX_SHADER);
	}

	public VertexShaderPart(String file, Map<String, Object> replacements) {
		super(file, GL_W.GL_VERTEX_SHADER, replacements);
	}

}
