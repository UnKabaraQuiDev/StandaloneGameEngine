package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector4i;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.IntegerJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec4iAttribArray extends AttribArray implements IntegerJavaTypeAttribArray {

	private Vector4i[] data;

	public Vec4iAttribArray(String name, int index, Vector4i[] data) {
		super(name, index);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, Vector4i[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, Vector4i[] data, BufferType bufferType, boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, Vector4i[] data, boolean _static, int divisor) {
		super(name, index, _static, divisor);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, Vector4i[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray()) {
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, getElementByteSize(), 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector4i[] nPos) {
		bind();

		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		data = nPos;
		super.length = data.length;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
	}

	public void resize(Vector4i[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		if (sameSize) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
		} else {
			GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (isVertexArray()) {
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, getElementByteSize(), 0);
		}
	}

	public IntAttribArray toIntAttribArray() {
		return new IntAttribArray(name, index, toFlatArray(), bufferType, iStatic, divisor);
	}

//	public UIntAttribArray toUIntAttribArray() {
//		return new UIntAttribArray(name, index * TYPE_SIZE, toFlatArray(), bufferType, iStatic);
//	}

	@Override
	public Class<?> getType() {
		return Vector4i.class;
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

	@Override
	public int getElementComponentCount() {
		return 4;
	}

	@Override
	public int[] toFlatArray() {
		return GameEngineUtils.toFlatArray(data);
	}

}
