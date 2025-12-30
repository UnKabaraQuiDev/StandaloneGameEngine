package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Matrix3x2f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.MatrixAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.MultiAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Mat3x2fAttribArray extends AttribArray implements MultiAttribArray, FloatJavaTypeAttribArray, MatrixAttribArray {

	private Matrix3x2f[] data;

	public Mat3x2fAttribArray(String name, int index, Matrix3x2f[] data) {
		super(name, index);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, Matrix3x2f[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, Matrix3x2f[] data, boolean iStatic) {
		super(name, index, iStatic);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, Matrix3x2f[] data, boolean iStatic, int divisor) {
		super(name, index, iStatic, divisor);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, Matrix3x2f[] data, BufferType bufferType, boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, Matrix3x2f[] data, BufferType bufferType, boolean iStatic, int divisor) {
		super(name, index, bufferType, iStatic, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		
		if (isVertexArray()) {
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Matrix3x2f[] nPos) {
		bind();

		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		data = nPos;
		super.length = data.length;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
	}

	public void resize(Matrix3x2f[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		if (sameSize) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
		} else {
			GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (isVertexArray()) {
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
		}
	}

	@Override
	public void enable() {
		bind();
		
		for (int i = 0; i < getAttribArrayCount(); i++) {
			GL_W.glEnableVertexAttribArray(index + i);
			GL_W
					.glVertexAttribPointer(index
							+ i, getColumnComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), i * getElementByteSize());
			GL_W.glVertexAttribDivisor(index + i, divisor);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, toFlatArray(), bufferType, iStatic, divisor);
	}

	@Override
	public Class<?> getType() {
		return Matrix3x2f.class;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Matrix3x2f get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Matrix3x2f[] getData() {
		return data;
	}

	@Override
	public int getColumnComponentCount() {
		return 2;
	}

	@Override
	public int getLineComponentCount() {
		return 3;
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(data);
	}

	@Override
	public int getElementComponentCount() {
		return MatrixAttribArray.super.getElementComponentCount();
	}

}
