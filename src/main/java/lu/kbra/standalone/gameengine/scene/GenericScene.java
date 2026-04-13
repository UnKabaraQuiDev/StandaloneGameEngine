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

public abstract class GenericScene<O extends SceneEntity> implements Scene<O> {

	public static final String NAME = GenericScene.class.getName();

	protected String name;
	protected Camera3D camera;

	private final Object entitiesLock = new Object();

	protected Map<String, O> entities = Collections.synchronizedMap(new LinkedHashMap<>());

	public GenericScene(final String name) {
		this.name = name;
		this.camera = Camera.perspectiveCamera3D();
	}

	@Override
	public void cleanup() {
		this.entities.values().stream().filter(v -> v instanceof final Cleanupable c).forEach(v -> ((Cleanupable) v).cleanup());
		this.entities.clear();
	}

	public Map<String, O> getEntities() {
		return this.entities;
	}

	public void setEntities(final Map<String, O> entities) {
		synchronized (this.entitiesLock) {
			this.entities = entities;
		}
	}

	@Override
	public <T extends O> T add(final T entity) {
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

	protected <T extends O> void onAdd(final T entity) {
	}

	protected <T extends O> void onRemove(final T entity) {
	}

	@Override
	public <T extends O> T getEntity(final String str) {
		synchronized (this.entitiesLock) {
			return (T) this.entities.get(str);
		}
	}

	@Override
	public <T extends O> T[] addAll(final T... entities) {
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
	public Iterator<O> iterator() {
		return this.entities.values().iterator();
	}

	@Override
	public <T extends O> Optional<T> remove(T e) {
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
	public <NEWVALUE extends O, OLDVALUE extends O> Optional<OLDVALUE> replace(final OLDVALUE old, final NEWVALUE new_) {
		synchronized (this.entitiesLock) {
			if (old == null || !this.entities.containsKey(old.getId())) {
				this.add(new_);
				return Optional.empty();
			}
			final OLDVALUE oldValue = (OLDVALUE) this.entities.remove(old.getId());
			this.onRemove(oldValue);
			if (oldValue != old) {
				throw new IllegalStateException("Found value and given old values do not match (" + PCUtils.toSimpleIdentityString(oldValue)
						+ " <> " + PCUtils.toSimpleIdentityString(old) + ").");
			}
			this.add(new_);
			return Optional.of(oldValue);
		}
	}

	@Override
	public <NEWVALUE extends O, OLDVALUE extends O> Optional<OLDVALUE> replace(final String oldId, final NEWVALUE new_) {
		synchronized (this.entitiesLock) {
			if (oldId != null && this.entities.containsKey(oldId)) {
				final OLDVALUE oldValue = (OLDVALUE) this.entities.remove(oldId);
				this.onRemove(oldValue);
				this.add(new_);
				return Optional.of(oldValue);
			}
			this.add(new_);
			return Optional.empty();
		}
	}

	@Override
	public <T extends O> boolean contains(final T e) {
		synchronized (this.entitiesLock) {
			return this.entities.containsKey(e.getId()) && this.entities.get(e.getId()) == e;
		}
	}

	@Override
	public <T extends O> boolean addAll(final Collection<? extends T> entities) {
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
	public <T extends O> boolean contains(final String e) {
		synchronized (this.entitiesLock) {
			return this.entities.containsKey(e);
		}
	}

	@Override
	public Stream<O> parallelStream() {
		return this.getROEntities().parallelStream();
	}

	@Override
	public Stream<O> stream() {
		return this.getROEntities().stream();
	}

	public Collection<O> getROEntities() {
		synchronized (this.entitiesLock) {
			return List.copyOf(this.entities.values());
		}
	}

	public void forEach(final Consumer<? super O> action) {
		this.getROEntities().forEach(action);
	}

	@Override
	public void flatForEach(final Consumer<? super O> action) {
		synchronized (this.entitiesLock) {
			this.flatStream().forEach(action);
		}
	}

	@Override
	public String getId() {
		return this.name;
	}

	@Override
	public String toString() {
		return "GenericScene@" + System.identityHashCode(this) + " [name=" + name + ", camera=" + camera + ", entitiesLock=" + entitiesLock
				+ ", entities=" + entities + "]";
	}

}
