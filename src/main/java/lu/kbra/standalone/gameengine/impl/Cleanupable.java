package lu.kbra.standalone.gameengine.impl;

public interface Cleanupable extends AutoCloseable {

	void cleanup();
	
	@Override
	default void close() {
		cleanup();
	}

}
