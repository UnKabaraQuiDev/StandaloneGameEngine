package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.objs.entity.Component;

public class RenderPriorityComponent extends Component {

	private float priority;

	public RenderPriorityComponent(float priority) {
		this.priority = priority;
	}

	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

}
