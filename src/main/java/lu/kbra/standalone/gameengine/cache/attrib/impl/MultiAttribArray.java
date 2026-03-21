package lu.kbra.standalone.gameengine.cache.attrib.impl;

public interface MultiAttribArray extends AttribArray {

	default int getMinIndex() {
		return this.getIndex();
	}

	default int getMaxIndex() {
		return this.getIndex() + this.getAttribArrayCount();
	}

	int getAttribArrayCount();

}
