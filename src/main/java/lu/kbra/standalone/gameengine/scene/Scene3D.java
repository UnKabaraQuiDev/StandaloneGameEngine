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

	public Scene3D(final String name) {
		this.name = name;
		this.camera = Camera.perspectiveCamera3D();
	}

	@Override
	public void cleanup() {
//		name = null;
		this.entities.values().stream().filter(v -> v instanceof final Cleanupable c).forEach(v -> ((Cleanupable) v).cleanup());
		this.entities.clear();
	}

	public Map<String, SceneEntity> getEntities() {
		return this.entities;
	}

	public void setEntities(final Map<String, SceneEntity> entities) {
		synchronized (this.entitiesLock) {
			this.entities = entities;
		}
	}

	@Override
	public <T extends SceneEntity> T add(final T entity) {
		if (entity == null) {
			return null;
		}

		synchronized (this.entitiesLock) {
			if (this.entities.containsKey(entity.getId())) {
				this.onRemove(this.entities.get(entity.getId()));
			}
			this.entities.put(entity.getId(), entity);
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
		synchronized (this.entitiesLock) {
			return (T) this.entities.get(str);
		}
	}

	@Override
	public <T extends SceneEntity> T[] addAll(final T... entities) {
		synchronized (this.entitiesLock) {
			for (final T entity : entities) {
				this.add(entity);
			}
			return entities;
		}
	}

	@Override
	public Camera3D getCamera() {
		return this.camera;
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
		return this.entitiesLock;
	}

	@Override
	public Iterator<SceneEntity> iterator() {
		return this.entities.values().iterator();
	}

	@Override
	public <T extends SceneEntity> Optional<T> remove(T e) {
		synchronized (this.entitiesLock) {
			if (e != null && (e = (T) this.entities.remove(e.getId())) != null) {
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
		synchronized (this.entitiesLock) {
			if (old != null && this.entities.containsKey(old.getId())) {
				final O oldValue = (O) this.entities.remove(old.getId());
				this.onRemove(oldValue);
				if (oldValue != old) {
					throw new IllegalStateException("Found value and given old values do not match ("
							+ PCUtils.toSimpleIdentityString(oldValue) + " <> " + PCUtils.toSimpleIdentityString(old) + ").");
				}
				this.add(new_);
				return Optional.of(oldValue);
			} else {
				this.add(new_);
				return Optional.empty();
			}
		}
	}

	@Override
	public <T extends SceneEntity> boolean contains(final T e) {
		synchronized (this.entitiesLock) {
			return this.entities.containsKey(e.getId()) && this.entities.get(e.getId()) == e;
		}
	}

	@Override
	public <T extends SceneEntity> boolean addAll(final Collection<? extends T> entities) {
		synchronized (this.entitiesLock) {
			boolean addedAny = false;
			for (final T entity : entities) {
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
		synchronized (this.entitiesLock) {
			return this.entities.size();
		}
	}

	@Override
	public <T extends SceneEntity> boolean contains(final String e) {
		synchronized (this.entitiesLock) {
			return this.entities.containsKey(e);
		}
	}

	@Override
	public Stream<SceneEntity> parallelStream() {
		synchronized (this.entitiesLock) {
			return this.entities.values().parallelStream();
		}
	}

	@Override
	public Stream<SceneEntity> stream() {
		synchronized (this.entitiesLock) {
			return this.entities.values().stream();
		}
	}

	@Override
	public void forEach(final Consumer<? super SceneEntity> action) {
		synchronized (this.entitiesLock) {
			this.entities.values().forEach(action);
		}
	}

	@Override
	public String getId() {
		return this.name;
	}

}
