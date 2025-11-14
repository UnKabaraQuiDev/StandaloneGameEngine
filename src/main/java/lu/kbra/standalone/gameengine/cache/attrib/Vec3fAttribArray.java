package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Vec3fAttribArray extends AttribArray {

	private Vector3f[] data;

	public Vec3fAttribArray(String name, int index, int dataSize, Vector3f[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, int dataSize, Vector3f[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, int dataSize, Vector3f[] data, BufferType bufferType, boolean _static) {
		super(name, index, dataSize, bufferType, _static);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, int dataSize, Vector3f[] data, BufferType bufferType, int _divisor) {
		super(name, index, dataSize, bufferType, _divisor);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, int dataSize, Vector3f[] data, BufferType bufferType, boolean _static, int _divisor) {
		super(name, index, dataSize, bufferType, _static, _divisor);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, int dataSize, Vector3f[] data, boolean _static) {
		super(name, index, dataSize, _static);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM)
			GL_W.glVertexAttribPointer(index, dataSize * 3, GL_W.GL_FLOAT, false, 0, 0);
	}

	public boolean update(Vector3f[] nPos) {
		if (!iStatic && nPos.length != data.length)
			throw new IllegalArgumentException("Array's size cannot change");
		data = nPos;

		GL_W.glBufferSubData(GL_W.GL_ARRAY_BUFFER, 0, GameEngineUtils.toFlatArray(data));
		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	public boolean resize(Vector3f[] nPos) {
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

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * 3, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Vector3f get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Vector3f[] getData() {
		return data;
	}

}
