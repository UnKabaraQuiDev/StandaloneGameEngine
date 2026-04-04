package lu.kbra.standalone.gameengine.utils.gl.consts;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;

public enum PolygonDrawMode implements GLConstant {

	FILL(GL_W.GL_FILL),
	POINT(GL_W.GL_POINT),
	LINE(GL_W.GL_LINE);

	private int glId;

	PolygonDrawMode(int glId) {
		this.glId = glId;
	}

	@Override
	public int getGlId() {
		return glId;
	}

}
