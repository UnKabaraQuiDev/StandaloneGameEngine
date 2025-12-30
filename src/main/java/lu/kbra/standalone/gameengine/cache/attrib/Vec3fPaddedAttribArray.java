package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec3fPaddedAttribArray extends Vec3fAttribArray {

	protected int elementPadLength;

	public Vec3fPaddedAttribArray(String name, int index, Vector3f[] data, int elementPadLength) {
		super(name, index, data);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(String name, int index, Vector3f[] data, BufferType bufferType, int elementPadLength) {
		super(name, index, data, bufferType);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(String name, int index, Vector3f[] data, BufferType bufferType, boolean _static, int elementPadLength) {
		super(name, index, data, bufferType, _static);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(String name, int index, Vector3f[] data, BufferType bufferType, int _divisor, int elementPadLength) {
		super(name, index, data, bufferType, _divisor);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(String name, int index, Vector3f[] data, BufferType bufferType, boolean _static, int _divisor,
			int elementPadLength) {
		super(name, index, data, bufferType, _static, _divisor);
		this.elementPadLength = elementPadLength;
	}

	public Vec3fPaddedAttribArray(String name, int index, Vector3f[] data, boolean _static, int elementPadLength) {
		super(name, index, data, _static);
		this.elementPadLength = elementPadLength;
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(data, elementPadLength);
	}

	public int getElementComponentCount() {
		return elementPadLength;
	}

	public int getElementPadLength() {
		return elementPadLength;
	}

	public int getPadding() {
		return elementPadLength - getElementComponentCount();
	}

}
