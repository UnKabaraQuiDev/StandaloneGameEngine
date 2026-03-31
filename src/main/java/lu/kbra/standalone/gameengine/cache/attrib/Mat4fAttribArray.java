package lu.kbra.standalone.gameengine.cache.attrib;

import java.nio.ByteBuffer;

import org.joml.Matrix4f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.MatrixAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.MultiAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Mat4fAttribArray extends JavaAttribArray implements MultiAttribArray, FloatJavaTypeAttribArray, MatrixAttribArray {

	public static final int ATTRIB_LENGTH = 4;

	private Matrix4f[] data;

	public Mat4fAttribArray(final String name, final int index, final Matrix4f[] data) {
		super(name, index);
		this.data = data;
	}

	public Mat4fAttribArray(final String name, final int index, final Matrix4f[] data, final BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Mat4fAttribArray(final String name, final int index, final Matrix4f[] data, final boolean iStatic) {
		super(name, index, iStatic);
		this.data = data;
	}

	public Mat4fAttribArray(final String name, final int index, final Matrix4f[] data, final boolean iStatic, final int divisor) {
		super(name, index, iStatic, divisor);
		this.data = data;
	}

	public Mat4fAttribArray(final String name, final int index, final Matrix4f[] data, final BufferType bufferType, final boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public Mat4fAttribArray(final String name, final int index, final Matrix4f[] data, final BufferType bufferType, final boolean iStatic,
			final int divisor) {
		super(name, index, bufferType, iStatic, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		this.bind();

		super.length = this.data.length;

		GL_W.glBufferData(this.bufferType.getGlId(), this.toFlatArray(), this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
	}

	@Override
	public void update() {
		this.update(this.data);
	}

	public void update(final Matrix4f[] nPos) {
		this.bind();

		if (this.iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != this.data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + this.data.length + ").");
		}

		this.data = nPos;
		super.length = this.data.length;

		GL_W.glBufferSubData(this.bufferType.getGlId(), 0, this.toFlatArray());
	}

	public void update(final int index, final Matrix4f[] nPos) {
		this.bind();

		if (this.iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		}

		System.arraycopy(nPos, 0, this.data, index, nPos.length);
		super.length = this.data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(nPos.length * this.getElementByteSize());
		int offset = 0;
		for (final Matrix4f nPo : nPos) {
			nPo.get(offset, bbuffer);
			offset += 16 * Float.BYTES;
		}
//		bbuffer.flip();

		GL_W.glBufferSubData(this.bufferType.getGlId(), index * this.getElementByteSize(), bbuffer);
	}

	public void resize(final Matrix4f[] nPos) {
		this.bind();

		final boolean sameSize = nPos.length == this.data.length;
		this.data = nPos;
		super.length = this.data.length;

		if (sameSize) {
			GL_W.glBufferSubData(this.bufferType.getGlId(), 0, this.toFlatArray());
		} else {
			GL_W.glBufferData(this.bufferType.getGlId(), this.toFlatArray(), this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}
	}

	@Override
	public void enable() {
		this.bind();

		for (int i = 0; i < this.getAttribArrayCount(); i++) {
			GL_W.glEnableVertexAttribArray(this.index + i);
			GL_W.glVertexAttribPointer(this.index
					+ i, this.getColumnComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), i * this.getColumnByteSize());
			GL_W.glVertexAttribDivisor(this.index + i, this.divisor);
		}
	}

	@Override
	public void disable() {
		this.bind();

		for (int i = 0; i < this.getAttribArrayCount(); i++) {
			GL_W.glDisableVertexAttribArray(this.index + i);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(this.name, this.index, this.toFlatArray(), this.bufferType, this.iStatic);
	}

	@Override
	public Class<Matrix4f> getType() {
		return Matrix4f.class;
	}

	@Override
	public int getLength() {
		return this.isLoaded() ? (this.length = this.data.length) : super.getLength();
	}

	@Override
	public boolean isLoaded() {
		return this.data != null;
	}

	@Override
	public Matrix4f get(final int i) {
		return !this.isLoaded() ? null : this.data[i];
	}

	@Override
	public Matrix4f[] getData() {
		return this.data;
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(this.data);
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
