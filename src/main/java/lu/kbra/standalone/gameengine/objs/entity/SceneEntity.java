package lu.kbra.standalone.gameengine.objs.entity;

import lu.kbra.standalone.gameengine.impl.UniqueID;

public interface SceneEntity extends UniqueID {

	boolean isActive();

	SceneEntity setActive(boolean a);

}
