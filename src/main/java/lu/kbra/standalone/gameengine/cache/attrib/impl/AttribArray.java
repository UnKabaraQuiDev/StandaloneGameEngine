package lu.kbra.standalone.gameengine.cache.attrib.impl;

import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public interface AttribArray extends GLObject {

	int getIndex();

	int getDivisor();

	BufferType getBufferType();

	boolean isStatic();

	void bind();

	void unbind();

	int getLength();

	void init();

	Object get(int i);

	boolean isLoaded();

	Object getData();

	Object toFlatArray();

	void update();

}
