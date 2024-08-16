package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.objs.entity.Component;

public class RenderComponent extends Component {

	private float priority;

	public RenderComponent(float priority) {
		this.priority = priority;
	}

	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

}
