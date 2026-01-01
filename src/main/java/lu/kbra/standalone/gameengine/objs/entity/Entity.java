package lu.kbra.standalone.gameengine.objs.entity;

public class Entity implements SceneEntity {

	protected boolean active = true;

	protected String name = "undefined";

	public Entity(String str) {
		this.name = str;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public SceneEntity setActive(boolean a) {
		this.active = a;
		return this;
	}

	@Override
	public String getId() {
		return name;
	}

	@Override
	public String toString() {
		return "Entity [active=" + active + ", name=" + name + "]";
	}

}
