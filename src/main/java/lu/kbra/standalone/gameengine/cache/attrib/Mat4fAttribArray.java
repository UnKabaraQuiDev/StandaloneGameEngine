package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Matrix4f;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Mat4fAttribArray extends AttribArray implements MultiAttribArray {

	public static final int DATA_SIZE = 16;

	private Matrix4f[] data;

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, boolean iStatic) {
		super(name, index, dataSize, iStatic);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, boolean iStatic, int divisor) {
		super(name, index, dataSize, iStatic, divisor);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, BufferType bufferType,
			boolean iStatic, int divisor) {
		super(name, index, dataSize, bufferType, iStatic, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data),
				iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Matrix4f[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException(
					"Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
	}

	@Override
	public void enable() {
		bind();

		for (int i = 0; i < 4; i++) {
			GL_W.glEnableVertexAttribArray(index + i);
			GL_W.checkError("EnableVertexAttribArray(" + index + i + ")");
			GL_W.glVertexAttribPointer(index + i, 4, GL_W.GL_FLOAT, false, DATA_SIZE * 4, i * DATA_SIZE);
			GL_W.checkError("VertexAttribPointer(" + index + i + ", 4, FLOAT)");
			GL_W.glVertexAttribDivisor(index + i, divisor);
			GL_W.checkError("VertexAttribDivisor(" + index + i + ", " + divisor + ")");
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * DATA_SIZE, GameEngineUtils.toFlatArray(data), bufferType,
				iStatic);
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
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
	public int getMinIndex() {
		return index;
	}

	@Override
	public int getMaxIndex() {
		return index + 3;
	}

	public void resize(Matrix4f[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
		} else {
			GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(nPos),
					iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, dataSize, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	@Override
	public String toString() {
		return getGlId() + "|" + getMaxIndex() + "-" + getMaxIndex() + ") " + getName() + ": " + getLength() + "/"
				+ getDataSize() + "=" + getDataCount();
	}

}
