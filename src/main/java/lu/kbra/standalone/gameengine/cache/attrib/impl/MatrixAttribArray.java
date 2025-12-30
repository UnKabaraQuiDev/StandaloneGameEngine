package lu.kbra.standalone.gameengine.cache.attrib.impl;

import lu.kbra.standalone.gameengine.cache.attrib.types.JavaTypeAttribArray;

public interface MatrixAttribArray extends MultiAttribArray, JavaTypeAttribArray {

	int getColumnComponentCount();

	int getLineComponentCount();

	default int getElementComponentCount() {
		return getLineComponentCount() * getColumnComponentCount();
	}
	
	default int getAttribArrayCount() {
		return getColumnComponentCount();
	}

	default int getColumnByteSize() {
		return getColumnComponentCount() * getComponentByteSize();
	}
	
}
