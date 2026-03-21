package lu.kbra.standalone.gameengine.cache.attrib.types;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;

public interface FloatJavaTypeAttribArray extends JavaTypeAttribArray {

	@Override
	default int getComponentByteSize() {
		return Float.BYTES;
	}

	@Override
	default Class<?> getType() {
		return float.class;
	}

	default float[] read(final int start, final int length) {
		if (start < 0) {
			throw new IllegalArgumentException("Start cannot be negative.");
		}
		if (start > this.getLength()) {
			throw new IllegalArgumentException("Start cannot OOB (" + this.getLength() + ").");
		}
		if (start + length > this.getLength()) {
			throw new IllegalArgumentException("End cannot be OOB (" + this.getLength() + ").");
		}

		this.bind();
		final float[] arr = new float[length * this.getElementComponentCount()];
		assert GL_W.glGetBufferParameteri(this.getBufferType().getGlId(), GL_W.GL_BUFFER_SIZE) >= arr.length * Float.BYTES
				: arr.length + " & " + arr.length * Float.BYTES + " & "
						+ GL_W.glGetBufferParameteri(this.getBufferType().getGlId(), GL_W.GL_BUFFER_SIZE);
		GL_W.glGetBufferSubData(this.getBufferType().getGlId(), start * this.getElementByteSize(), arr);
		GL_W.glFinish();
		return arr;
	}

}
