package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector4f;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Vec4fAttribArray extends AttribArray {

	public static final int DATA_SIZE = 3;

	private Vector4f[] data;

	public Vec4fAttribArray(String name, int index, int dataSize, Vector4f[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Vec4fAttribArray(String name, int index, int dataSize, Vector4f[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Vec4fAttribArray(String name, int index, int dataSize, Vector4f[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		assert GL_W.checkError("BufferData(" + bufferType + ", " + data.length * DATA_SIZE + ", " + iStatic + ")");

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, dataSize * DATA_SIZE, GL_W.GL_FLOAT, false, 0, 0);
			assert GL_W.checkError("VertexAttribPointer(" + index + ", " + dataSize * DATA_SIZE + ", FLOAT)");

		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * DATA_SIZE, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector4f[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + data.length * DATA_SIZE + ")");
	}

	public void resize(Vector4f[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
			assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + nPos.length * DATA_SIZE + ")");
		} else {
			GL_W
					.glBufferData(bufferType.getGlId(),
							GameEngineUtils.toFlatArray(data),
							iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
			assert GL_W.checkError("BufferData(" + bufferType + ", " + nPos.length * DATA_SIZE + ", " + iStatic + ")");
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, dataSize * DATA_SIZE, GL_W.GL_FLOAT, false, 0, 0);
			assert GL_W.checkError("VertexAttribPointer(" + index + ", " + dataSize * DATA_SIZE + ", FLOAT)");
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

	public Vector4f get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Vector4f[] getData() {
		return data;
	}

}
