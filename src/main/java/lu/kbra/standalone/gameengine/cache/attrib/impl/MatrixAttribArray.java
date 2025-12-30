package lu.kbra.standalone.gameengine.cache.attrib.impl;

public interface MatrixAttribArray extends MultiAttribArray {

	int getColumnComponentCount();

	int getLineComponentCount();

	default int getElementComponentCount() {
		return getLineComponentCount() * getColumnComponentCount();
	}
	
	default int getAttribArrayCount() {
		return getColumnComponentCount();
	}

}
