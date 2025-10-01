package lu.kbra.standalone.gameengine.impl;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.audio.AudioMaster;
import lu.kbra.standalone.gameengine.cache.SharedCacheManager;
import lu.kbra.standalone.gameengine.graph.window.Window;
import lu.kbra.standalone.gameengine.impl.future.Dispatcher;

public abstract class GameLogic {

	protected GameEngine engine;
	protected SharedCacheManager cache;
	protected Window window;
	protected AudioMaster audio;

	protected Dispatcher MAIN_DISPATCHER, RENDER_DISPATCHER, UPDATE_DISPATCHER;

	public void register(GameEngine e) {
		this.engine = e;

		this.cache = e.getCache();
		this.window = e.getWindow();

		this.audio = e.getAudioMaster();

		this.MAIN_DISPATCHER = e.getMainDispatcher();
		this.RENDER_DISPATCHER = e.getRenderDispatcher();
		this.UPDATE_DISPATCHER = e.getUpdateDispatcher();
	}

	public abstract void init(GameEngine e);

	public void updateInit() {
	}

	public abstract void input(float dTime);

	public abstract void update(float dTime);

	public abstract void render(float dTime);

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

}
