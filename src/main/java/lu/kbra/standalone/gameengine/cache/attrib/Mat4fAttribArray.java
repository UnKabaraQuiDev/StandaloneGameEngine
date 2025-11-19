package lu.kbra.standalone.gameengine.cache.attrib;

import java.nio.FloatBuffer;
import java.util.Arrays;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Mat4fAttribArray extends AttribArray implements MultiAttribArray {

	private Matrix4f[] data;

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data) {
		super(name, index, dataSize);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, BufferType bufferType) {
		super(name, index, dataSize, bufferType);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, boolean iStatic) {
		super(name, index, dataSize, iStatic);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, boolean iStatic, int divisor) {
		super(name, index, dataSize, iStatic, divisor);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, BufferType bufferType, boolean s) {
		super(name, index, dataSize, bufferType, s);
		this.data = data;
	}

	public Mat4fAttribArray(String name, int index, int dataSize, Matrix4f[] data, BufferType bufferType,
			boolean iStatic, int divisor) {
		super(name, index, dataSize, bufferType, iStatic, divisor);
		this.data = data;
	}

	@Override
	public void init() {
		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data),
				iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
	}

	public boolean update(Matrix4f[] nPos) {
		if (!iStatic && nPos.length != data.length) {
			return false;
		}
		data = nPos;

		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	@Override
	public void enable() {
		for (int i = 0; i < 4; i++) {
			GL_W.glEnableVertexAttribArray(index + i);
			GL_W.glVertexAttribPointer(index + i, 4, GL_W.GL_FLOAT, false, 16 * 4, i * 4 * 4);
			GL_W.glVertexAttribDivisor(index + i, divisor);
		}
	}

	public FloatBuffer toFlatFloatBuffer() {
		FloatBuffer fb = BufferUtils.createFloatBuffer(data.length * 16);
		Arrays.stream(data).forEach(m -> m.get(fb));
		fb.flip();
		return fb;
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, dataSize * 16, GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
	}

	@Override
	public boolean isLoaded() {
		return data != null;
	}

	public Matrix4f get(int i) {
		return !isLoaded() ? null : data[i];
	}

	public Matrix4f[] getData() {
		return data;
	}

	@Override
	public int getMinIndex() {
		return index;
	}

	@Override
	public int getMaxIndex() {
		return index + 3;
	}

	public boolean resize(Matrix4f[] nPos) {
		bind();
		
		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
			assert GL_W.checkError("BufferSubData(" + bufferType + ", 0, " + nPos.length + ")");
		} else {
			GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(nPos),
					iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
			assert GL_W.checkError("BufferData(" + bufferType + ", " + nPos.length + ", " + iStatic + ")");
		}
		
		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			GL_W.glVertexAttribIPointer(index, dataSize, GL_W.GL_UNSIGNED_INT, 0, 0);
		}

		return GL_W.glGetError() == GL_W.GL_NO_ERROR;
	}

	@Override
	public String toString() {
		return getGlId() + "|" + getMaxIndex() + "-" + getMaxIndex() + ") " + getName() + ": " + getLength() + "/"
				+ getDataSize() + "=" + getDataCount();
	}

}
