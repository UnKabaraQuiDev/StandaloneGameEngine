package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector4f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec4fAttribArray extends AttribArray implements FloatJavaTypeAttribArray {

	private Vector4f[] data;

	public Vec4fAttribArray(String name, int index, Vector4f[] data) {
		super(name, index);
		this.data = data;
	}

	public Vec4fAttribArray(String name, int index, Vector4f[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Vec4fAttribArray(String name, int index, Vector4f[] data, BufferType bufferType, boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray()) {
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, toFlatArray(), bufferType, iStatic, divisor);
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector4f[] nPos) {
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

	public void resize(Vector4f[] nPos) {
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
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
		}
	}

	@Override
	public Class<?> getType() {
		return Vector4f.class;
	}

	@Override
	public int getLength() {
		return isLoaded() ? (length = data.length) : super.getLength();
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
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(data);
	}

	@Override
	public int getElementComponentCount() {
		return 4;
	}

}
