package lu.kbra.standalone.gameengine.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public interface GLObject extends Cleanupable, IdOwner {

	int getGlId();

	boolean isValid();

}
