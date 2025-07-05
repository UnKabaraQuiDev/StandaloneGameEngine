package lu.kbra.standalone.gameengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.graph.window.WindowOptions;
import lu.kbra.standalone.gameengine.impl.GameLogic;

public class ClientMain {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, FileNotFoundException, IOException {
		final File propertyFile = new File("./config/main.properties");

		final Properties props = new Properties();
		props.load(new FileReader(propertyFile));

		try {
			GlobalLogger.init(new File(props.getProperty("logs.config.file")));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Class<? extends GameLogic> gameLogicClass = (Class<? extends GameLogic>) Class
				.forName(props.getProperty("main.class"));

		GameLogic gameLogic = gameLogicClass.newInstance();

		final String name = props.getProperty("game.name");

		final GameEngine engine = new GameEngine(name, gameLogic, new WindowOptions(props, "windowOptions"));
		engine.start();
	}

}
