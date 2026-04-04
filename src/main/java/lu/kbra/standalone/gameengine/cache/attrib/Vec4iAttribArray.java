package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector4i;

import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.IntegerJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec4iAttribArray extends JavaAttribArray implements IntegerJavaTypeAttribArray {

	private Vector4i[] data;

	public Vec4iAttribArray(final String name, final int index, final Vector4i[] data) {
		super(name, index);
		this.data = data;
	}

	public Vec4iAttribArray(final String name, final int index, final Vector4i[] data, final BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Vec4iAttribArray(final String name, final int index, final Vector4i[] data, final BufferType bufferType, final boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public Vec4iAttribArray(final String name, final int index, final Vector4i[] data, final boolean _static, final int divisor) {
		super(name, index, _static, divisor);
		this.data = data;
	}

	public Vec4iAttribArray(
			final String name,
			final int index,
			final Vector4i[] data,
			final BufferType bufferType,
			final boolean _static,
			final int divisor) {
		super(name, index, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray())
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_INT, getElementByteSize(), 0);
	}

	@Override
	public void update() {
		this.update(data);
	}

	public void update(final Vector4i[] nPos) {
		bind();

		if (iStatic)
			throw new UnsupportedOperationException("Array is static.");
		if (nPos.length != data.length)
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");

		data = nPos;
		super.length = data.length;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
	}

	public void resize(final Vector4i[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		if (sameSize)
			GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
		else
			GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray())
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_INT, getElementByteSize(), 0);
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
		return isLoaded() ? (length = data.length) : super.getLength();
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	@Override
	public Vector4i get(final int i) {
		return !isLoaded() ? null : data[i];
	}

	@Override
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
