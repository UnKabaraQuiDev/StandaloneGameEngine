package lu.kbra.standalone.gameengine.scene;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

	public Scene3D(final String name) {
		this.name = name;
		camera = Camera.perspectiveCamera3D();
	}

	@Override
	public void cleanup() {
		entities.values().stream().filter(v -> v instanceof final Cleanupable c).forEach(v -> ((Cleanupable) v).cleanup());
		entities.clear();
	}

	public Map<String, SceneEntity> getEntities() {
		return entities;
	}

	public void setEntities(final Map<String, SceneEntity> entities) {
		synchronized (entitiesLock) {
			this.entities = entities;
		}
	}

	@Override
	public <T extends SceneEntity> T add(final T entity) {
		if (entity == null)
			return null;

		synchronized (entitiesLock) {
			if (entities.containsKey(entity.getId()))
				this.onRemove(entities.get(entity.getId()));
			entities.put(entity.getId(), entity);
			this.onAdd(entity);
		}

		if (entity instanceof final ParentAwareNode pa) {
			ParentAwareComponent.checkHierarchy(this, pa);
			pa.setParent(this);
		}

		return entity;
	}

	protected <T extends SceneEntity> void onAdd(final T entity) {
	}

	protected <T extends SceneEntity> void onRemove(final T entity) {
	}

	@Override
	public <T extends SceneEntity> T getEntity(final String str) {
		synchronized (entitiesLock) {
			return (T) entities.get(str);
		}
	}

	@Override
	public <T extends SceneEntity> T[] addAll(final T... entities) {
		synchronized (entitiesLock) {
			for (final T entity : entities)
				this.add(entity);
			return entities;
		}
	}

	@Override
	public Camera3D getCamera() {
		return camera;
	}

	@Deprecated
	@Override
	public void setCamera(final Camera camera) {
		this.camera = (Camera3D) camera;
	}

	public void setCamera(final Camera3D camera) {
		this.camera = camera;
	}

	public Object getEntitiesLock() {
		return entitiesLock;
	}

	@Override
	public Iterator<SceneEntity> iterator() {
		return entities.values().iterator();
	}

	@Override
	public <T extends SceneEntity> Optional<T> remove(T e) {
		synchronized (entitiesLock) {
			if (e != null && (e = (T) entities.remove(e.getId())) != null) {
				if (e instanceof final ParentAwareNode pa) {
					ParentAwareComponent.checkHierarchy(this, pa);
					pa.setParent(null);
				}
				this.onRemove(e);
				return Optional.of(e);
			}
		}
		return Optional.empty();
	}

	@Override
	public <T extends SceneEntity, O extends SceneEntity> Optional<O> replace(final O old, final T new_) {
		synchronized (entitiesLock) {
			if ((old == null) || !entities.containsKey(old.getId())) {
				this.add(new_);
				return Optional.empty();
			}
			final O oldValue = (O) entities.remove(old.getId());
			this.onRemove(oldValue);
			if (oldValue != old)
				throw new IllegalStateException("Found value and given old values do not match (" + PCUtils.toSimpleIdentityString(oldValue)
						+ " <> " + PCUtils.toSimpleIdentityString(old) + ").");
			this.add(new_);
			return Optional.of(oldValue);
		}
	}

	@Override
	public <T extends SceneEntity, O extends SceneEntity> Optional<O> replace(final String oldId, final T new_) {
		synchronized (entitiesLock) {
			if (oldId != null && entities.containsKey(oldId)) {
				final O oldValue = (O) entities.remove(oldId);
				this.onRemove(oldValue);
				this.add(new_);
				return Optional.of(oldValue);
			}
			this.add(new_);
			return Optional.empty();
		}
	}

	@Override
	public <T extends SceneEntity> boolean contains(final T e) {
		synchronized (entitiesLock) {
			return entities.containsKey(e.getId()) && entities.get(e.getId()) == e;
		}
	}

	@Override
	public <T extends SceneEntity> boolean addAll(final Collection<? extends T> entities) {
		synchronized (entitiesLock) {
			boolean addedAny = false;
			for (final T entity : entities) {
				if (!this.entities.containsKey(entity.getId()))
					addedAny |= true;
				this.add(entity);
			}
			return addedAny;
		}
	}

	@Override
	public int size() {
		synchronized (entitiesLock) {
			return entities.size();
		}
	}

	@Override
	public <T extends SceneEntity> boolean contains(final String e) {
		synchronized (entitiesLock) {
			return entities.containsKey(e);
		}
	}

	@Override
	public Stream<SceneEntity> parallelStream() {
		return getROEntities().parallelStream();
	}

	@Override
	public Stream<SceneEntity> stream() {
		return getROEntities().stream();
	}

	public Collection<SceneEntity> getROEntities() {
		synchronized (entitiesLock) {
			return List.copyOf(entities.values());
		}
	}

	@Override
	public void forEach(final Consumer<? super SceneEntity> action) {
		getROEntities().forEach(action);
	}

	@Override
	public void flatForEach(Consumer<? super SceneEntity> action) {
		synchronized (entitiesLock) {
			flatStream().forEach(action);
		}
	}

	@Override
	public String getId() {
		return name;
	}

	@Override
	public String toString() {
		return "Scene3D@" + System.identityHashCode(this) + " [name=" + name + ", camera=" + camera + ", entitiesLock=" + entitiesLock
				+ ", entities=" + entities + "]";
	}

}
