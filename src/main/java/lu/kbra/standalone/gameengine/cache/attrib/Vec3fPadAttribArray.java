package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class Vec3fPadAttribArray extends Vec3fAttribArray implements PaddedArray {

	protected int padLength = 4;

	@Override
	public void init() {
		bind();

		GL_W.glBufferData(bufferType.getGlId(), GameEngineUtils.toFlatArray(data), iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType != BufferType.ELEMENT_ARRAY && bufferType != BufferType.UNIFORM) {
			GL_W.glVertexAttribPointer(index, dataSize * TYPE_SIZE, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	@Override
	public void update() {
		update(data);
	}

	public void update(Vector3f[] nPos) {
		if (iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != data.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + data.length + ").");
		}

		bind();
		data = nPos;
		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
	}

	public void resize(Vector3f[] nPos) {
		bind();

		if (nPos.length == data.length) {
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(data));
		} else {
			GL_W
					.glBufferData(bufferType.getGlId(),
							GameEngineUtils.toFlatArray(data),
							iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		data = nPos;

		if (bufferType != BufferType.ELEMENT_ARRAY) {
			// TODO: test this
			GL_W.glVertexAttribPointer(index, dataSize * TYPE_SIZE, GL_W.GL_FLOAT, false, 0, 0);
		}
	}

	public FloatAttribArray toFloatAttribArray() {
		return new FloatAttribArray(name, index, getTotalSize(), GameEngineUtils.toFlatArray(data), bufferType, iStatic);
	}

	@Override
	public Class<?> getType() {
		return Vector3f.class;
	}

	@Override
	public int getLength() {
		return !isLoaded() ? -1 : data.length;
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
	public int getPadding() {
		return padLength - (TYPE_SIZE * getDataSize());
	}

	@Override
	public int getElementSize() {
		return padLength;
	}

	@Override
	public int getTotalSize() {
		return padLength * getDataSize();
	}

}
