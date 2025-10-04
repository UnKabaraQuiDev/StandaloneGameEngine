package lu.kbra.standalone.gameengine.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.objs.entity.components.LightComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.PointLightComponent;
import lu.kbra.standalone.gameengine.scene.camera.Camera;
import lu.kbra.standalone.gameengine.scene.camera.Camera3D;

public class Scene3D extends Scene {

	public static final String NAME = Scene3D.class.getName();

	private final Object entitiesLock = new Object();

	protected Map<String, Entity> entities = Collections.synchronizedMap(new LinkedHashMap<>());
	protected List<String> lightEmittors = new ArrayList<>();

	public Scene3D(String name) {
		super(name, Camera.perspectiveCamera3D());
	}

	@Override
	public void cleanup() {
		super.cleanup();
	}

	public Map<String, Entity> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, Entity> entities) {
		synchronized (entitiesLock) {
			this.entities = entities;
		}
	}

	public Entity addEntity(String str, Entity entity) {
		if (entity == null)
			return null;

		synchronized (entitiesLock) {
			this.entities.put(str, entity);
		}
		if (entity.hasComponentMatching(LightComponent.class)) {
			this.lightEmittors.add(str);
		}
		return entity;
	}

	public Entity addEntity(Entity e) {
		synchronized (entitiesLock) {
			return addEntity(e.getId(), e);
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

	public List<String> getLightEmittors() {
		return lightEmittors;
	}

	public void setLightEmittors(List<String> lightEmittors) {
		this.lightEmittors = lightEmittors;
	}

	public List<LightComponent> getLights() {
		return getLightEmittors()
				.stream()
				.map((String e) -> (PointLightComponent) entities.get(e).getComponent(PointLightComponent.class))
				.collect(Collectors.toList());
	}

	@Override
	public Camera3D getCamera() {
		return (Camera3D) super.getCamera();
	}

	public void setCamera(Camera3D camera) {
		super.setCamera(camera);
	}

	public Object getEntitiesLock() {
		return entitiesLock;
	}

}
