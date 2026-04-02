package lu.kbra.standalone.gameengine.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PostDeserializeWrapper extends JsonDeserializer<Object> {

	private final JsonDeserializer<?> defaultDeserializer;

	public PostDeserializeWrapper(final JsonDeserializer<?> defaultDeserializer) {
		this.defaultDeserializer = defaultDeserializer;
	}

	@Override
	public Object deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
		final Object obj = this.defaultDeserializer.deserialize(p, ctxt);

		if (obj instanceof final PostDeserialize pd) {
			pd.postDeserialize();
		}

		return obj;
	}

}