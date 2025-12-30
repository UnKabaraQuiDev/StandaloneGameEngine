package lu.kbra.standalone.gameengine.cache.attrib;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.IntegerJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class IntAttribArray extends AttribArray implements IntegerJavaTypeAttribArray {

	protected int[] data;

	public IntAttribArray(String name, int index, int[] data) {
		super(name, index);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int[] data, BufferType bufferType, boolean s) {
		super(name, index, bufferType, s);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int[] data, boolean _static, int divisor) {
		super(name, index, _static, divisor);
		this.data = data;
	}

	public IntAttribArray(String name, int index, int[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray()) {
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_INT, getElementByteSize(), 0);
		}
	}

	public void update() {
		update(data);
	}

	public void update(int[] nPos) {
		bind();

		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		data = nPos;
		super.length = data.length;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, data);
	}

	public void resize(int[] nPos) {
		bind();

		final boolean sameSize = nPos.length == data.length;
		data = nPos;
		super.length = data.length;

		if (sameSize) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, nPos);
		} else {
			GL_W.glBufferData(bufferType.getGlId(), nPos, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (isVertexArray()) {
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_UNSIGNED_INT, getElementByteSize(), 0);
		}
	}

	@Override
	public Class<?> getType() {
		return int.class;
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Integer get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public int[] getData() {
		return data;
	}

	@Override
	public int[] toFlatArray() {
		return data;
	}

	@Override
	public int getElementComponentCount() {
		return 1;
	}

}
