package lu.kbra.standalone.gameengine.cache.attrib.impl;

public interface MultiAttribArray extends AttribArray {

	default int getMinIndex() {
		return getIndex();
	}

	default int getMaxIndex() {
		return getIndex() + getAttribArrayCount();
	}

	int getAttribArrayCount();

}
