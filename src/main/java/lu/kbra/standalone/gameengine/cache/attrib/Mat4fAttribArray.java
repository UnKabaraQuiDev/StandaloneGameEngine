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

	public Mat4fAttribArray(
			final String name,
			final int index,
			final Matrix4f[] data,
			final BufferType bufferType,
			final boolean iStatic,
			final int divisor) {
		super(name, index, bufferType, iStatic, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
	}

	@Override
	public void update() {
		this.update(data);
	}

	public void update(final Matrix4f[] nPos) {
		bind();

		if (iStatic)
			throw new UnsupportedOperationException("Array is static.");
		if (nPos.length != data.length)
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");

		data = nPos;
		super.length = data.length;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
	}

	public void update(final int index, final Matrix4f[] nPos) {
		bind();

		if (iStatic)
			throw new UnsupportedOperationException("Array is static.");

		System.arraycopy(nPos, 0, data, index, nPos.length);
		super.length = data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(nPos.length * getElementByteSize());
		int offset = 0;
		for (final Matrix4f nPo : nPos) {
			nPo.get(offset, bbuffer);
			offset += 16 * Float.BYTES;
		}
		// bbuffer.flip();

		GL_W.glBufferSubData(bufferType.getGlId(), index * getElementByteSize(), bbuffer);
	}

	public void resize(final Matrix4f[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		if (sameSize)
			GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
		else
			GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
	}

	@Override
	public void enable() {
		bind();

		for (int i = 0; i < getAttribArrayCount(); i++) {
			GL_W.glEnableVertexAttribArray(index + i);
			GL_W.glVertexAttribPointer(index
					+ i, getColumnComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), i * getColumnByteSize());
			GL_W.glVertexAttribDivisor(index + i, divisor);
		}
	}

	@Override
	public void disable() {
		bind();

		for (int i = 0; i < getAttribArrayCount(); i++)
			GL_W.glDisableVertexAttribArray(index + i);
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, toFlatArray(), bufferType, iStatic);
	}

	@Override
	public Class<Matrix4f> getType() {
		return Matrix4f.class;
	}

	@Override
	public int getLength() {
		return isLoaded() ? (length = data.length) : super.getLength();
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	@Override
	public Matrix4f get(final int i) {
		return !isLoaded() ? null : data[i];
	}

	@Override
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
