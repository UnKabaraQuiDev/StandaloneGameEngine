package lu.kbra.standalone.gameengine.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public interface GLObject extends Cleanupable, UniqueID {

	int getGlId();

	boolean isValid();

}
