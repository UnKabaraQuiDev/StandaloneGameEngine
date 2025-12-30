package lu.kbra.standalone.gameengine.cache.attrib;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.IntegerJavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class UIntAttribArray extends AttribArray implements IntegerJavaTypeAttribArray {

	private int[] data;

	public UIntAttribArray(String name, int index, int[] data) {
		super(name, index);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int[] data, BufferType bufferType) {
		super(name, index, bufferType);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int[] data, BufferType bufferType, boolean _static) {
		super(name, index, bufferType, _static);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int[] data, boolean _static, int divisor) {
		super(name, index, _static, divisor);
		this.data = data;
	}

	public UIntAttribArray(String name, int index, int[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();

		super.length = data.length;

		GL_W.glBufferData(bufferType.getGlId(), data, iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (isVertexArray()) {
			GL_W.glVertexAttribIPointer(index, getElementComponentCount(), GL_W.GL_UNSIGNED_INT, getElementByteSize(), 0);
		}
	}

	@Override
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

//		System.err.println(Arrays.toString(data) + " = " + data.length + " <> " + Arrays.toString(nPos) + " = " + nPos.length);

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
		return isLoaded() ? (length = data.length) : super.getLength();
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	@Override
	public Integer get(int i) {
		return !isLoaded() ? null : data[i];
	}

	@Override
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
