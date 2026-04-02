package lu.kbra.standalone.gameengine.utils.json;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class PostDeserializeModule extends SimpleModule {

	public PostDeserializeModule() {
		super.setDeserializerModifier(new GlobalPostDeserializeModifier());
	}

}
