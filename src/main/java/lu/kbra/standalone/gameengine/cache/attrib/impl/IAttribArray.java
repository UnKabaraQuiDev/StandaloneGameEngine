package lu.kbra.standalone.gameengine.cache.attrib.impl;

import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public interface IAttribArray extends GLObject {

	int getIndex();

	int getDivisor();

	BufferType getBufferType();

	boolean isStatic();

	void bind();

	void unbind();

//	void enable();
//
//	void disable();

}
