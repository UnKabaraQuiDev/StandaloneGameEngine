package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.objs.entity.Component;

public class InstanceEmitterComponent extends Component implements Renderable, RenderableComponent {

	private InstanceEmitter instanceEmitter;

	public InstanceEmitterComponent(InstanceEmitter instanceEmitter) {
		this.instanceEmitter = instanceEmitter;
	}

	public InstanceEmitter getInstanceEmitter() {
		return instanceEmitter;
	}

	public void setInstanceEmitter(InstanceEmitter instanceEmitter) {
		this.instanceEmitter = instanceEmitter;
	}

	@Override
	public Renderable getRenderable() {
		return instanceEmitter;
	}

}
