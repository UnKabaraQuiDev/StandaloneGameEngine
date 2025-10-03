package lu.kbra.standalone.gameengine.cache.attrib;

import java.util.Arrays;

import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class IntAttribArray extends AttribArray {

	protected int[] data;

	public IntAttribArray(String name, int index, int dataSize, int[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int dataSize, int[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int dataSize, int[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int dataSize, int[] data, boolean _static, int divisor) {
		super(name, index, dataSize, _static, divisor);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int dataSize, int[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, dataSize, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		assert GL_W.checkError("BufferData(" + bufferType + ", " + Arrays.toString(data) + ", " + iStatic + ")");
		
		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM) {
			GL_W.glVertexAttribPointer(index, dataSize, GL_W.GL_INT, false, 0, 0);
			assert GL_W.checkError("VertexAttribPointer(" + index + ", " + dataSize + ", INT, FALSE, 0, 0)");
		}
	}

	@Override
	public int getLength() {
		return data.length;
	}

	public int[] getData() {
		return data;
	}

	public Integer get(int i) {
		return data[i];
	}

	public boolean update() {
		return update(data);
	}

	public boolean update(int[] nPos) {
		if (!iStatic && nPos.length != data.length)
			return false;
		data = nPos;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, data);

		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

}
