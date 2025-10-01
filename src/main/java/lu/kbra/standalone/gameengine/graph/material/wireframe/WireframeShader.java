package lu.kbra.standalone.gameengine.graph.material.wireframe;

import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShaderPart;
import lu.kbra.standalone.gameengine.utils.consts.BeginMode;
import lu.kbra.standalone.gameengine.utils.consts.FaceMode;

public class WireframeShader extends RenderShader {

	public static final String NAME = WireframeShader.class.getName();

	public static final String COLOR = "color";

	public WireframeShader() {
		super(NAME, AbstractShaderPart.load("./resources/shaders/debug/debug.vert"), AbstractShaderPart.load("./resources/shaders/debug/debug.frag"));

		super.setFaceMode(FaceMode.FRONT_AND_BACK);
		super.setBeginMode(BeginMode.LINES);
	}

	@Override
	public void createUniforms() {
		// vert
		createUniform(RenderShader.PROJECTION_MATRIX);
		createUniform(RenderShader.VIEW_MATRIX);
		createUniform(RenderShader.TRANSFORMATION_MATRIX);
		// frag
		createUniform(COLOR);
	}

}
