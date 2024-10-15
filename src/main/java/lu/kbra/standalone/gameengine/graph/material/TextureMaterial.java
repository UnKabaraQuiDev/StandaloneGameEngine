package lu.kbra.standalone.gameengine.graph.material;

import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.graph.texture.Texture;
import lu.kbra.standalone.gameengine.impl.Renderable;

public class TextureMaterial extends Material {

	private Map<String, Texture> textures;

	public TextureMaterial(String name, RenderShader shader, Map<String, Texture> textures) {
		super(name, shader);

		this.textures = textures;
		int i = 0;
		for (Entry<String, Texture> txt : textures.entrySet()) {
			properties.put(txt.getKey(), i++);
		}
	}

	@Override
	public void bindProperties(CacheManager cache, Renderable scene, RenderShader shader) {
		super.bindProperties(cache, scene, shader);

		int i = 0;
		for (Entry<String, Texture> txt : textures.entrySet()) {
			Texture texture = txt.getValue();
			if (texture == null) {
				GlobalLogger.log(Level.WARNING, "Could not find texture: " + txt.getKey());
				continue;
			}
			texture.bind(i);
			int loc = shader.getUniformLocation(txt.getKey());
			texture.bindUniform(loc, i);
			
			i++;
		}
	}
	
	public Texture setTexture(String key, Texture texture) {
		return textures.put(key, texture);
	}

}
