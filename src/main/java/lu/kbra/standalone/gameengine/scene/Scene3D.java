package lu.kbra.standalone.gameengine.scene;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.objs.entity.ParentAwareComponent;
import lu.kbra.standalone.gameengine.objs.entity.ParentAwareNode;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;
import lu.kbra.standalone.gameengine.scene.camera.Camera3D;

public class Scene3D implements Scene {

	public static final String NAME = Scene3D.class.getName();

	protected String name;
	protected Camera3D camera;

	private final Object entitiesLock = new Object();

	protected Map<String, SceneEntity> entities = Collections.synchronizedMap(new LinkedHashMap<>());

	public Scene3D(String name) {
		this.name = name;
		this.camera = Camera.perspectiveCamera3D();
	}

	@Override
	public void cleanup() {
//		name = null;
		entities.values().stream().filter(v -> v instanceof Cleanupable c).forEach(v -> ((Cleanupable) v).cleanup());
		entities.clear();
	}

	public Map<String, SceneEntity> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, SceneEntity> entities) {
		synchronized (entitiesLock) {
			this.entities = entities;
		}
	}

	@Override
	public <T extends SceneEntity> T add(T entity) {
		if (entity == null) {
			return null;
		}

		synchronized (entitiesLock) {
			this.entities.put(entity.getId(), entity);
		}

		if (entity instanceof ParentAwareNode pa) {
			ParentAwareComponent.checkHierarchy(this, pa);
			pa.setParent(this);
		}

		return entity;
	}

	@Override
	public <T extends SceneEntity> T getEntity(String str) {
		synchronized (entitiesLock) {
			return (T) this.entities.get(str);
		}
	}

	@Override
	public <T extends SceneEntity> T[] addAll(T... entities) {
		synchronized (entitiesLock) {
			for (T entity : entities) {
				this.add(entity);
			}
			return entities;
		}
	}

	@Override
	public Camera3D getCamera() {
		return camera;
	}

	@Deprecated
	@Override
	public void setCamera(Camera camera) {
		this.camera = (Camera3D) camera;
	}

	public void setCamera(Camera3D camera) {
		this.camera = camera;
	}

	public Object getEntitiesLock() {
		return entitiesLock;
	}

	@Override
	public Iterator<SceneEntity> iterator() {
		return this.entities.values().iterator();
	}

	@Override
	public <T extends SceneEntity> Optional<T> remove(T e) {
		synchronized (entitiesLock) {
			if (e != null && (e = (T) this.entities.remove(e.getId())) != null) {
				if (e instanceof ParentAwareNode pa) {
					ParentAwareComponent.checkHierarchy(this, pa);
					pa.setParent(null);
				}
				return Optional.of(e);
			}
		}
		return Optional.empty();
	}

	@Override
	public <T extends SceneEntity, O extends SceneEntity> Optional<O> replace(O old, T new_) {
		synchronized (entitiesLock) {
			if (old != null && entities.containsKey(old.getId())) {
				final O oldValue = (O) entities.remove(old.getId());
				if (oldValue != old) {
					throw new IllegalStateException("Found value and given old values do not match ("
							+ PCUtils.toSimpleIdentityString(oldValue) + " <> " + PCUtils.toSimpleIdentityString(old) + ").");
				}
				this.add(new_);
				return Optional.of(oldValue);
			} else {
				add(new_);
				return Optional.empty();
			}
		}
	}

	@Override
	public <T extends SceneEntity> boolean contains(T e) {
		return entities.containsKey(e.getId()) && entities.get(e.getId()) == e;
	}

	@Override
	public <T extends SceneEntity> boolean addAll(Collection<? extends T> entities) {
		synchronized (entitiesLock) {
			boolean addedAny = false;
			for (T entity : entities) {
				if (!this.entities.containsKey(entity.getId())) {
					addedAny |= true;
				}
				this.add(entity);
			}
			return addedAny;
		}
	}

	@Override
	public int size() {
		return this.entities.size();
	}

	@Override
	public <T extends SceneEntity> boolean contains(String e) {
		return entities.containsKey(e);
	}

	@Override
	public Stream<SceneEntity> parallelStream() {
		return entities.values().parallelStream();
	}

	@Override
	public Stream<SceneEntity> stream() {
		return entities.values().stream();
	}

	@Override
	public void forEach(Consumer<? super SceneEntity> action) {
		synchronized (entitiesLock) {
			entities.values().forEach(action);
		}
	}

	@Override
	public String getId() {
		return name;
	}

}
