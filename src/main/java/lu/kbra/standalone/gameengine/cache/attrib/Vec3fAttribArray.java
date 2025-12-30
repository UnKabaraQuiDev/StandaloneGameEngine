package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec3fAttribArray extends AttribArray {

	public static final int DATA_SIZE = 3;

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
		bind();

		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM) {
			GL_W.glVertexAttribPointer(index, dataSize * DATA_SIZE, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector3f[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
	}

	public void resize(Vector3f[] nPos) {
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
			// TODO: test this
			GL_W.glVertexAttribPointer(index, dataSize * DATA_SIZE, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * DATA_SIZE, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public Class<?> getType() {
		return Vector3f.class;
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
