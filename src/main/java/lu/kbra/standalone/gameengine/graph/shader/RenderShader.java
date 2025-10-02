package lu.kbra.standalone.gameengine.graph.shader;

import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShader;
import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShaderPart;
import lu.kbra.standalone.gameengine.utils.gl.consts.BeginMode;
import lu.kbra.standalone.gameengine.utils.gl.consts.FaceMode;

public abstract class RenderShader extends AbstractShader {

	public static final String PROJECTION_MATRIX = "projectionMatrix";
	public static final String VIEW_MATRIX = "viewMatrix";
	public static final String TRANSFORMATION_MATRIX = "transformationMatrix";
	public static final String VIEW_POSITION = "viewPos";

	protected boolean transparent;
	protected BeginMode beginMode = BeginMode.TRIANGLES;
	protected FaceMode faceMode = FaceMode.FRONT_AND_BACK;

	public RenderShader(AbstractShaderPart... parts) {
		this(null, false, parts);
	}

	public RenderShader(String name, AbstractShaderPart... parts) {
		this(name, false, parts);
	}

	public RenderShader(String name, boolean transparent, AbstractShaderPart... parts) {
		super(name, parts);
		this.transparent = transparent;
	}

	public RenderShader(boolean transparent, AbstractShaderPart... parts) {
		super(null, parts);
		this.transparent = transparent;
	}

	public void createSceneUniforms() {
		// verts
		createUniform(PROJECTION_MATRIX);
		createUniform(VIEW_MATRIX);
		createUniform(TRANSFORMATION_MATRIX);
		createUniform(VIEW_POSITION);
	}

	public boolean isTransparent() {
		return this.transparent;
	}

	public void setTransparent(boolean transparent) {
		this.transparent = transparent;
	}

	public BeginMode getBeginMode() {
		return beginMode;
	}

	public void setBeginMode(BeginMode beginMode) {
		this.beginMode = beginMode;
	}

	public FaceMode getFaceMode() {
		return faceMode;
	}

	public void setFaceMode(FaceMode faceMode) {
		this.faceMode = faceMode;
	}

}
