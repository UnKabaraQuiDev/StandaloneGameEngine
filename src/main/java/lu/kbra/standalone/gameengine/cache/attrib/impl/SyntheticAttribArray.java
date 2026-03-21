package lu.kbra.standalone.gameengine.cache.attrib.impl;

public interface SyntheticAttribArray extends AttribArray {

	@Override
	default boolean isLoaded() {
		return false;
	}

	@Override
	default void update() {
		throw new UnsupportedOperationException("Synthetic arrays cannot be updated");
	}

}
