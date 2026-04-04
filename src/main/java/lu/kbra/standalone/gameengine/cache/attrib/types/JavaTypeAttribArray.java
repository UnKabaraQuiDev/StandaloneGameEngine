package lu.kbra.standalone.gameengine.cache.attrib.types;

import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;

public interface JavaTypeAttribArray extends AttribArray {

	int getTotalComponentCount();

	int getTotalByteSize();

	default int getElementByteSize() {
		return getElementComponentCount() * getComponentByteSize();
	}

	int getElementComponentCount();

	/** byte count for ONE component */
	int getComponentByteSize();

	Class<?> getType();

}
