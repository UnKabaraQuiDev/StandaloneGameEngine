package lu.kbra.standalone.gameengine.geom;

import lu.kbra.standalone.gameengine.utils.gl.consts.BeginMode;
import lu.kbra.standalone.gameengine.utils.gl.consts.PolygonDrawMode;
import lu.kbra.standalone.gameengine.utils.gl.consts.PolygonMode;

public interface LineMesh extends Mesh {

	@Override
	default PolygonDrawMode getPolygonDrawMode() {
		return PolygonDrawMode.LINE;
	}

	@Override
	default PolygonMode getPolygonMode() {
		return PolygonMode.FRONT_AND_BACK;
	}

	@Override
	default BeginMode getBeginMode() {
		return BeginMode.LINES;
	}

	default boolean isLineSmooth() {
		return true;
	}

	float getLineWidth();

}
