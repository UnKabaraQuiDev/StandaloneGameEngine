package lu.kbra.standalone.gameengine.geom;

import org.joml.Vector3f;

public class BoundingBox {

	private final Vector3f min;
	private final Vector3f max;
	private Vector3f center, size;

	public BoundingBox(Vector3f min, Vector3f max) {
		this.min = min;
		this.max = max;
	}

	public BoundingBox(Vector3f min, Vector3f max, Vector3f center) {
		this.min = min;
		this.max = max;
		this.center = center;
	}

	public Vector3f getMin() {
		return min;
	}

	public Vector3f getMax() {
		return max;
	}

	public Vector3f getCenter() {
		if (center == null) {
			computeCenter();
		}
		return center;
	}

	public Vector3f computeCenter() {
		if (center == null) {
			center = new Vector3f();
		}
		return min.add(max, center).mul(0.5f);
	}

	public Vector3f getSize() {
		if (size == null) {
			computeSize();
		}
		return size;
	}

	public Vector3f computeSize() {
		if (size == null) {
			size = new Vector3f();
		}
		return max.sub(min, size);
	}

	@Override
	public String toString() {
		return "BoundingBox [min=" + min + ", max=" + max + ", center=" + center + "]";
	}

}
