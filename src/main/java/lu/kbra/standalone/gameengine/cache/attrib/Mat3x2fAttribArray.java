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

	public Mat3x2fAttribArray(
			String name,
			int index,
			int dataSize,
			Matrix3x2f[] data,
			BufferType bufferType,
			boolean iStatic,
			int divisor) {
		super(name, index, dataSize, bufferType, iStatic, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
	}

	public boolean update(Matrix3x2f[] nPos) {
		if (!iStatic && nPos.length != data.length) {
			return false;
		}
		data = nPos;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	public boolean resize(Matrix3x2f[] nPos) {
		data = nPos;

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		} else {
			GL_W
					.glBufferData(bufferType.getGlId(),
							GameEngineUtils.toFlatArray(data),
							iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_INT, 0, 0);
		}

		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	@Override
	public void enable() {
		for (int i = 0; i < 3; i++) {
			GL_W.glEnableVertexAttribArray(index + i);
			GL_W.glVertexAttribPointer(index + i, 2, GL_W.GL_FLOAT, false, 6 * 3, i * 2 * 4);
			GL_W.glVertexAttribDivisor(index + i, divisor);
		}
	}

	public FloatBuffer toFlatFloatBuffer() {
		FloatBuffer fb = BufferUtils.createFloatBuffer(data.length * 3 * 2);
		Arrays.stream(data).forEach(m -> m.get(fb));
		fb.flip();
		return fb;
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
