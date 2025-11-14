package lu.kbra.standalone.gameengine.cache.attrib;

import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class FloatAttribArray extends AttribArray {

	private float[] data;

	public FloatAttribArray(String name, int index, int dataSize, float[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, int dataSize, float[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, int dataSize, float[] data, BufferType bufferType, boolean _static) {
		super(name, index, dataSize, bufferType, _static);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, int dataSize, float[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, dataSize, bufferType, _static, divisor);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, int dataSize, float[] data, boolean _static) {
		super(name, index, dataSize, _static);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, int dataSize, float[] data, boolean _static, int divisor) {
		super(name, index, dataSize, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM)
			GL_W.glVertexAttribPointer(index, dataSize, GL_W.GL_FLOAT, false, 0, 0);
	}

	public boolean update(float[] nPos) {
		if (!iStatic && nPos.length != data.length)
			return false;
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, data);

		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	@Override
	public float[] getData() {
		return data;
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	@Override
	public Float get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public boolean resize(float[] nPos) {
		data = nPos;

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, data);
		} else {
			GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_INT, 0, 0);
		}

		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

}
