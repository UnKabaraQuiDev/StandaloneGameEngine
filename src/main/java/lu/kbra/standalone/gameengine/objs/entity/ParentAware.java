package lu.kbra.standalone.gameengine.objs.entity;

public interface ParentAware {

	void setParent(Object e);

	Object getParent();

	default boolean hasParent() {
		return this.getParent() != null;
	}

}
