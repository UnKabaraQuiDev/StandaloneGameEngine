package lu.kbra.standalone.gameengine.scene;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.IdOwner;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.objs.entity.ParentAwareRoot;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public interface Scene<T extends SceneEntity> extends IdOwner, Cleanupable, Renderable, ParentAwareRoot, EntityContainer<T> {

	Camera getCamera();

	void setCamera(Camera camera);

}
