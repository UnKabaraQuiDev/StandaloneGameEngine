package lu.kbra.standalone.gameengine.objs.entity.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.ParentAware;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;

public class SubEntitiesComponent<T extends SceneEntity> extends Component {

	protected Object entitiesLock = new Object();
	protected List<T> entities = Collections.synchronizedList(new ArrayList<>());

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

	public void sort(Comparator<T> comp) {
		synchronized (entitiesLock) {
			entities.sort(comp);
		}
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
