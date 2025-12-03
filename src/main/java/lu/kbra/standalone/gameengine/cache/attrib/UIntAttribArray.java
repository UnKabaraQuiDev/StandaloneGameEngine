package lu.kbra.standalone.gameengine.cache.attrib;

import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class UIntAttribArray extends AttribArray {

	private int[] data;

	public UIntAttribArray(String name, int index, int dataSize, int[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int dataSize, int[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int dataSize, int[] data, BufferType bufferType, boolean _static) {
		super(name, index, dataSize, bufferType, _static);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int dataSize, int[] data, boolean _static, int divisor) {
		super(name, index, dataSize, _static, divisor);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int dataSize, int[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, dataSize, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();
		
		GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		assert GL_W.checkError("BufferData(" + bufferType + ", " + data.length + ", " + iStatic + ")");

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_INT, 0, 0);
			assert GL_W.checkError("VertexAttribIPointer(" + index + ", " + dataSize + ", UINT)");
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(int[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, data);
		assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + data.length + ")");
	}

	public void resize(int[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, nPos);
			assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + nPos.length + ")");
		} else {
			GL_W.glBufferData(bufferType.getGlId(), nPos, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
			assert GL_W.checkError("BufferData(" + bufferType + ", " + nPos.length + ", " + iStatic + ")");
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_INT, 0, 0);
			assert GL_W.checkError("VertexAttribIPointer(" + index + ", " + dataSize + ", UINT)");
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

	public Integer get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public int[] getData() {
		return data;
	}

}
