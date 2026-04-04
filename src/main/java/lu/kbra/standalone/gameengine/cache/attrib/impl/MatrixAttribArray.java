package lu.kbra.standalone.gameengine.cache.attrib.impl;

import lu.kbra.standalone.gameengine.cache.attrib.types.JavaTypeAttribArray;

public interface MatrixAttribArray extends MultiAttribArray, JavaTypeAttribArray {

	int getColumnComponentCount();

	int getLineComponentCount();

	@Override
	default int getElementComponentCount() {
		return getLineComponentCount() * getColumnComponentCount();
	}

	@Override
	default int getAttribArrayCount() {
		return getColumnComponentCount();
	}

	default int getColumnByteSize() {
		return getColumnComponentCount() * getComponentByteSize();
	}

}
