package lu.kbra.standalone.gameengine.cache.attrib;

import java.nio.FloatBuffer;
import java.util.Arrays;

import org.joml.Matrix3x2f;
import org.lwjgl.BufferUtils;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Mat3x2fAttribArray extends AttribArray {

	private Matrix3x2f[] data;

	public Mat3x2fAttribArray(String name, int index, int dataSize, Matrix3x2f[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, int dataSize, Matrix3x2f[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, int dataSize, Matrix3x2f[] data, boolean iStatic) {
		super(name, index, dataSize, iStatic);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, int dataSize, Matrix3x2f[] data, boolean iStatic, int divisor) {
		super(name, index, dataSize, iStatic, divisor);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, int dataSize, Matrix3x2f[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public Mat3x2fAttribArray(String name, int index, int dataSize, Matrix3x2f[] data, BufferType bufferType, boolean iStatic,
			int divisor) {
		super(name, index, dataSize, bufferType, iStatic, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		bind();
		
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		assert GL_W.checkError("BufferData(" + bufferType + ", " + data.length * 6 + ", " + iStatic + ")");
	}
	
	@Override
	public void update() {
		update(data);
	}

	public void update(Matrix3x2f[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + data.length * 6 + ")");
	}

	public void resize(Matrix3x2f[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
			assert GL_W.checkError("BufferSubData(" + bufferType + ", 0..." + nPos.length * 6 + ")");
		} else {
			GL_W
					.glBufferData(bufferType.getGlId(),
							GameEngineUtils.toFlatArray(nPos),
							iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
			assert GL_W.checkError("BufferData(" + bufferType + ", " + nPos.length + ", " + iStatic + ")");
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribPointer(index, dataSize, GL_W.GL_FLOAT, false, 0, 0);
			assert GL_W.checkError("VertexAttribPointer(" + index + ", " + dataSize + ", FLOAT)");
		}
	}

	@Override
	public void enable() {
		for (int i = 0; i < 3; i++) {
			GL_W.glEnableVertexAttribArray(index + i);
			assert GL_W.checkError("EnableVertexAttribArray(" + index + i + ")");
			GL_W.glVertexAttribPointer(index + i, 2, GL_W.GL_FLOAT, false, 6 * 3, i * 2 * 4);
			assert GL_W.checkError("VertexAttribPointer(" + index + ", " + dataSize + ", FLOAT)");
			GL_W.glVertexAttribDivisor(index + i, divisor);
			assert GL_W.checkError("VertexAttribDivisor(" + index + i + ", " + divisor + ")");
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * 3 * 2, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Matrix3x2f get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Matrix3x2f[] getData() {
		return data;
	}

}
