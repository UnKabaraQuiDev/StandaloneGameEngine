package lu.kbra.standalone.gameengine.cache.attrib;

import java.nio.ByteBuffer;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.ByteJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class UByteAttribArray extends AttribArray implements ByteJavaTypeAttribArray {

	private byte[] data;

	public UByteAttribArray(String name, int index, byte[] data) {
		super(name, index);
		this.data = data;
	}

	public UByteAttribArray(String name, int index, byte[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public UByteAttribArray(String name, int index, byte[] data, BufferType bufferType, boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public UByteAttribArray(String name, int index, byte[] data, boolean _static, int divisor) {
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

		if (isVertexArray()) {
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_BYTE, getElementByteSize(), 0);
		}
	}

	public void update(byte[] nPos) {
		if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		update(0, nPos);
	}

	public void update(int index, byte[] nPos) {
		bind();

		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		}

		System.arraycopy(nPos, 0, data, index, nPos.length);
		super.length = data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(nPos.length);
		bbuffer.put(nPos);
		bbuffer.flip();

		GL_W.glBufferSubData(bufferType.getGlId(), index * getElementByteSize(), bbuffer);
	}

	public void resize(byte[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(data.length);
		bbuffer.put(data);
		bbuffer.flip();

		if (sameSize) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, bbuffer);
		} else {
			GL_W.glBufferData(bufferType.getGlId(), bbuffer, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (isVertexArray()) {
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, getElementByteSize(), 0);
		}
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	@Override
	public int getLength() {
		return isLoaded() ? (length = data.length) : super.getLength();
	}

	public Byte get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public byte[] getData() {
		return data;
	}

	@Override
	public void update() {
		update(data);
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
