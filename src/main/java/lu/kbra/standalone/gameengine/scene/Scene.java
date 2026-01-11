package lu.kbra.standalone.gameengine.scene;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.objs.entity.ParentAwareRoot;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public interface Scene extends UniqueID, Cleanupable, Renderable, EntityContainer<SceneEntity>, ParentAwareRoot {

//	protected String name;
//	protected Camera camera;
//
//	public Scene(String name, Camera cam) {
//		this.name = name;
//		this.camera = cam;
//	}
//
//	@Override
//	public void cleanup() {
//		name = null;
//	}
//
//	@Override
//	public String getId() {
//		return name;
//	}

	Camera getCamera();

	void setCamera(Camera camera);

}
