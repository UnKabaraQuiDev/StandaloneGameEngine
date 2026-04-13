package lu.kbra.standalone.gameengine.objs.entity;

import lu.kbra.standalone.gameengine.impl.IdOwner;

public interface SceneEntity extends IdOwner {

	boolean isActive();

	SceneEntity setActive(boolean a);

}
