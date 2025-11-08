package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector2f;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Vec2fAttribArray extends AttribArray {

	private Vector2f[] data;

	public Vec2fAttribArray(String name, int index, int dataSize, Vector2f[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Vec2fAttribArray(String name, int index, int dataSize, Vector2f[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Vec2fAttribArray(String name, int index, int dataSize, Vector2f[] data, BufferType bufferType, boolean _static) {
		super(name, index, dataSize, bufferType, _static);
		this.data = data;
	}

	public Vec2fAttribArray(String name, int index, int dataSize, Vector2f[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, dataSize, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY)
			GL_W.glVertexAttribPointer(index, dataSize * 2, GL_W.GL_FLOAT, false, 0, 0);
	}

	public boolean update(Vector2f[] nPos) {
		if (!iStatic && nPos.length != data.length)
			return false;
		data = nPos;

		GL_W.glBufferSubData(GL_W.GL_ARRAY_BUFFER, 0, GameEngineUtils.toFlatArray(data));
		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * 2, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Vector2f get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Vector2f[] getData() {
		return data;
	}

}
