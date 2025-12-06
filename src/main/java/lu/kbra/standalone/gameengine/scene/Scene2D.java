package lu.kbra.standalone.gameengine.scene;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public class Scene2D extends Scene implements Iterable<Entity> {

	public static final String NAME = Scene2D.class.getName();

	private final Object entitiesLock = new Object();

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

	public <T extends Entity> T addEntity(T e) {
		synchronized (entitiesLock) {
			return (T) addEntity(e.getId(), e);
		}
	}

	public Entity addEntity(String str, Component... components) {
		synchronized (entitiesLock) {
			return addEntity(str, new Entity(str, components));
		}
	}

	public Entity getEntity(String str) {
		synchronized (entitiesLock) {
			return this.entities.get(str);
		}
	}

	public void addEntities(String[] names, Entity[] entities) {
		synchronized (entitiesLock) {
			for (int i = 0; i < Math.min(names.length, entities.length); i++) {
				this.addEntity(names[i], entities[i]);
			}
		}
	}

	public <T extends Entity> T addEntity(String str, T entity) {
		if (entity == null)
			return null;

		synchronized (entitiesLock) {
			this.entities.put(str, entity);
		}
		return entity;
	}

	public Object getEntitiesLock() {
		return entitiesLock;
	}

	@Override
	public Iterator<Entity> iterator() {
		return this.entities.values().iterator();
	}

}
