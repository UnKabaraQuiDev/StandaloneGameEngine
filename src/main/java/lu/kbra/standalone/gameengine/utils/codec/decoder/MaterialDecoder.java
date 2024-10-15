package lu.kbra.standalone.gameengine.utils.codec.decoder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;

import lu.pcy113.jbcodec.decoder.DefaultObjectDecoder;

import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.utils.codec.DefaultObjectDecoderMethod;

public class MaterialDecoder extends DefaultObjectDecoder<Material> {

	public MaterialDecoder() {
		super(Material.class);
	}

	@Override
	public Material decode(boolean head, ByteBuffer bb) {

		try {
			Class<Material> clazz = (Class<Material>) Class.forName(cm.getDecoderByClass(String.class).decode(false, bb));

			for (Method m : clazz.getDeclaredMethods()) {
				if (Modifier.isStatic(m.getModifiers()) && m.isAnnotationPresent(DefaultObjectDecoderMethod.class)) {
					return (Material) m.invoke(null);
				}
			}

			throw new RuntimeException("@DefaultObjectDecoderMethod not found on static method (" + clazz.getName() + ").");

		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
