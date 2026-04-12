package lu.kbra.standalone.gameengine.geom;

import java.awt.geom.Rectangle2D;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;

public class BoundingBox {

	private final Vector3f min;
	private final Vector3f max;
	private Vector3f center;
	private Vector3f size;

	public BoundingBox(final Vector3f min, final Vector3f max) {
		this.min = min;
		this.max = max;
	}

	public BoundingBox(final Vector3f min, final Vector3f max, final Vector3f center) {
		this.min = min;
		this.max = max;
		this.center = center;
	}

	public Vector3f getMin() {
		return this.min;
	}

	public Vector3f getMax() {
		return this.max;
	}

	public Vector3f getCenter() {
		if (this.center == null) {
			this.computeCenter();
		}
		return this.center;
	}

	public Vector3f computeCenter() {
		if (this.center == null) {
			this.center = new Vector3f();
		}
		return this.min.add(this.max, this.center).mul(0.5f);
	}

	public Vector3f getSize() {
		if (this.size == null) {
			this.computeSize();
		}
		return this.size;
	}

	public Vector3f computeSize() {
		if (this.size == null) {
			this.size = new Vector3f();
		}
		return this.max.sub(this.min, this.size);
	}

	public Rectangle2D.Float project(final GeoPlane plane) {
		return switch (plane) {
		case XY -> new Rectangle2D.Float(this.min.x, this.min.y, this.max.x - this.min.x, this.max.y - this.min.y);
		case XZ -> new Rectangle2D.Float(this.min.x, this.min.z, this.max.x - this.min.x, this.max.z - this.min.z);
		case YZ -> new Rectangle2D.Float(this.min.y, this.min.z, this.max.y - this.min.y, this.max.z - this.min.z);
		};
	}

	public BoundingBox translated(final Vector3f translation) {
		return new BoundingBox(new Vector3f(this.min).add(translation), new Vector3f(this.max).add(translation));
	}

	public BoundingBox transformed(final Matrix4f matrix) {
		final Vector3f min = new Vector3f(Float.POSITIVE_INFINITY);
		final Vector3f max = new Vector3f(Float.NEGATIVE_INFINITY);

		final Vector3f[] corners = new Vector3f[] {
				new Vector3f(this.min.x, this.min.y, this.min.z),
				new Vector3f(this.min.x, this.min.y, this.max.z),
				new Vector3f(this.min.x, this.max.y, this.min.z),
				new Vector3f(this.min.x, this.max.y, this.max.z),
				new Vector3f(this.max.x, this.min.y, this.min.z),
				new Vector3f(this.max.x, this.min.y, this.max.z),
				new Vector3f(this.max.x, this.max.y, this.min.z),
				new Vector3f(this.max.x, this.max.y, this.max.z) };

		final Vector3f tmp = new Vector3f();

		for (final Vector3f corner : corners) {
			matrix.transformPosition(corner, tmp);

			min.min(tmp);
			max.max(tmp);
		}

		return new BoundingBox(min, max);
	}

	@Override
	public String toString() {
		return "BoundingBox [min=" + this.min + ", max=" + this.max + ", center=" + this.center + "]";
	}

	public static BoundingBox union(final BoundingBox bb1, final BoundingBox bb2) {
		final Vector3f min = new Vector3f(bb1.getMin()).min(bb2.getMin());
		final Vector3f max = new Vector3f(bb1.getMax()).max(bb2.getMax());
		return new BoundingBox(min, max);
	}

}
