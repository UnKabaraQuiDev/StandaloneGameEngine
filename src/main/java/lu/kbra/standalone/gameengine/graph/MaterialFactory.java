package lu.kbra.standalone.gameengine.graph;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lu.pcy113.pclib.PCUtils;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.graph.shader.annotation.AssociatedShader;

public class MaterialFactory {

	public static MaterialFactory INSTANCE;

	public static final Map<Class<? extends Material>, Class<? extends RenderShader>> MATERIAL_2_SHADERS = new HashMap<>();

	private CacheManager cache;

	public MaterialFactory(CacheManager cache) {
		this.cache = cache;
	}

	public <T extends Material> T newMaterial(Class<T> clazz, Object... args) {
		MATERIAL_2_SHADERS.computeIfAbsent(clazz, k -> {
			if (!k.isAnnotationPresent(AssociatedShader.class)) {
				throw new IllegalStateException("Class: " + k + " doesn't have @" + AssociatedShader.class.getSimpleName() + ".");
			}
			return k.getAnnotation(AssociatedShader.class).value();
		});

		final Class<? extends RenderShader> shaderClazz = MATERIAL_2_SHADERS.get(clazz);

		if (!cache.hasRenderShader(shaderClazz.getName())) {
			try {
				cache.addRenderShader(shaderClazz.getConstructor().newInstance());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				throw new RuntimeException("Exception while creating render shader.", e);
			}
		}

		final RenderShader shader = cache.getRenderShader(shaderClazz.getName());

		try {
			return (T) clazz
					.getConstructor(PCUtils.combineArrays(new Class<?>[]
					{ shaderClazz }, Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new)))
					.newInstance(shader);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException("Exception while creating material.", e);
		}
	}

}
