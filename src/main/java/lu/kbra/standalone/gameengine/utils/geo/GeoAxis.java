package lu.kbra.standalone.gameengine.utils.geo;

import org.joml.Vector3f;
import org.joml.Vector3fc;

public enum GeoAxis {

	X(new Vector3f(1, 0, 0)),
	Y(new Vector3f(0, 1, 0)),
	Z(new Vector3f(0, 0, 1));

	private final Vector3fc axis;

	GeoAxis(Vector3fc axis) {
		this.axis = axis;
	}

	public Vector3fc getAxis() {
		return axis;
	}

	public int getIndex() {
		return ordinal();
	}

}
