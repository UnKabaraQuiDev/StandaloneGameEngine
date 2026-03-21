package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.FloatJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec3fAttribArray extends JavaAttribArray implements FloatJavaTypeAttribArray {

	protected Vector3f[] data;

	public Vec3fAttribArray(final String name, final int index, final Vector3f[] data) {
		super(name, index);
		this.data = data;
	}

	public Vec3fAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public Vec3fAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType, final boolean _static) {
		super(name, index, bufferType, _static);
		this.data = data;
	}

	public Vec3fAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType, final int _divisor) {
		super(name, index, bufferType, _divisor);
		this.data = data;
	}

	public Vec3fAttribArray(final String name, final int index, final Vector3f[] data, final BufferType bufferType, final boolean _static,
			final int _divisor) {
		super(name, index, bufferType, _static, _divisor);
		this.data = data;
	}

	public Vec3fAttribArray(final String name, final int index, final Vector3f[] data, final boolean _static) {
		super(name, index, _static);
		this.data = data;
	}

	@Override
	public void init() {
		this.bind();

		this.length = this.data.length;

		GL_W.glBufferData(this.bufferType.getGlId(), this.toFlatArray(), this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (this.isVertexArray()) {
			GL_W.glVertexAttribPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), 0);
		}
	}

	@Override
	public void update() {
		this.update(this.data);
	}

	public void update(final Vector3f[] nPos) {
		this.bind();

		if (this.iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != this.data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + this.data.length + ").");
		}

		this.data = nPos;
		this.length = this.data.length;

		GL_W.glBufferSubData(this.bufferType.getGlId(), 0, this.toFlatArray());
	}

	public void resize(final Vector3f[] nPos) {
		this.bind();

		final boolean sameSize = nPos.length == this.data.length;
		this.data = nPos;
		super.length = this.data.length;

		if (sameSize) {
			GL_W.glBufferSubData(this.bufferType.getGlId(), 0, this.toFlatArray());
		} else {
			GL_W.glBufferData(this.bufferType.getGlId(), this.toFlatArray(), this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (this.isVertexArray()) {
			// TODO: test this
			GL_W.glVertexAttribPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), 0);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(this.name, this.index, this.toFlatArray(), this.bufferType, this.iStatic);
	}

	@Override
	public int getLength() {
		return this.isLoaded() ? (this.length = this.data.length) : super.getLength();
	}

	@Override
	public Class<?> getType() {
		return Vector3f.class;
	}

	@Override
	public boolean isLoaded() {
		return this.data != null;
	}

	@Override
	public Vector3f get(final int i) {
		return !this.isLoaded() ? null : this.data[i];
	}

	@Override
	public Vector3f[] getData() {
		return this.data;
	}

	@Override
	public float[] toFlatArray() {
		return GameEngineUtils.toFlatArray(this.data);
	}

	@Override
	public int getElementComponentCount() {
		return 3;
	}

}
