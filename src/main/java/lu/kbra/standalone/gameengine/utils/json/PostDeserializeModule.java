package lu.kbra.standalone.gameengine.utils.json;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class PostDeserializeModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public PostDeserializeModule() {
		super.setDeserializerModifier(new GlobalPostDeserializeModifier());
	}

}
