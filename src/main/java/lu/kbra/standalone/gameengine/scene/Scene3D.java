package lu.kbra.standalone.gameengine.scene;

import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public class Scene3D extends GenericScene<SceneEntity> {

	public Scene3D(final String name) {
		super(name);
		camera = Camera.perspectiveCamera3D();
	}

	@Override
	public String toString() {
		return "Scene3D@" + System.identityHashCode(this) + " [name=" + name + ", camera=" + camera + ", entities=" + entities + "]";
	}

}
