package lu.kbra.standalone.gameengine.graph.render;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;

public abstract class Renderer<T, K extends Renderable> implements UniqueID, Cleanupable {

	private String clazz;

	private long startTime;

	public Renderer(Class<?> clas) {
		this.clazz = clas.getName();
	}

	public void render(CacheManager cache, T parent, K obj) {
		startTime = System.nanoTime();
		render_in(cache, parent, obj);
		GlobalLogger.log("Renderer: " + clazz + ", took: " + ((double) (System.nanoTime() - startTime) / 1e6) + "ms");
	}

	protected abstract void render_in(CacheManager cache, T parent, K obj);

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + clazz);

		if (clazz != null) {
			clazz = null;
		}
	}

	@Override
	public String getId() {
		return clazz;
	}

}
