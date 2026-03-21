package lu.kbra.standalone.gameengine.cache.attrib;

import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class FloatAttribArray extends JavaAttribArray implements FloatJavaTypeAttribArray {

	private float[] data;

	public FloatAttribArray(final String name, final int index, final float[] data) {
		super(name, index);
		this.data = data;
	}

	public FloatAttribArray(final String name, final int index, final float[] data, final BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public FloatAttribArray(final String name, final int index, final float[] data, final BufferType bufferType, final boolean _static) {
		super(name, index, bufferType, _static);
		this.data = data;
	}

	public FloatAttribArray(final String name, final int index, final float[] data, final BufferType bufferType, final boolean _static,
			final int divisor) {
		super(name, index, bufferType, _static, divisor);
		this.data = data;
	}

	public FloatAttribArray(final String name, final int index, final float[] data, final boolean _static) {
		super(name, index, _static);
		this.data = data;
	}

	public FloatAttribArray(final String name, final int index, final float[] data, final boolean _static, final int divisor) {
		super(name, index, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		this.bind();

		super.length = this.data.length;

		GL_W.glBufferData(this.bufferType.getGlId(), this.data, this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (this.bufferType == BufferType.ARRAY) {
			GL_W.glVertexAttribPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), 0);
		}
	}

	@Override
	public void update() {
		this.update(this.data);
	}

	public void update(final float[] nPos) {
		if (this.iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != this.data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + this.data.length + ").");
		}
		this.bind();

		this.data = nPos;
		super.length = this.data.length;

		GL_W.glBufferSubData(this.bufferType.getGlId(), 0, this.data);
	}

	public void resize(final float[] nPos) {
		this.bind();

		if (nPos.length == this.data.length) {
			GL_W.glBufferSubData(this.bufferType.getGlId(), 0, nPos);
		} else {
			GL_W.glBufferData(this.bufferType.getGlId(), nPos, this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		this.data = nPos;
		super.length = this.data.length;

		if (this.isVertexArray()) {
			GL_W.glVertexAttribPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), 0);
		}
	}

	@Override
	public int getLength() {
		return this.isLoaded() ? (this.length = this.data.length) : super.getLength();
	}

	@Override
	public float[] getData() {
		return this.data;
	}

	@Override
	public boolean isLoaded() {
		return this.data != null;
	}

	@Override
	public Float get(final int i) {
		return !this.isLoaded() ? null : this.data[i];
	}

	@Override
	public float[] toFlatArray() {
		return this.data;
	}

	@Override
	public int getElementComponentCount() {
		return 1;
	}

}
