package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Matrix4f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.MatrixAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.MultiAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Mat4fAttribArray extends AttribArray implements MultiAttribArray, FloatJavaTypeAttribArray, MatrixAttribArray {

	public static final int ATTRIB_LENGTH = 4;

	private Matrix4f[] data;

	public Mat4fAttribArray(String name, int index, Matrix4f[] data) {
		super(name, index);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, Matrix4f[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, Matrix4f[] data, boolean iStatic) {
		super(name, index, iStatic);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, Matrix4f[] data, boolean iStatic, int divisor) {
		super(name, index, iStatic, divisor);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, Matrix4f[] data, BufferType bufferType, boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, Matrix4f[] data, BufferType bufferType, boolean iStatic, int divisor) {
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

	public void update(Matrix4f[] nPos) {
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

	public void resize(Matrix4f[] nPos) {
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
		return new FloatAttribArray(name, index, toFlatArray(), bufferType, iStatic);
	}

	@Override
	public Class<?> getType() {
		return Matrix4f.class;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Matrix4f get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Matrix4f[] getData() {
		return data;
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(data);
	}

	@Override
	public int getColumnComponentCount() {
		return 4;
	}

	@Override
	public int getLineComponentCount() {
		return 4;
	}

	@Override
	public int getElementComponentCount() {
		return MatrixAttribArray.super.getElementComponentCount();
	}

}
