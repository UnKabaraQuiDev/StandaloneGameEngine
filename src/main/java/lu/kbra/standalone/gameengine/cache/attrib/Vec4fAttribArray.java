package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector4f;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec4fAttribArray extends AttribArray {

	public static final int TYPE_SIZE = 3;

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
		bind();

		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, dataSize * TYPE_SIZE, GL_W.GL_FLOAT, false, 0, 0);

		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * TYPE_SIZE, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
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
	}

	public void resize(Vector4f[] nPos) {
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

	@Override
	public Class<?> getType() {
		return Vector4f.class;
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
	}@Override
	public int getTypeSize() {
		return TYPE_SIZE;
	}

}
