package lu.kbra.standalone.gameengine.objs.entity.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;

public class SubEntitiesComponent<T extends Entity> extends Component {

	private List<T> entities = new ArrayList<>();

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

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "SubEntitiesComponent [entities=" + entities + "]";
	}

}
