package lu.kbra.standalone.gameengine.utils.transform;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class Transform3D extends Transform {

	protected Vector3f translation;
	protected Quaternionf rotation;
	protected Vector3f scale;

	protected Transform3D(boolean _noAction) {
		super(_noAction);
	}

	public Transform3D() {
		this(new Vector3f(0), new Quaternionf().identity(), new Vector3f(1));
	}

	public Transform3D(Vector3f trans, Quaternionf rot, Vector3f scale) {
		this.translation = trans;
		this.rotation = rot;
		this.scale = scale;

		super.matrix = new Matrix4f();

		updateMatrix();
	}

	public Transform3D(Vector3f trans) {
		this(trans, new Quaternionf().identity(), new Vector3f(1));
	}

	public Transform3D(Vector3f trans, Quaternionf rot) {
		this(trans, rot, new Vector3f(1));
	}

	public Transform3D(Quaternionf rot) {
		this(new Vector3f(0), rot, new Vector3f(1));
	}

	/** chaining methods for scale */

	public Transform3D scaleAdd(Vector3f v) {
		scale.add(v);
		return this;
	}

	public Transform3D scaleAdd(float x, float y, float z) {
		scale.add(x, y, z);
		return this;
	}

	public Transform3D scaleSet(Vector3f v) {
		scale.set(v.x, v.y, v.z);
		return this;
	}

	public Transform3D scaleSet(float x, float y, float z) {
		scale.set(x, y, z);
		return this;
	}

	public Transform3D scaleMul(Vector3f v) {
		scale.mul(v);
		return this;
	}

	public Transform3D scaleMul(float x, float y, float z) {
		scale.mul(x, y, z);
		return this;
	}

	public Transform3D scaleSet(float length) {
		this.scale.set(length);
		return this;
	}

	public Transform3D setScale(Vector3f scale) {
		this.scale = scale;
		return this;
	}

	/** chaining methods for translation */

	public Transform3D translationAdd(Vector3f v) {
		translation.add(v);
		return this;
	}

	public Transform3D translationAdd(float x, float y, float z) {
		translation.add(x, y, z);
		return this;
	}

	public Transform3D translationSet(Vector3f v) {
		translation.set(v.x, v.y, v.z);
		return this;
	}

	public Transform3D translationSet(float x, float y, float z) {
		translation.set(x, y, z);
		return this;
	}

	public Transform3D translationMul(Vector3f v) {
		translation.mul(v);
		return this;
	}

	public Transform3D translationMul(float x, float y, float z) {
		translation.mul(x, y, z);
		return this;
	}

	public Transform3D setTranslation(Vector3f translation) {
		this.translation = translation;
		return this;
	}

	/** chaining methods for rotation */

	public Transform3D translateAdd(Vector3f v) {
		translation.add(v);
		return this;
	}

	public Transform3D translateAdd(float x, float y, float z) {
		translation.add(x, y, z);
		return this;
	}

	public Transform3D translateMul(Vector3f center, float x, float y, float z) {
		translation.add(center.negate());
		translation.mul(x, y, z);
		translation.add(center);
		return this;
	}

	public Transform3D rotateFromAxisAngleRad(Vector3f v, float angle) {
		rotation.fromAxisAngleRad(v, angle);
		return this;
	}

	public Transform3D rotateFromAxisAngleRad(float x, float y, float z, float angle) {
		rotation.fromAxisAngleDeg(x, y, z, angle);
		return this;
	}

	public Transform3D rotate(Quaternionf q) {
		rotation.add(q);
		return this;
	}

	public Transform3D rotate(float x, float y, float z) {
		final float newX = (float) Math.toRadians(x % 360);
		final float newY = (float) Math.toRadians(y % 360);
		final float newZ = (float) Math.toRadians(z % 360);

		final Quaternionf rotationDelta = new Quaternionf();
		rotationDelta.rotationXYZ(newX, newY, newZ);

		final Quaternionf conjugate = rotationDelta.conjugate();

		rotation.mul(rotationDelta).mul(conjugate);
		return this;
	}

	public Transform3D rotationSet(float x, float y, float z) {
		this.rotation.rotationXYZ(x, y, z);
		return this;
	}

	public Transform3D rotationSet(Vector3f v) {
		this.rotation.rotationXYZ(v.x, v.y, v.z);
		return this;
	}

	public Transform3D setRotation(Quaternionf rotation) {
		this.rotation = rotation;
		return this;
	}

	@Override
	public Matrix4f updateMatrix() {
		return matrix.identity().translationRotateScale(translation, rotation, scale);
	}

	public Vector3f getTranslation() {
		return translation;
	}

	public Quaternionf getRotation() {
		return rotation;
	}

	public Vector3f getScale() {
		return scale;
	}

	@Override
	public Transform clone() {
		return new Transform3D(translation.get(new Vector3f()), rotation.get(new Quaternionf()),
				scale.get(new Vector3f()));
	}

	@Override
	public String toString() {
		return "Transform3D [translation=" + translation + ", rotation=" + rotation + ", scale=" + scale + "]";
	}

}
