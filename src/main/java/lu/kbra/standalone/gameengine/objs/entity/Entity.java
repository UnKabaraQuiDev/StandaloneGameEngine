package lu.kbra.standalone.gameengine.objs.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lu.pcy113.pclib.PCUtils;

public class Entity implements SceneEntity {

	protected boolean active = true;

	protected String name = "undefined";
	protected Map<Class<? extends Component>, Component> components = new HashMap<>();

	public Entity(String str, Component... cs) {
		this.name = str;

		for (Component c : cs) {
			addComponent(c);
		}
	}

	@Override
	public Entity addComponent(Component component) {
		if (component == null)
			return this;
		if (component.attach(this))
			components.put(component.getClass(), component);
		return this;
	}

	@Override
	public <T extends Component> T getComponent(Class<T> componentClass) {
		return (T) components.get(componentClass);
	}

	@Override
	public <T extends Component> T getComponentMatching(Class<T> clazz) {
		return (T) components.get(
				components.keySet().parallelStream().filter(t -> clazz.isAssignableFrom(t)).findFirst().orElse(null));
	}

	@Override
	public <T extends Component> List<T> getComponentsMatching(Class<T> clazz) {
		return components.keySet().stream().filter(t -> clazz.isAssignableFrom(t)).map(t -> (T) components.get(t))
				.collect(Collectors.toList());
	}

	@Override
	public boolean hasComponentMatching(Class<? extends Component> clazz) {
		return components.keySet().stream().map(t -> clazz.isAssignableFrom(t)).anyMatch(b -> b);
	}

	@Override
	public List<Class<? extends Component>> getComponentTypesMatching(Class<? extends Component> clazz) {
		return components.keySet().stream().filter(t -> clazz.isAssignableFrom(t)).collect(Collectors.toList());
	}

	@Override
	public Map<Class<? extends Component>, Component> getComponents() {
		return components;
	}

	@Override
	public void setComponents(Map<Class<? extends Component>, Component> components) {
		this.components = components;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public Entity setActive(boolean a) {
		this.active = a;
		return this;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [active=" + active + ", name=" + name + ", components="
				+ components.values().parallelStream().map(c -> PCUtils.toSimpleIdentityString(c))
						.collect(Collectors.joining(", ", "[", "]"))
				+ "]";
	}

	@Override
	public String getId() {
		return name;
	}

}
