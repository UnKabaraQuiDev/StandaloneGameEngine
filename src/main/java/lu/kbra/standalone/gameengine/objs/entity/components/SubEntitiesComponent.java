package lu.kbra.standalone.gameengine.objs.entity.components;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;

public class SubEntitiesComponent<T extends Entity> extends Component {

	protected Object entitiesLock = new Object();
	protected List<T> entities = new CopyOnWriteArrayList<>();

	public SubEntitiesComponent(List<T> entities) {
		this.entities = entities;
	}

	@SafeVarargs
	public SubEntitiesComponent(T... entity) {
		Arrays.stream(entity).forEach(entities::add);
	}

	public SubEntitiesComponent(T entity) {
		entities.add(entity);
	}

	public List<T> getEntities() {
		return entities;
	}

	public <B extends T> B addEntity(B entity) {
		synchronized (entitiesLock) {
			entities.add(entity);
		}
		return entity;
	}

	public SubEntitiesComponent<T> addEntities(T... entity) {
		synchronized (entitiesLock) {
			for (T e : entity) {
				this.entities.add(e);
			}
		}
		return this;
	}

	public Object getEntitiesLock() {
		return entitiesLock;
	}

	@Override
	public String toString() {
		return "SubEntitiesComponent [entities=" + entities + "]";
	}

}
