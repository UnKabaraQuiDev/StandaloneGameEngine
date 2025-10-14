package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3i;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Vec3iAttribArray extends AttribArray {

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
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		assert GL_W.checkError("BufferData(" + bufferType + ", " + data.length * 3 + ", " + iStatic + ")");

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize * 3, GL_W.GL_UNSIGNED_INT, 0, 0);
			assert GL_W.checkError("VertexAttribIPointer(" + index + ", " + dataSize + ", GL_UNSIGNED_INT, 0, 0)");
		}
	}

	public boolean update(Vector3i[] nPos) {
		if (!iStatic && nPos.length != data.length)
			throw new IllegalArgumentException("Array's size cannot change");
		data = nPos;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		assert GL_W.checkError("BufferSubData(" + bufferType + ", 0, " + data.length * 3 + ")");

		return true;
	}

	@Override
	public int getLength() {
		return data.length;
	}

	public IntAttribArray toIntAttribArray() {
		return new IntAttribArray(name, index, dataSize * 3, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	public UIntAttribArray toUIntAttribArray() {
		return new UIntAttribArray(name, index, dataSize * 3, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	public Vector3i[] getData() {
		return data;
	}

	public Vector3i get(int i) {
		return data[i];
	}

}
