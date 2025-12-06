package lu.kbra.standalone.gameengine.geom;

public interface LineMesh {

	default boolean isLineSmooth() {
		return true;
	}

	float getLineWidth();

}
