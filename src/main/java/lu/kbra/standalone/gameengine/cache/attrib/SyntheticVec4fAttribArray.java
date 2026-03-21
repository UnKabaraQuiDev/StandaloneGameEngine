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

	public SyntheticVec4fAttribArray(final String name, final int index, final int dataLength, final BufferType bufferType,
			final boolean _static, final int divisor) {
		super(name, index, null, bufferType, _static, divisor);
		super.length = dataLength;
	}

	public SyntheticVec4fAttribArray(final String name, final int index, final int dataLength, final BufferType bufferType,
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
		this.bind();

		GL_W.glBufferData(this.bufferType.getGlId(),
				this.length * this.getElementByteSize(),
				this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);

		if (this.bufferType == BufferType.ARRAY) {
			GL_W.glVertexAttribPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), 0);
		}
	}

	@Override
	public void update(final Vector4f[] nPos) {
		if (this.iStatic) {
			throw new UnsupportedOperationException("Array is static.");
		} else if (nPos.length != super.length) {
			throw new IllegalArgumentException("Use #resize to change the array's size (" + nPos.length + "<>" + super.length + ").");
		}
		this.bind();

		GL_W.glBufferSubData(this.bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
	}

	public void resize(final int newSize) {
		this.bind();

		if (newSize == super.length) {
//			GL_W.glBufferSubData(bufferType.getGlId(), 0, nPos);
			return;
		} else {
			GL_W.glBufferData(this.bufferType.getGlId(),
					newSize * this.getElementByteSize(),
					this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		super.length = newSize;

		if (this.isVertexArray()) {
			GL_W.glVertexAttribPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), 0);
		}
	}

	@Override
	public void resize(final Vector4f[] nPos) {
		this.bind();

		if (nPos.length == super.length) {
			GL_W.glBufferSubData(this.bufferType.getGlId(), 0, GameEngineUtils.toFlatArray(nPos));
		} else {
			GL_W.glBufferData(this.bufferType.getGlId(),
					GameEngineUtils.toFlatArray(nPos),
					this.iStatic ? GL_W.GL_STATIC_DRAW : GL_W.GL_DYNAMIC_DRAW);
		}

		super.length = nPos.length;

		if (this.isVertexArray()) {
			GL_W.glVertexAttribPointer(this.index, this.getElementComponentCount(), GL_W.GL_FLOAT, false, this.getElementByteSize(), 0);
		}
	}

}
