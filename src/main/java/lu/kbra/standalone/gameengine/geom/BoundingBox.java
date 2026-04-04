package lu.kbra.standalone.gameengine.geom;

import java.awt.geom.Rectangle2D;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;

public class BoundingBox {

	private final Vector3f min;
	private final Vector3f max;
	private Vector3f center;
	private Vector3f size;

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
		if (center == null)
			computeCenter();
		return center;
	}

	public Vector3f computeCenter() {
		if (center == null)
			center = new Vector3f();
		return min.add(max, center).mul(0.5f);
	}

	public Vector3f getSize() {
		if (size == null)
			computeSize();
		return size;
	}

	public Vector3f computeSize() {
		if (size == null)
			size = new Vector3f();
		return max.sub(min, size);
	}

	public Rectangle2D.Float project(GeoPlane plane) {
		return switch (plane) {
		case XY -> new Rectangle2D.Float(min.x, min.y, max.x - min.x, max.y - min.y);
		case XZ -> new Rectangle2D.Float(min.x, min.z, max.x - min.x, max.z - min.z);
		case YZ -> new Rectangle2D.Float(min.y, min.z, max.y - min.y, max.z - min.z);
		};
	}

	@Override
	public String toString() {
		return "BoundingBox [min=" + min + ", max=" + max + ", center=" + center + "]";
	}

	public static BoundingBox union(BoundingBox bb1, BoundingBox bb2) {
		final Vector3f max1 = bb1.getMax();
		final Vector3f max2 = bb2.getMax();
		final Vector3f min1 = bb1.getMin();
		final Vector3f min2 = bb2.getMin();
		return new BoundingBox(new Vector3f(min1).min(min2), new Vector3f(max1).min(max2));
	}

	public BoundingBox translated(Vector3f translation) {
		return new BoundingBox(new Vector3f(min).add(translation), new Vector3f(max).add(translation));
	}

}
