package lu.kbra.standalone.gameengine.scene;

import java.util.LinkedHashMap;
import java.util.Map;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public class Scene2D extends Scene {

	public static final String NAME = Scene2D.class.getName();

	protected Map<String, Entity> entities = new LinkedHashMap<>();

	public Scene2D(String name) {
		super(name, Camera.orthographicCamera2D());
	}

	public Scene2D(String name, Camera cam) {
		super(name, cam);
	}

	@Override
	public void cleanup() {
		super.cleanup();
	}

	public Map<String, Entity> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, Entity> entities) {
		this.entities = entities;
	}

	public Entity addEntity(String str, Entity entity) {
		this.entities.put(str, entity);
		return entity;
	}

	public Entity addEntity(String str, Component... components) {
		return addEntity(str, new Entity(str, components));
	}

	public Entity getEntity(String str) {
		return this.entities.get(str);
	}

}
