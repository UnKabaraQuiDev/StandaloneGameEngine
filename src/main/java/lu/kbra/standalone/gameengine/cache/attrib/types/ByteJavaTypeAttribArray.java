package lu.kbra.standalone.gameengine.cache.attrib.types;

public interface ByteJavaTypeAttribArray extends JavaTypeAttribArray {

	@Override
	default int getComponentByteSize() {
		return Byte.BYTES;
	}

	@Override
	default Class<?> getType() {
		return byte.class;
	}

}
