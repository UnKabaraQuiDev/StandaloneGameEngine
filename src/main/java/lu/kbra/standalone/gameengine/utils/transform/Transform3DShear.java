package lu.kbra.standalone.gameengine.utils.transform;

import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import lu.kbra.standalone.gameengine.utils.geo.GeoAxis;

public class Transform3DShear extends Transform3D implements ShearOwner {

	protected Matrix3f shear;

	public Transform3DShear() {
		this(new Vector3f(0), new Quaternionf().identity(), new Vector3f(1), new Matrix3f().identity());
	}

	public Transform3DShear(final Vector3fc translation, final Quaternionfc rotation, final Vector3fc scale, final Matrix3fc shear) {
		super(true);
		super.translation = new Vector3f(translation);
		super.rotation = new Quaternionf(rotation);
		super.scale = new Vector3f(scale);
		this.shear = new Matrix3f(shear);
		updateMatrix();
	}

	public Transform3DShear(final Vector3f translation, final Quaternionf rotation, final Vector3f scale, final Matrix3f shear) {
		super(true);
		super.translation = translation;
		super.rotation = rotation;
		super.scale = scale;
		this.shear = shear;
		updateMatrix();
	}

	public Transform3DShear(final Vector3fc translation) {
		this(new Vector3f(translation), new Quaternionf().identity(), new Vector3f(1), new Matrix3f().identity());
	}

	public Transform3DShear(final Vector3fc trans, final Quaternionfc rot) {
		super(trans, rot);
	}

	public Transform3DShear(final Quaternionf rot) {
		super(rot);
	}

	public Transform3DShear(final Quaternionfc rot) {
		super(rot);
	}

	public Transform3DShear(final Vector3f trans, final Quaternionf rot, final Vector3f scale) {
		super(trans, rot, scale);
	}

	public Transform3DShear(final Vector3f trans, final Quaternionf rot) {
		super(trans, rot);
	}

	public Transform3DShear(final Vector3f trans) {
		super(trans);
	}

	public Transform3DShear(final Vector3fc trans, final Quaternionfc rot, final Vector3fc scale) {
		super(trans, rot, scale);
	}

	protected Transform3DShear(final boolean _noAction) {
		super(_noAction);
	}

	/* chaining methods for shear */

	@Override
	public Transform3DShear shearSet(final GeoAxis sourceAxis, final GeoAxis targetAxis, final float factor) {
		shear.set(sourceAxis.getIndex(), targetAxis.getIndex(), factor);
		return this;
	}

	@Override
	public Transform3DShear shearAdd(final GeoAxis sourceAxis, final GeoAxis targetAxis, final float factor) {
		shear.set(sourceAxis.getIndex(), targetAxis.getIndex(), shear.get(sourceAxis.getIndex(), targetAxis.getIndex()) + factor);
		return this;
	}

	@Override
	public Transform3DShear setShear(final Matrix3f shear) {
		this.shear = shear;
		return this;
	}

	@Override
	public Transform3DShear shearReset() {
		shear.identity();
		return this;
	}

	@Override
	public Matrix3f getShear() {
		return shear;
	}

	@Override
	public Matrix4f updateMatrix() {
		matrix.identity();

		matrix.translate(translation);

		matrix.rotate(rotation);

		matrix.mulAffine(getShearMatrix());

		matrix.scale(scale);

		return matrix;
	}

	@Override
	public Transform3DShear update() {
		updateMatrix();
		return this;
	}

	@Override
	public Matrix4f getShearMatrix() {
		return new Matrix4f(shear.m00(),
				shear.m01(),
				shear.m02(),
				0f,
				shear.m10(),
				shear.m11(),
				shear.m12(),
				0f,
				shear.m20(),
				shear.m21(),
				shear.m22(),
				0f,
				0f,
				0f,
				0f,
				1f);
	}

	@Override
	public Transform3DShear clone() {
		return new Transform3DShear(translation.get(new Vector3f()),
				rotation.get(new Quaternionf()),
				scale.get(new Vector3f()),
				shear.get(new Matrix3f()));
	}

	@Override
	public String toString() {
		return "Transform3DShear [translation=" + translation + ", rotation=" + rotation + ", scale=" + scale + ", shear="
				+ shear + "]";
	}
}
