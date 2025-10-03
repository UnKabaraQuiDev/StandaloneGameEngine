package lu.kbra.standalone.gameengine.cache.attrib;

import java.util.Arrays;

import org.joml.Vector4i;

import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Vec4iAttribArray extends AttribArray {

	private Vector4i[] data;

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, boolean _static, int divisor) {
		super(name, index, dataSize, _static, divisor);
		this.data = data;
	}

	public Vec4iAttribArray(String name, int index, int dataSize, Vector4i[] data, BufferType bufferType, boolean _static, int divisor) {
		super(name, index, dataSize, bufferType, _static, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), toFlatArray(), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM)
			GL_W.glVertexAttribPointer(index, dataSize, GL_W.GL_INT, false, 0, 0);
	}

	public boolean update(Vector4i[] nPos) {
		if (!iStatic && nPos.length != data.length)
			throw new IllegalArgumentException("Array's size cannot change");
		data = nPos;

		GL_W.glBufferSubData(GL_W.GL_ARRAY_BUFFER, 0, toFlatArray());
		assert GL_W.checkError();
		
		return true;
	}

	@Override
	public int getLength() {
		return data.length;
	}

	public int[] toFlatArray() {
		int[] flatArray = new int[data.length * 3];
		for (int i = 0; i < data.length; i++) {
			int[] dat = new int[3];
			Vector4i cdata = data[i];
			if (cdata != null) {
				dat[0] = cdata.x;
				dat[1] = cdata.y;
				dat[2] = cdata.z;
			} else
				Arrays.fill(dat, 0);
			System.arraycopy(dat, 0, flatArray, i * 3, 3);
		}
		return flatArray;
	}

	public IntAttribArray toIntAttribArray() {
		return new IntAttribArray(name, index, dataSize * 3, toFlatArray(), bufferType, iStatic);
	}
	public UIntAttribArray toUIntAttribArray() {
		return new UIntAttribArray(name, index, dataSize * 3, toFlatArray(), bufferType, iStatic);
	}


	public Vector4i[] getData() {
		return data;
	}

	public Vector4i get(int i) {
		return data[i];
	}

}
