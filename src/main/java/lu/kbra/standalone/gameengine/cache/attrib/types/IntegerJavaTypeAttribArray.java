package lu.kbra.standalone.gameengine.cache.attrib.types;

public interface IntegerJavaTypeAttribArray extends JavaTypeAttribArray {

	@Override
	default int getComponentByteSize() {
		return Integer.BYTES;
	}

	@Override
	default Class<?> getType() {
		return int.class;
	}

}
