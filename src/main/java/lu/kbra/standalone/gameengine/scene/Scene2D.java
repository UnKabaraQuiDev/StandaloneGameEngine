package lu.kbra.standalone.gameengine.scene;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import lu.pcy113.pclib.PCUtils;

import lu.kbra.standalone.gameengine.objs.entity.ParentAware;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;
import lu.kbra.standalone.gameengine.scene.camera.Camera;

public class Scene2D extends Scene {

	public static final String NAME = Scene2D.class.getName();

	private final Object entitiesLock = new Object();

	protected Map<String, SceneEntity> entities = new LinkedHashMap<>();

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

	public Map<String, SceneEntity> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, SceneEntity> entities) {
		this.entities = entities;
	}

	public <T extends SceneEntity> T add(T entity) {
		if (entity == null) {
			return null;
		}

		synchronized (entitiesLock) {
			if (entities.containsKey(entity.getId())) {
				throw new IllegalArgumentException("Entity with id: " + entity.getId() + " already present !");
			}
			this.entities.put(entity.getId(), entity);
//			if (old != null && old instanceof ParentAware pa) {
//				pa.setParent(null);
//			}
		}

		if (entity instanceof ParentAware pa) {
			pa.setParent(this);
		}

		return entity;
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
	public <T extends SceneEntity> T getEntity(String str) {
		synchronized (entitiesLock) {
			return (T) this.entities.get(str);
		}
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
				if (e instanceof ParentAware pa) {
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
	public <T extends SceneEntity> boolean contains(String e) {
		return entities.containsKey(e);
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
			super.forEach(action);
		}
	}

}
