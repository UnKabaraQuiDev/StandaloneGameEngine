package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector4i;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Vec4iAttribArray extends AttribArray {

	public static final int DATA_SIZE = 4;

	private Vector4i[] data;

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, boolean _static, int divisor) {
		super(name, index, dataSize, _static, divisor);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, dataSize, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		assert GL_W.checkError("BufferData(" + bufferType + ", 0, " + data.length * DATA_SIZE + ")");

		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM) {
			GL_W.glVertexAttribIPointer(index, dataSize * DATA_SIZE, GL_W.GL_INT, 0, 0);
			assert GL_W.checkError("VertexAttribIPointer(" + index + ", " + dataSize + ", INT, 0, 0)");
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector4i[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		assert GL_W.checkError("BufferSubData(" + bufferType + ", 0, " + data.length * DATA_SIZE + ")");
	}

	public void resize(Vector4i[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
			assert GL_W.checkError("BufferSubData(" + bufferType + ", 0, " + nPos.length + ")");
		} else {
			GL_W
					.glBufferData(bufferType.getGlId(),
							GameEngineUtils.toFlatArray(nPos),
							iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
			assert GL_W.checkError("BufferData(" + bufferType + ", " + nPos.length + ", " + iStatic + ")");
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM) {
			GL_W.glVertexAttribIPointer(index, dataSize * DATA_SIZE, GL_W.GL_INT, 0, 0);
			assert GL_W.checkError("VertexAttribIPointer(" + index + ", " + dataSize * DATA_SIZE + ", INT)");
		}
	}

	public IntAttribArray toIntAttribArray() {
		return new IntAttribArray(name, index, dataSize * DATA_SIZE, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	public UIntAttribArray toUIntAttribArray() {
		return new UIntAttribArray(name, index, dataSize * DATA_SIZE, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Vector4i get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Vector4i[] getData() {
		return data;
	}

}
