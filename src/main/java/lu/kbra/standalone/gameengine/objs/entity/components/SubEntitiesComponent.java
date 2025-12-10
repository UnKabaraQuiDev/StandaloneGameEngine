package lu.kbra.standalone.gameengine.objs.entity.components;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.objs.entity.ParentAware;

public class SubEntitiesComponent<T extends Entity> extends Component {

	protected Object entitiesLock = new Object();
	protected List<T> entities = new CopyOnWriteArrayList<>();

	public SubEntitiesComponent(List<T> entities) {
		this.entities = entities;
	}

	@SafeVarargs
	public SubEntitiesComponent(T... entity) {
		Arrays.stream(entity).forEach(this::addEntity);
	}

	public SubEntitiesComponent(T entity) {
		addEntity(entity);
	}

	public List<T> getEntities() {
		return entities;
	}

	public <B extends T> B addEntity(B entity) {
		assert entity != parent;
		synchronized (entitiesLock) {
			entities.add(entity);
		}
		if (entity instanceof ParentAware pa) {
			pa.setParent(this);
		}
		return entity;
	}

	public SubEntitiesComponent<T> addEntities(T... entity) {
		synchronized (entitiesLock) {
			for (T e : entity) {
				this.entities.add(e);

				if (e instanceof ParentAware pa) {
					pa.setParent(this);
				}
			}
		}
		return this;
	}

	public Object getEntitiesLock() {
		return entitiesLock;
	}

	public <S extends T> Optional<S> remove(S e) {
		synchronized (entitiesLock) {
			if (e != null && this.entities.remove(e)) {
				if (e instanceof ParentAware pa) {
					pa.setParent(null);
				}
				return Optional.of(e);
			}
		}
		return Optional.empty();
	}

	public <S extends T> Optional<S> replace(S old, S new_) {
		if (new_ instanceof ParentAware pa) {
			pa.setParent(this);
		}
		synchronized (entitiesLock) {
			if (old != null && this.entities.remove(old)) {
				if (old instanceof ParentAware pa) {
					pa.setParent(null);
				}
				this.entities.add(new_);
				return Optional.of(old);
			} else {
				this.entities.add(new_);
				return Optional.empty();
			}
		}
	}

	@Override
	public String toString() {
		return "SubEntitiesComponent [entities=" + entities + "]";
	}

}
