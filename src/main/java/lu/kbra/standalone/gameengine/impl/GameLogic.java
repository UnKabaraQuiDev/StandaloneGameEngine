package lu.kbra.standalone.gameengine.impl;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.audio.AudioMaster;
import lu.kbra.standalone.gameengine.cache.SharedCacheManager;
import lu.kbra.standalone.gameengine.graph.window.Window;
import lu.kbra.standalone.gameengine.impl.future.Dispatcher;

public abstract class GameLogic {

	public static GameLogic INSTANCE;

	protected GameEngine engine;
	protected SharedCacheManager cache;
	protected Window window;
	protected AudioMaster audio;

	public Dispatcher MAIN_DISPATCHER;
	public Dispatcher RENDER_DISPATCHER;
	public Dispatcher UPDATE_DISPATCHER;

	public void register(GameEngine e) {
		engine = e;

		cache = e.getCache();
		window = e.getWindow();

		audio = e.getAudioMaster();

		MAIN_DISPATCHER = e.getMainDispatcher();
		RENDER_DISPATCHER = e.getRenderDispatcher();
		UPDATE_DISPATCHER = e.getUpdateDispatcher();
	}

	public abstract void init() throws Exception;

	public abstract void input(float dTime);

	public abstract void update(float dTime);

	public abstract void render(float dTime);

	public void main() {
	}

	public abstract void cleanup();

	public static void cleanup(Cleanupable... vs) {
		for (Cleanupable v : vs)
			if (v != null)
				v.cleanup();
	}

	protected boolean waitForFrameEnd() {
		return engine.waitForFrameEnd();
	}

	protected boolean waitForUpdateEnd() {
		return engine.waitForUpdateEnd();
	}

	protected boolean waitForFrameStart() {
		return engine.waitForFrameStart();
	}

	protected boolean waitForUpdateStart() {
		return engine.waitForUpdateStart();
	}

	public void stop() {
		engine.stop();
	}

	public GameEngine getGameEngine() {
		return engine;
	}

	public double getTotalTime() {
		return engine.getTotalTime();
	}

}
