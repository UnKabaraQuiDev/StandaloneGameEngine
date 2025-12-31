package lu.kbra.standalone.gameengine.objs.entity.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lu.pcy113.pclib.PCUtils;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.ParentAware;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;
import lu.kbra.standalone.gameengine.scene.EntityContainer;

public class SubEntitiesComponent<B extends SceneEntity> extends Component implements EntityContainer<B> {

	protected Object entitiesLock = new Object();
	protected List<B> entities = Collections.synchronizedList(new ArrayList<>());

	public SubEntitiesComponent(List<B> entities) {
		this.entities = entities;
	}

	@SafeVarargs
	public SubEntitiesComponent(B... entity) {
		addAll(entity);
	}

	public SubEntitiesComponent(B entity) {
		add(entity);
	}

	public void sort(Comparator<B> comp) {
		synchronized (entitiesLock) {
			entities.sort(comp);
		}
	}

	public List<B> getEntities() {
		return entities;
	}

	public <T extends B> T add(T entity) {
		assert entity != parent;
		if (entity == null) {
			return null;
		}
		synchronized (entitiesLock) {
			entities.add(entity);
		}
		if (entity instanceof ParentAware pa) {
			pa.setParent(this);
		}
		return entity;
	}

	public <T extends B> T[] addAll(T... entity) {
		synchronized (entitiesLock) {
			for (T e : entity) {
				add(e);
			}
		}
		return entity;
	}

	public Object getEntitiesLock() {
		return entitiesLock;
	}

//	public <S extends B> Optional<S> remove(S e) {
//		synchronized (entitiesLock) {
//			if (e != null && this.entities.remove(e)) {
//				if (e instanceof ParentAware pa) {
//					pa.setParent(null);
//				}
//				return Optional.of(e);
//			}
//		}
//		return Optional.empty();
//	}
//
//	public <S extends B> Optional<S> replace(S old, S new_) {
//		if (new_ instanceof ParentAware pa) {
//			pa.setParent(this);
//		}
//		synchronized (entitiesLock) {
//			if (old != null && this.entities.remove(old)) {
//				if (old instanceof ParentAware pa) {
//					pa.setParent(null);
//				}
//				this.entities.add(new_);
//				return Optional.of(old);
//			} else {
//				this.entities.add(new_);
//				return Optional.empty();
//			}
//		}
//	}

	@Override
	public String toString() {
		return "SubEntitiesComponent [entities=" + entities + "]";
	}

	@Override
	public Iterator<B> iterator() {
		return entities.iterator();
	}

	@Override
	public <T extends B> boolean contains(T e) {
		return entities.stream().anyMatch(f -> f == e && f.getId().equals(e.getId()));
	}

	@Override
	public <T extends B> boolean contains(String e) {
		return entities.stream().anyMatch(f -> f.getId().equals(e));
	}

	@Override
	public <T extends B> boolean addAll(Collection<? extends T> entities) {
		final HashSet<String> strs = entities.parallelStream().map(T::getId).collect(Collectors.toCollection(HashSet::new));
		synchronized (entitiesLock) {
			final boolean addedAny = entities.parallelStream().anyMatch(c -> strs.contains(c.getId()));
			for (T entity : entities) {
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
	public <T extends SceneEntity> T getEntity(String str) {
		return (T) entities.parallelStream().filter(c -> c.getId().equals(str)).findFirst().orElse(null);
	}

	@Override
	public <T extends B> Optional<T> remove(T e) {
		synchronized (entitiesLock) {
			if (e == null) {
				return Optional.empty();
			}
			final T old = (T) this.entities.parallelStream().filter(c -> c.getId().equals(e.getId())).findFirst().orElse(null);
			if (old != null) {
				if (old instanceof ParentAware pa) {
					pa.setParent(null);
				}
				return Optional.of(old);
			}
		}
		return Optional.empty();
	}

	@Override
	public <T extends B, O extends B> Optional<O> replace(O old, T new_) {
		synchronized (entitiesLock) {
			if (old == null) {
				add(new_);
				return Optional.empty();
			}
			final O found = (O) this.entities.parallelStream().filter(c -> c.getId().equals(old.getId())).findFirst().orElse(null);
			if (found != null) {
				if (found != old) {
					throw new IllegalStateException("Found value and given old values do not match ("
							+ PCUtils.toSimpleIdentityString(found) + " <> " + PCUtils.toSimpleIdentityString(old) + ").");
				}
				this.add(new_);
				return Optional.of(found);
			} else {
				add(new_);
				return Optional.empty();
			}
		}
	}

}
