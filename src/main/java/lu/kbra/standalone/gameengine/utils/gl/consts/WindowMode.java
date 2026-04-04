package lu.kbra.standalone.gameengine.utils.gl.consts;

public enum WindowMode {

	WINDOWED,
	FULLSCREEN,
	@Deprecated
	BORDERLESS;

	public WindowMode next() {
		return switch (this) {
		case WINDOWED -> FULLSCREEN;
		case FULLSCREEN -> WINDOWED;
		case BORDERLESS -> WINDOWED;
		};
	}

}
