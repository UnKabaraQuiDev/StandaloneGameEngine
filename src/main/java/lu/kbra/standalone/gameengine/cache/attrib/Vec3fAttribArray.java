package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec3fAttribArray extends AttribArray implements FloatJavaTypeAttribArray {

	protected Vector3f[] data;

	public Vec3fAttribArray(String name, int index, Vector3f[] data) {
		super(name, index);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, Vector3f[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, Vector3f[] data, BufferType bufferType, boolean _static) {
		super(name, index, bufferType, _static);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, Vector3f[] data, BufferType bufferType, int _divisor) {
		super(name, index, bufferType, _divisor);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, Vector3f[] data, BufferType bufferType, boolean _static, int _divisor) {
		super(name, index, bufferType, _static, _divisor);
		this.data = data;
	}

	public Vec3fAttribArray(String name, int index, Vector3f[] data, boolean _static) {
		super(name, index, _static);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray()) {
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector3f[] nPos) {
		bind();

		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		data = nPos;
		length = data.length;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, toFlatArray());
	}

	public void resize(Vector3f[] nPos) {
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
			// TODO: test this
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, toFlatArray(), bufferType, iStatic);
	}

	@Override
	public int getLength() {
		return isLoaded() ? (length = data.length) : super.getLength();
	}

	@Override
	public Class<?> getType() {
		return Vector3f.class;
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

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(data);
	}

	@Override
	public int getElementComponentCount() {
		return 3;
	}

}
