package lu.kbra.standalone.gameengine.cache.attrib.impl;

import lu.kbra.standalone.gameengine.cache.attrib.types.JavaTypeAttribArray;

public interface PaddedAttribArray extends JavaTypeAttribArray {

	/**
	 * difference between the set element count and the original element count
	 */
	int getElementPadding();

	/**
	 * the set element count
	 */
	int getElementPadLength();

	default int getElementPaddingBytes() {
		return this.getElementPadding() * this.getElementByteSize();
	}

	default int getElementPadBytes() {
		return this.getElementPadLength() * this.getElementByteSize();
	}

}
