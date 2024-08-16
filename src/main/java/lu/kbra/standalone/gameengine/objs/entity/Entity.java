package lu.kbra.standalone.gameengine.objs.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lu.kbra.standalone.gameengine.impl.UniqueID;

public class Entity implements UniqueID {

	private boolean active = true;

	private String name = "undefined";
	private Map<Class<? extends Component>, Component> components = new HashMap<>();

	/*public Entity(Component... cs) {
		for (Component c : cs) {
			addComponent(c);
		}
	}*/

	public Entity(String str, Component... cs) {
		this.name = str;
		
		for (Component c : cs) {
			addComponent(c);
		}
	}

	public Entity addComponent(Component component) {
		if(component == null)
			throw new NullPointerException("Component == null.");
		if (component.attach(this))
			components.put(component.getClass(), component);
		return this;
	}

	public <T extends Component> T getComponent(Class<T> componentClass) {
		return (T) components.get(componentClass);
	}

	public boolean hasComponent(Class<? extends Component> clazz) {
		return components.keySet().stream().map(t -> clazz.isAssignableFrom(t)).collect(Collectors.reducing((a, b) -> a || b)).get();
	}

	public List<Class<? extends Component>> getComponents(Class<? extends Component> clazz) {
		return components.keySet().stream().filter(t -> clazz.isAssignableFrom(t)).collect(Collectors.toList());
	}

	public Map<Class<? extends Component>, Component> getComponents() {
		return components;
	}

	public void setComponents(Map<Class<? extends Component>, Component> components) {
		this.components = components;
	}

	public boolean isActive() {
		return active;
	}

	public Entity setActive(boolean a) {
		this.active = a;
		return this;
	}

	@Override
	public String toString() {
		return "Entity@" + getClass().getSimpleName() + "#" + name + "[active=" + active + ", componentCount=" + components.size() + "]";
	}

	@Override
	public String getId() {
		return name;
	}

}
