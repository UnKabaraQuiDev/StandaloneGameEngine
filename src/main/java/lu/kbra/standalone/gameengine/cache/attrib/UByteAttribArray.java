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
		this.bind();

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(this.data.length);
		bbuffer.put(this.data);
		bbuffer.flip();

		super.length = this.data.length;

		GL_W.glBufferData(this.bufferType.getGlId(), bbuffer, this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (this.isVertexArray()) {
			GL_W.glVertexAttribIPointer(this.index, this.getElementComponentCount(), GL_W.GL_BYTE, this.getElementByteSize(), 0);
		}
	}

	public void update(final byte[] nPos) {
		if (nPos.length != this.data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + this.data.length + ").");
		}

		this.update(0, nPos);
	}

	public void update(final int index, final byte[] nPos) {
		this.bind();

		if (this.iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		}

		System.arraycopy(nPos, 0, this.data, index, nPos.length);
		super.length = this.data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(nPos.length);
		bbuffer.put(nPos);
		bbuffer.flip();

		GL_W.glBufferSubData(this.bufferType.getGlId(), index * this.getElementByteSize(), bbuffer);
	}

	public void resize(final byte[] nPos) {
		this.bind();

		final boolean sameSize = nPos.length == this.data.length;
		this.data = nPos;
		super.length = this.data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(this.data.length);
		bbuffer.put(this.data);
		bbuffer.flip();

		if (sameSize) {
			GL_W.glBufferSubData(this.bufferType.getGlId(), 0, bbuffer);
		} else {
			GL_W.glBufferData(this.bufferType.getGlId(), bbuffer, this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (this.isVertexArray()) {
			GL_W.glVertexAttribIPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, this.getElementByteSize(), 0);
		}
	}

	@Override
	public boolean isLoaded() {
		return this.data != null;
	}

	@Override
	public int getLength() {
		return this.isLoaded() ? (this.length = this.data.length) : super.getLength();
	}

	@Override
	public Byte get(final int i) {
		return !this.isLoaded() ? null : this.data[i];
	}

	@Override
	public byte[] getData() {
		return this.data;
	}

	@Override
	public void update() {
		this.update(this.data);
	}

	@Override
	public int getElementComponentCount() {
		return 1;
	}

	@Override
	public byte[] toFlatArray() {
		return this.data;
	}

}
