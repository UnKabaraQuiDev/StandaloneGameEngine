package lu.kbra.standalone.gameengine.objs.entity;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.datastructure.DeepCloneable;

public class Entity implements SceneEntity, Cloneable {

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

	@Override
	public Entity clone() {
		try {
			final Entity e = (Entity) super.clone();
			e.name = Long.toString(System.nanoTime() + PCUtils.randomIntRange(0, 10000));
			return e;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}
