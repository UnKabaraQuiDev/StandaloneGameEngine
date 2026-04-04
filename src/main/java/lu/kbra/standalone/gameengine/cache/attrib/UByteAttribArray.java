package lu.kbra.standalone.gameengine.cache.attrib;

import java.nio.ByteBuffer;

import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.ByteJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class UByteAttribArray extends JavaAttribArray implements ByteJavaTypeAttribArray {

	private byte[] data;

	public UByteAttribArray(final String name, final int index, final byte[] data) {
		super(name, index);
		this.data = data;
	}

	public UByteAttribArray(final String name, final int index, final byte[] data, final BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public UByteAttribArray(final String name, final int index, final byte[] data, final BufferType bufferType, final boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public UByteAttribArray(final String name, final int index, final byte[] data, final boolean _static, final int divisor) {
		super(name, index, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(data.length);
		bbuffer.put(data);
		bbuffer.flip();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), bbuffer, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray())
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_BYTE, getElementByteSize(), 0);
	}

	public void update(final byte[] nPos) {
		if (nPos.length != data.length)
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");

		this.update(0, nPos);
	}

	public void update(final int index, final byte[] nPos) {
		bind();

		if (iStatic)
			throw new UnsupportedOperationException("Array is static.");

		System.arraycopy(nPos, 0, data, index, nPos.length);
		super.length = data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(nPos.length);
		bbuffer.put(nPos);
		bbuffer.flip();

		GL_W.glBufferSubData(bufferType.getGlId(), index * getElementByteSize(), bbuffer);
	}

	public void resize(final byte[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(data.length);
		bbuffer.put(data);
		bbuffer.flip();

		if (sameSize)
			GL_W.glBufferSubData(bufferType.getGlId(), 0, bbuffer);
		else
			GL_W.glBufferData(bufferType.getGlId(), bbuffer, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray())
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, getElementByteSize(), 0);
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	@Override
	public int getLength() {
		return isLoaded() ? (length = data.length) : super.getLength();
	}

	@Override
	public Byte get(final int i) {
		return !isLoaded() ? null : data[i];
	}

	@Override
	public byte[] getData() {
		return data;
	}

	@Override
	public void update() {
		this.update(data);
	}

	@Override
	public int getElementComponentCount() {
		return 1;
	}

	@Override
	public byte[] toFlatArray() {
		return data;
	}

}
