package lu.kbra.standalone.gameengine.graph.shader;

import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShader;
import lu.kbra.standalone.gameengine.graph.shader.part.ComputeShaderPart;

public class ComputeShader extends AbstractShader {

	public static final String INPUT_SIZE = "inputSize";
	public static final String OUTPUT_SIZE = "outputSize";

	public static final String SCREEN_SIZE = "screenSize";

	public ComputeShader(ComputeShaderPart part) {
		super(null, part);
	}

	public ComputeShader(String name, ComputeShaderPart part) {
		super(name, part);
	}

	@Override
	public void createUniforms() {
		createUniform(SCREEN_SIZE);
	}

}
