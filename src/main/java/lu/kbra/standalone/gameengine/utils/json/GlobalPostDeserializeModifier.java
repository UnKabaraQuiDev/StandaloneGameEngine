package lu.kbra.standalone.gameengine.utils.json;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

public class GlobalPostDeserializeModifier extends BeanDeserializerModifier {

	@Override
	public JsonDeserializer<?> modifyDeserializer(
			final DeserializationConfig config,
			final BeanDescription beanDesc,
			final JsonDeserializer<?> deserializer) {

		final Class<?> clazz = beanDesc.getBeanClass();

		if (PostDeserialize.class.isAssignableFrom(clazz)) {
			return new PostDeserializeWrapper(deserializer);
		}

		return deserializer;
	}
}
