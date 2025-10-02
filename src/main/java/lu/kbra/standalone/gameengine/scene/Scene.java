package lu.kbra.standalone.gameengine.scene;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public abstract class Scene implements UniqueID, Cleanupable, Renderable {

	protected String name;
	protected Camera camera;

	public Scene(String name, Camera cam) {
		this.name = name;
		this.camera = cam;
	}

	@Override
	public void cleanup() {
		name = null;
	}

	@Override
	public String getId() {
		return name;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}
