package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3i;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec3iAttribArray extends AttribArray {

	public static final int DATA_SIZE = 3;

	private Vector3i[] data;

	public Vec3iAttribArray(String name, int index, int dataSize, Vector3i[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Vec3iAttribArray(String name, int index, int dataSize, Vector3i[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Vec3iAttribArray(String name, int index, int dataSize, Vector3i[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public Vec3iAttribArray(String name, int index, int dataSize, Vector3i[] data, boolean _static, int divisor) {
		super(name, index, dataSize, _static, divisor);
		this.data = data;
	}

	public Vec3iAttribArray(String name, int index, int dataSize, Vector3i[] data, BufferType bufferType,
			boolean _static, int divisor) {
		super(name, index, dataSize, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data),
				iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize * DATA_SIZE, GL_W.GL_INT, 0, 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector3i[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException(
					"Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
	}

	public void resize(Vector3i[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
		} else {
			GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(nPos),
					iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize * DATA_SIZE, GL_W.GL_INT, 0, 0);
		}
	}

	public IntAttribArray toIntAttribArray() {
		return new IntAttribArray(name, index, dataSize * DATA_SIZE, GameEngineUtils.toFlatArray(data), bufferType,
				iStatic);
	}

	public UIntAttribArray toUIntAttribArray() {
		return new UIntAttribArray(name, index, dataSize * DATA_SIZE, GameEngineUtils.toFlatArray(data), bufferType,
				iStatic);
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Vector3i get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Vector3i[] getData() {
		return data;
	}

}
