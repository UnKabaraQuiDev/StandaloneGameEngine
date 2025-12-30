package lu.kbra.standalone.gameengine.cache.attrib;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

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
		bind();

		GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM) {
			GL_W.glVertexAttribPointer(index, dataSize, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(float[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}
		bind();

		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, data);
	}

	public void resize(float[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, nPos);
		} else {
			GL_W.glBufferData(bufferType.getGlId(), nPos, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, getElementSize(), GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	@Override
	public Class<?> getType() {
		return Float.class;
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

	@Override
	public int getTypeSize() {
		return 1;
	}

}
