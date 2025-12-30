package lu.kbra.standalone.gameengine.cache.attrib;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class FloatAttribArray extends AttribArray implements FloatJavaTypeAttribArray {

	private float[] data;

	public FloatAttribArray(String name, int index, float[] data) {
		super(name, index);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, float[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, float[] data, BufferType bufferType, boolean _static) {
		super(name, index, bufferType, _static);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, float[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, bufferType, _static, divisor);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, float[] data, boolean _static) {
		super(name, index, _static);
		this.data = data;
	}

	public FloatAttribArray(String name, int index, float[] data, boolean _static, int divisor) {
		super(name, index, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType == BufferType.ARRAY) {
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
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
		super.length = data.length;

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
		super.length = data.length;

		if (isVertexArray()) {
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
		}
	}

	@Override
	public Class<?> getType() {
		return float.class;
	}

	@Override
	public float[] getData() {
		return data;
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
	public float[] toFlatArray() {
		return data;
	}

	@Override
	public int getElementComponentCount() {
		return 1;
	}

}
