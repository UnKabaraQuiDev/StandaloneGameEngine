package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.text.TextEmitter;

public class TextEmitterComponent extends Component implements Renderable, RenderableComponent {

	private TextEmitter textEmitter;

	public TextEmitterComponent(TextEmitter textEmitter) {
		this.textEmitter = textEmitter;
	}

	public TextEmitter getTextEmitter() {
		return textEmitter;
	}

	public void setTextEmitter(TextEmitter textEmitter) {
		this.textEmitter = textEmitter;
	}

	@Override
	public Renderable getRenderable() {
		return textEmitter;
	}

}
