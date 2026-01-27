package lu.kbra.standalone.gameengine.cache.attrib.types;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;

public interface FloatJavaTypeAttribArray extends JavaTypeAttribArray {

	default int getComponentByteSize() {
		return Float.BYTES;
	}

	@Override
	default Class<?> getType() {
		return float.class;
	}

	default float[] read(int start, int length) {
		if (start < 0) {
			throw new IllegalArgumentException("Start cannot be negative.");
		}
		if (start > getLength()) {
			throw new IllegalArgumentException("Start cannot OOB (" + getLength() + ").");
		}
		if (start + length > getLength()) {
			throw new IllegalArgumentException("End cannot be OOB (" + getLength() + ").");
		}

		bind();
		final float[] arr = new float[length * getElementComponentCount()];
		assert GL_W.glGetBufferParameteri(getBufferType().getGlId(), GL_W.GL_BUFFER_SIZE) >= arr.length * Float.BYTES : arr.length + " & "
				+ (arr.length * Float.BYTES) + " & " + GL_W.glGetBufferParameteri(getBufferType().getGlId(), GL_W.GL_BUFFER_SIZE);
		GL_W.glGetBufferSubData(getBufferType().getGlId(), start, arr);
		GL_W.glFinish();
		return arr;
	}

}
