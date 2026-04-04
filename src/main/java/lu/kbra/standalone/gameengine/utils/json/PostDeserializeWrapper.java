package lu.kbra.standalone.gameengine.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;

public class PostDeserializeWrapper extends JsonDeserializer<Object> implements ContextualDeserializer, ResolvableDeserializer {

	private final JsonDeserializer<Object> defaultDeserializer;

	public PostDeserializeWrapper(final JsonDeserializer<?> defaultDeserializer) {
		this.defaultDeserializer = (JsonDeserializer<Object>) defaultDeserializer;
	}

	@Override
	public Object deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
		final Object obj = this.defaultDeserializer.deserialize(p, ctxt);

		if (obj instanceof final PostDeserialize pd) {
			pd.postDeserialize();
		}

		return obj;
	}

	@Override
	public JsonDeserializer<?> createContextual(final DeserializationContext ctxt, final BeanProperty property) throws JsonMappingException {

		JsonDeserializer<?> deser = this.defaultDeserializer;

		if (deser instanceof final ContextualDeserializer cd) {
			deser = cd.createContextual(ctxt, property);
		}

		return new PostDeserializeWrapper(deser);
	}

	@Override
	public void resolve(final DeserializationContext ctxt) throws JsonMappingException {
		if (this.defaultDeserializer instanceof final ResolvableDeserializer rd) {
			rd.resolve(ctxt);
		}
	}

}