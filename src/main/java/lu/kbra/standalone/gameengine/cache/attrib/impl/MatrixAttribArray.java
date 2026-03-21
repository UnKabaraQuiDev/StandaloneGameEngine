package lu.kbra.standalone.gameengine.cache.attrib.impl;

import lu.kbra.standalone.gameengine.cache.attrib.types.JavaTypeAttribArray;

public interface MatrixAttribArray extends MultiAttribArray, JavaTypeAttribArray {

	int getColumnComponentCount();

	int getLineComponentCount();

	@Override
	default int getElementComponentCount() {
		return this.getLineComponentCount() * this.getColumnComponentCount();
	}

	@Override
	default int getAttribArrayCount() {
		return this.getColumnComponentCount();
	}

	default int getColumnByteSize() {
		return this.getColumnComponentCount() * this.getComponentByteSize();
	}

}
