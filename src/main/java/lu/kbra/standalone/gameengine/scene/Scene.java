package lu.kbra.standalone.gameengine.scene;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.objs.entity.ParentAwareRoot;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public interface Scene extends UniqueID, Cleanupable, Renderable, EntityContainer<SceneEntity>, ParentAwareRoot {

	Camera getCamera();

	void setCamera(Camera camera);

}
