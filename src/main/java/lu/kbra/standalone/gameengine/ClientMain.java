package lu.kbra.standalone.gameengine;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import lu.kbra.standalone.gameengine.graph.window.WindowOptions;
import lu.kbra.standalone.gameengine.impl.GameLogic;
import lu.pcy113.pclib.logger.GlobalLogger;

public class ClientMain {

	public static void main(String[] args) {
		final File propertyFile = new File("./config/main.properties");

		final Properties props = new Properties();
		try {
			props.load(new FileReader(propertyFile));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			GlobalLogger.init(new File(props.getProperty("logs.config.file")));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Class<? extends GameLogic> gameLogicClass = null;
		try {
			gameLogicClass = (Class<? extends GameLogic>) Class.forName(props.getProperty("main.class"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		GameLogic gameLogic = null;
		try {
			gameLogic = gameLogicClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return;
		}

		final String name = props.getProperty("game.name");

		final GameEngine engine = new GameEngine(name, gameLogic, new WindowOptions(props, "windowOptions"));
		engine.start();
	}

}
