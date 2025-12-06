package lu.kbra.standalone.gameengine.cache.attrib;

import java.nio.ByteBuffer;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class UByteAttribArray extends AttribArray {

	private byte[] data;

	public UByteAttribArray(String name, int index, int dataSize, byte[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public UByteAttribArray(String name, int index, int dataSize, byte[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public UByteAttribArray(String name, int index, int dataSize, byte[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public UByteAttribArray(String name, int index, int dataSize, byte[] data, boolean _static, int divisor) {
		super(name, index, dataSize, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(data.length);
		bbuffer.put(data);
		bbuffer.flip();

		GL_W.glBufferData(bufferType.getGlId(), bbuffer, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		assert GL_W.checkError("BufferData(" + bufferType + ", " + bbuffer.remaining() + ", " + iStatic + ")");

		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_BYTE, 0, 0);
			assert GL_W.checkError("VertexAttribIPointer(" + index + ", " + dataSize + ", GL_UNSIGNED_INT, 0, 0)");
		}
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
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

	public void update(byte[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException(
					"Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(data.length);
		bbuffer.put(data);
		bbuffer.flip();

		GL_W.glBufferSubData(bufferType.getGlId(), 0, bbuffer);
		assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + data.length + ")");
	}

	public void resize(byte[] nPos) {
		bind();

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(data.length);
		bbuffer.put(data);
		bbuffer.flip();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, bbuffer);
			assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + nPos.length + ")");
		} else {
			GL_W.glBufferData(bufferType.getGlId(), bbuffer, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
			assert GL_W.checkError("BufferData(" + bufferType + ", " + nPos.length + ", " + iStatic + ")");
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_BYTE, 0, 0);
			assert GL_W.checkError("VertexAttribIPointer(" + index + ", " + dataSize + ", UBYTE)");
		}
	}

}
