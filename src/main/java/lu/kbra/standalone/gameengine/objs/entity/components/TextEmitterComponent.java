package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.text.TextEmitter;

public class TextEmitterComponent extends Component implements Renderable {

	private String textEmitterId;

	public TextEmitterComponent(TextEmitter textEmitter) {
		this.textEmitterId = textEmitter.getId();
	}

	public TextEmitterComponent(String textEmitterId) {
		this.textEmitterId = textEmitterId;
	}

	public String getTextEmitterId() {
		return textEmitterId;
	}

	public void setTextEmitterId(String textEmitterId) {
		this.textEmitterId = textEmitterId;
	}

	public TextEmitter getTextEmitter(CacheManager cache) {
		return cache.getTextEmitter(this.textEmitterId);
	}

	public void setTextEmitter(TextEmitter textEmitter) {
		this.textEmitterId = textEmitter.getId();
	}

}
