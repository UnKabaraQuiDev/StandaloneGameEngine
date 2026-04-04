package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector2f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec2fAttribArray extends JavaAttribArray implements FloatJavaTypeAttribArray {

	private Vector2f[] data;

	public Vec2fAttribArray(final String name, final int index, final Vector2f[] data) {
		super(name, index);
		this.data = data;
	}

	public Vec2fAttribArray(final String name, final int index, final Vector2f[] data, final BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Vec2fAttribArray(final String name, final int index, final Vector2f[] data, final BufferType bufferType, final boolean _static) {
		super(name, index, bufferType, _static);
		this.data = data;
	}

	public Vec2fAttribArray(
			final String name,
			final int index,
			final Vector2f[] data,
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
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
	}

	@Override
	public void update() {
		this.update(data);
	}

	public void update(final Vector2f[] nPos) {
		bind();

		if (iStatic)
			throw new UnsupportedOperationException("Array is static.");
		if (nPos.length != data.length)
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");

		data = nPos;
		super.length = data.length;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
	}

	public void resize(final Vector2f[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		if (sameSize)
			GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
		else
			GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray())
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, toFlatArray(), bufferType, iStatic, divisor);
	}

	@Override
	public Class<?> getType() {
		return Vector2f.class;
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
	public Vector2f get(final int i) {
		return !isLoaded() ? null : data[i];
	}

	@Override
	public Vector2f[] getData() {
		return data;
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(data);
	}

	@Override
	public int getElementComponentCount() {
		return 2;
	}

}
