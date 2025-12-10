package lu.kbra.standalone.gameengine.objs.entity;

public abstract class Component implements ParentAware {

	protected Entity parent;

	public boolean attach(Entity parent) {
		if (this.parent != null) {
			return false;
		}
		setParent(parent);
		return true;
	}

	@Override
	public void setParent(Object e) {
		if (!(e instanceof Entity)) {
			throw new IllegalArgumentException("Parent should be of type Entity.");
		}
		this.parent = (Entity) e;
	}

	@Override
	public Entity getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return "Component@" + getClass().getSimpleName() + "[parent=" + parent + "]";
	}

}
