package lu.kbra.standalone.gameengine.utils;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.logging.Level;

import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.opengl.GLCapabilities;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.logger.GlobalLogger;

public final class GameEngineLoggerUtils {

	private static int count = 0;

	public static synchronized void log(ALCCapabilities deviceCapabilities)
			throws IllegalArgumentException, IllegalAccessException {
		logFields(deviceCapabilities);
	}

	public static void log(GLCapabilities capabilities) throws IllegalArgumentException, IllegalAccessException {
		logFields(capabilities);
	}

	private static void logFields(Object capabilities) throws IllegalArgumentException, IllegalAccessException {
		if (!GlobalLogger.isInit()) {
			throw new RuntimeException("GlobalLogger is not initiated.");
		}
		Objects.requireNonNull(capabilities);
		GlobalLogger.log(capabilities.getClass().getName() + ":");
		synchronized (GlobalLogger.getLogger()) {
			for (Field f : capabilities.getClass().getFields()) {
				if (f.getType() == boolean.class && f.get(capabilities).equals(Boolean.TRUE)) {
					GlobalLogger.logRaw(Level.INFO,
							"\t" + PCUtils.leftPadString(Integer.toString(count++), " ", 3) + ". " + f.getName());
				}
			}
		}
		count = 0;
	}

}
