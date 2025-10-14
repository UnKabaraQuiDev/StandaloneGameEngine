package lu.kbra.standalone.gameengine.objs.entity;

import java.util.List;
import java.util.Map;

import lu.kbra.standalone.gameengine.impl.UniqueID;

public interface SceneEntity extends UniqueID {

	SceneEntity addComponent(Component component);

	<T extends Component> T getComponent(Class<T> componentClass);

	<T extends Component> T getComponentMatching(Class<T> clazz);

	<T extends Component> List<T> getComponentsMatching(Class<T> clazz);

	boolean hasComponentMatching(Class<? extends Component> clazz);

	List<Class<? extends Component>> getComponentTypesMatching(Class<? extends Component> clazz);

	Map<Class<? extends Component>, Component> getComponents();

	void setComponents(Map<Class<? extends Component>, Component> components);

	boolean isActive();

	SceneEntity setActive(boolean a);

}
