package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Matrix4f;
import org.joml.Vector4f;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Vec4fAttribArray extends AttribArray {

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

		if (bufferType != BufferType.ELEMENT_ARRAY)
			GL_W.glVertexAttribPointer(index, dataSize * 4, GL_W.GL_FLOAT, false, 0, 0);
	}

	public boolean update(Vector4f[] nPos) {
		if (!iStatic && nPos.length != data.length)
			return false;
		data = nPos;

		GL_W.glBufferSubData(GL_W.GL_ARRAY_BUFFER, 0, GameEngineUtils.toFlatArray(data));
		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * 4, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	public boolean resize(Vector4f[] nPos) {
		data = nPos;

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		} else {
			GL_W
					.glBufferData(bufferType.getGlId(),
							GameEngineUtils.toFlatArray(data),
							iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_INT, 0, 0);
		}

		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
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
