package lu.kbra.standalone.gameengine;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.impl.GameLogic;

public class GameLogicTest extends GameLogic {

	@Override
	public void init() {
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

	@Override
	public void cleanup() {
		GlobalLogger.log();
	}

}
