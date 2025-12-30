package lu.kbra.standalone.gameengine.cache.attrib.types;

public interface FloatJavaTypeAttribArray extends JavaTypeAttribArray {

	default int getComponentByteSize() {
		return Float.BYTES;
	}
	
	@Override
	default Class<?> getType() {
		return float.class;
	}

}
