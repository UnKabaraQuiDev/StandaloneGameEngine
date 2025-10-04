package lu.kbra.standalone.gameengine.cache.attrib;

import java.nio.ByteBuffer;

import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

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
		return data.length;
	}

	public byte[] getData() {
		return data;
	}

	public Byte get(int i) {
		return data[i];
	}

	public boolean update(byte[] nPos) {
		if (!iStatic && nPos.length != data.length)
			return false;

		data = nPos;

		final ByteBuffer bbuffer = ByteBuffer.allocateDirect(data.length);
		bbuffer.put(data);
		bbuffer.flip();

		GL_W.glBufferSubData(bufferType.getGlId(), 0, bbuffer);
		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

}
