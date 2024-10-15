package lu.kbra.standalone.gameengine;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.GameLogic;

public class GameLogicTest extends GameLogic {

	@Override
	public void init(GameEngine e) {
		GlobalLogger.log();
	}

	@Override
	public void input(float dTime) {
		GlobalLogger.log();
	}

	@Override
	public void update(float dTime) {
		GlobalLogger.log();
	}

	@Override
	public void render(float dTime) {
		GlobalLogger.log();
	}

}
