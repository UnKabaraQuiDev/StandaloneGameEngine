package lu.kbra.standalone.gameengine.impl;

import java.io.Closeable;

public interface Cleanupable extends Closeable { // permits GLObject, ALObject, AutoCleanupable, GameEngine {

	void cleanup();

	@Override
	default void close() {
		cleanup();
	}

}
