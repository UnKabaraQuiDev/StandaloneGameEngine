package lu.kbra.standalone.gameengine.utils.transform;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class Transform3DPivot extends Transform3D {

	protected Vector3f rotationPivot;
	protected Vector3f scalePivot;

	public Transform3DPivot() {
		this(new Vector3f(), new Quaternionf(), new Vector3f(1), new Vector3f(), new Vector3f());
	}

	public Transform3DPivot(Transform3D transform) {
		this(transform.translation, transform.rotation, transform.scale, new Vector3f(), new Vector3f());
	}

	public Transform3DPivot(Vector3f trans, Quaternionf rot, Vector3f scale, Vector3f rotationPivot,
			Vector3f scalePivot) {
		super(true);

		super.translation = trans;
		super.rotation = rot;
		super.scale = scale;
		this.rotationPivot = new Vector3f(rotationPivot);
		this.scalePivot = new Vector3f(scalePivot);

		super.matrix = new Matrix4f();

		updateMatrix();
	}

	// rotation
	public Transform3DPivot rotationPivotAdd(Vector3f p) {
		rotationPivot.add(p);
		return this;
	}

	public Transform3DPivot rotationPivotMul(Vector3f p) {
		rotationPivot.mul(p);
		return this;
	}

	public Transform3DPivot rotationPivotSet(Vector3f p) {
		rotationPivot.set(p);
		return this;
	}

	public Transform3DPivot rotationPivotAdd(float x, float y, float z) {
		rotationPivot.add(x, y, z);
		return this;
	}

	public Transform3DPivot rotationPivotMul(float x, float y, float z) {
		rotationPivot.mul(x, y, z);
		return this;
	}

	public Transform3DPivot rotationPivotSet(float x, float y, float z) {
		rotationPivot.set(x, y, z);
		return this;
	}

	// scale
	public Transform3DPivot scalePivotAdd(Vector3f p) {
		scalePivot.add(p);
		return this;
	}

	public Transform3DPivot scalePivotMul(Vector3f p) {
		scalePivot.mul(p);
		return this;
	}

	public Transform3DPivot scalePivotSet(Vector3f p) {
		scalePivot.set(p);
		return this;
	}

	public Transform3DPivot scalePivotAdd(float x, float y, float z) {
		scalePivot.add(x, y, z);
		return this;
	}

	public Transform3DPivot scalePivotMul(float x, float y, float z) {
		scalePivot.mul(x, y, z);
		return this;
	}

	public Transform3DPivot scalePivotSet(float x, float y, float z) {
		scalePivot.set(x, y, z);
		return this;
	}

	// setters
	public Transform3DPivot setRotationPivot(Vector3f p) {
		rotationPivot = p;
		return this;
	}

	public Transform3DPivot setScalePivot(Vector3f p) {
		scalePivot = p;
		return this;
	}

	// getters
	public Vector3f getRotationPivot() {
		return rotationPivot;
	}

	public Vector3f getScalePivot() {
		return scalePivot;
	}

	@Override
	public Matrix4f updateMatrix() {
		matrix.identity();

		// Apply translation first
		matrix.translate(translation);

		// Apply rotation around rotationPivot (relative to translation)
		matrix.translate(rotationPivot);
		matrix.rotate(rotation);
		matrix.translate(new Vector3f(rotationPivot).negate());

		// Apply scaling around scalePivot (relative to translation)
		matrix.translate(scalePivot);
		matrix.scale(scale);
		matrix.translate(new Vector3f(scalePivot).negate());

		return matrix;
	}

	@Override
	public Transform clone() {
		return new Transform3DPivot(translation.get(new Vector3f()), rotation.get(new Quaternionf()),
				scale.get(new Vector3f()), rotationPivot.get(new Vector3f()), scalePivot.get(new Vector3f()));
	}

	@Override
	public String toString() {
		return "Transform3DPivot [rotationPivot=" + this.rotationPivot + ", scalePivot=" + this.scalePivot
				+ ", translation=" + this.translation + ", rotation=" + this.rotation + ", scale=" + this.scale
				+ ", matrix=" + this.matrix + "]";
	}

}
