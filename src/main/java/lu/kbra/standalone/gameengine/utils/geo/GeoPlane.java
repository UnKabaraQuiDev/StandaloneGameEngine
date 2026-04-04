package lu.kbra.standalone.gameengine.utils.geo;

import static lu.kbra.standalone.gameengine.GameEngine.X_POS;
import static lu.kbra.standalone.gameengine.GameEngine.Y_POS;
import static lu.kbra.standalone.gameengine.GameEngine.Z_POS;

import org.joml.Quaternionfc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import lu.kbra.standalone.gameengine.utils.MathUtils;

public enum GeoPlane {

	XY(new Vector3fc[] { X_POS, Y_POS }, Z_POS),
	XZ(new Vector3fc[] { X_POS, Z_POS }, Y_POS),
	YZ(new Vector3fc[] { Y_POS, Z_POS }, X_POS);

	private Vector3fc[] points;
	private Vector3fc normal;

	GeoPlane(Vector3fc[] p, Vector3fc n) {
		points = p;
		normal = n;
	}

	public Vector3fc[] getPoints() {
		return points;
	}

	public Vector3fc getNormal() {
		return normal;
	}

	public static GeoPlane getByTangent(Vector3f tangent) {
		float x = Math.abs(tangent.x);
		float y = Math.abs(tangent.y);
		float z = Math.abs(tangent.z);

		x = MathUtils.snap(x, 1);
		y = MathUtils.snap(y, 1);
		z = MathUtils.snap(z, 1);

		if (x == 0 && y == 0)
			return XZ;
		if (x == 0 && z == 0)
			return XY;
		else if (y == 0 && z == 0)
			return YZ;

		return null;
	}

	public static GeoPlane getByNormal(Vector3f normal) {
		normal = normal.normalize(new Vector3f());

		float x = Math.abs(normal.x);
		float y = Math.abs(normal.y);
		float z = Math.abs(normal.z);

		x = MathUtils.snap(x, 1);
		y = MathUtils.snap(y, 1);
		z = MathUtils.snap(z, 1);

		if (x == 1 && y == 0 && z == 0)
			return YZ;
		if (y == 1 && x == 0 && z == 0)
			return XZ;
		else if (z == 1 && x == 0 && y == 0)
			return XY;

		return null;
	}

	public Vector3f project(Vector2fc pos) {
		switch (this) {
		case XY:
			return new Vector3f(pos.x(), pos.y(), 0);
		case XZ:
			return new Vector3f(pos.x(), 0, pos.y());
		case YZ:
			return new Vector3f(0, pos.x(), pos.y());
		}
		return null;
	}

	public Vector2f projectToPlane(Vector3fc pos) {
		return projectToPlane(pos, this);
	}

	public static Vector2f projectToPlane(Vector3fc pos, GeoPlane plane) {
		switch (plane) {
		case XY:
			return new Vector2f(pos.x(), pos.y());
		case XZ:
			return new Vector2f(pos.x(), pos.z());
		case YZ:
			return new Vector2f(pos.y(), pos.z());
		default:
			throw new IllegalArgumentException("Unsupported plane type");
		}
	}

	public static GeoPlane getByNormal(Quaternionfc rotation) {
		return getByNormal(MathUtils.vec3fromQuatf(rotation));
	}

	public Vector2f getBoundingPlane(Vector3f[] data) {
		Vector2f min = new Vector2f(Float.MAX_VALUE), max = new Vector2f(Float.MIN_VALUE);

		for (Vector3f v : data) {
			min.min(projectToPlane(v));
			max.max(projectToPlane(v));
		}

		return max.sub(min);
	}

}
