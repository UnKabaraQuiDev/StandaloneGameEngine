package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector4f;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class SyntheticVec4fAttribArray extends Vec4fAttribArray {

	public SyntheticVec4fAttribArray(final String name, final int index, final int dataLength, final boolean _static, final int divisor) {
		super(name, index, null, _static, divisor);
		super.length = dataLength;
	}

	public SyntheticVec4fAttribArray(final String name, final int index, final int dataLength, final boolean _static) {
		super(name, index, null, _static);
		super.length = dataLength;
	}

	public SyntheticVec4fAttribArray(
			final String name,
			final int index,
			final int dataLength,
			final BufferType bufferType,
			final boolean _static,
			final int divisor) {
		super(name, index, null, bufferType, _static, divisor);
		super.length = dataLength;
	}

	public SyntheticVec4fAttribArray(
			final String name,
			final int index,
			final int dataLength,
			final BufferType bufferType,
			final boolean _static) {
		super(name, index, null, bufferType, _static);
		super.length = dataLength;
	}

	public SyntheticVec4fAttribArray(final String name, final int index, final int dataLength, final BufferType bufferType) {
		super(name, index, null, bufferType);
		super.length = dataLength;
	}

	public SyntheticVec4fAttribArray(final String name, final int index, final int dataLength) {
		super(name, index, null);
		super.length = dataLength;
	}

	@Override
	public void init() {
		bind();

		GL_W.glBufferData(bufferType.getGlId(),
				length * getElementByteSize(),
				iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (bufferType == BufferType.ARRAY)
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
	}

	@Override
	public void update(final Vector4f[] nPos) {
		if (iStatic)
			throw new UnsupportedOperationException("Array is static.");
		if (nPos.length != super.length)
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + super.length + ").");
		bind();

		GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
	}

	public void resize(final int newSize) {
		bind();

		if (newSize == super.length)
			//			GL_W.glBufferSubData(bufferType.getGlId(), 0, nPos);
			return;
		GL_W.glBufferData(bufferType.getGlId(),
				newSize * getElementByteSize(),
				iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		super.length = newSize;

		if (isVertexArray())
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
	}

	@Override
	public void resize(final Vector4f[] nPos) {
		bind();

		if (nPos.length == super.length)
			GL_W.glBufferSubData(bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
		else
			GL_W.glBufferData(bufferType.getGlId(),
					GameEngineUtils.toFlatArray(nPos),
					iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		super.length = nPos.length;

		if (isVertexArray())
			GL_W.glVertexAttribPointer(index, getElementComponentCount(), GL_W.GL_FLOAT, false, getElementByteSize(), 0);
	}

}
