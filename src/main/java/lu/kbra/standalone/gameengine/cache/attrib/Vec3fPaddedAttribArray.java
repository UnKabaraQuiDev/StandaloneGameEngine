package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.PaddedAttribArray;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec3fPaddedAttribArray extends Vec3fAttribArray implements PaddedAttribArray {

	protected int elementPadLength;

	public Vec3fPaddedAttribArray(final String name, final int index, final Vector3f[] data, final int elementPadLength) {
		super(name, index, data);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType,
			final int elementPadLength) {
		super(name, index, data, bufferType);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType,
			final boolean _static, final int elementPadLength) {
		super(name, index, data, bufferType, _static);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType,
			final int _divisor, final int elementPadLength) {
		super(name, index, data, bufferType, _divisor);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType,
			final boolean _static, final int _divisor, final int elementPadLength) {
		super(name, index, data, bufferType, _static, _divisor);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(final String name, final int index, final Vector3f[] data, final boolean _static,
			final int elementPadLength) {
		super(name, index, data, _static);
		this.elementPadLength = elementPadLength;
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(this.data, this.elementPadLength);
	}

	@Override
	public int getElementComponentCount() {
		return this.elementPadLength;
	}

	@Override
	public int getElementPadLength() {
		return this.elementPadLength;
	}

	@Override
	public int getElementPadding() {
		return this.elementPadLength - this.getElementComponentCount();
	}

}
