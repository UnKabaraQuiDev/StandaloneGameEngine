package lu.kbra.standalone.gameengine.impl;

public interface GLObject extends Cleanupable, UniqueID {

	int getGlId();

	boolean isValid();

}
