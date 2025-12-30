package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector2f;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec2fAttribArray extends AttribArray {

	public static final int TYPE_SIZE = 2;

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
		bind();

		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, dataSize * TYPE_SIZE, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector2f[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
	}

	public void resize(Vector2f[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		} else {
			GL_W
					.glBufferData(bufferType.getGlId(),
							GameEngineUtils.toFlatArray(data),
							iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, dataSize * TYPE_SIZE, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * TYPE_SIZE, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public Class<?> getType() {
		return Vector2f.class;
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
	}@Override
	public int getTypeSize() {
		return TYPE_SIZE;
	}

}
