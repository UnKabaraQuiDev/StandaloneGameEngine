package lu.kbra.standalone.gameengine.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lu.pcy113.pclib.PCUtils;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.objs.entity.ParentAware;
import lu.kbra.standalone.gameengine.objs.entity.components.LightComponent;
import lu.kbra.standalone.gameengine.scene.camera.Camera;
import lu.kbra.standalone.gameengine.scene.camera.Camera3D;

public class Scene3D extends Scene implements Iterable<Entity> {

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
		if (entity == null) {
			return null;
		}

		synchronized (entitiesLock) {
			this.entities.put(str, entity);
			if (entity.hasComponentMatching(LightComponent.class)) {
				this.lightEmittors.add(str);
			}
		}

		if (entity instanceof ParentAware pa) {
			pa.setParent(this);
		}

		return entity;
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

	public <T extends Entity> void addEntities(T... entities) {
		synchronized (entitiesLock) {
			for (Entity entity : entities) {
				this.addEntity(entity);
			}
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

	@Override
	public Iterator<Entity> iterator() {
		return this.entities.values().iterator();
	}

	public Optional<Entity> remove(Entity e) {
		synchronized (entitiesLock) {
			if (e != null && (e = this.entities.remove(e.getId())) != null) {
				if (e instanceof ParentAware pa) {
					pa.setParent(null);
				}
				return Optional.of(e);
			}
		}
		return Optional.empty();
	}

	public Optional<Entity> replace(Entity old, Entity new_) {
		synchronized (entitiesLock) {
			if (old != null && entities.containsKey(old.getId())) {
				final Entity aValue = entities.remove(old.getId());
				if (aValue != old) {
					throw new IllegalStateException("Found value and given old values do not match ("
							+ PCUtils.toSimpleIdentityString(aValue) + " <>" + PCUtils.toSimpleIdentityString(old) + ").");
				}
				this.addEntity(new_);
				return Optional.of(aValue);
			} else {
				addEntity(new_);
				return Optional.empty();
			}
		}
	}

}
