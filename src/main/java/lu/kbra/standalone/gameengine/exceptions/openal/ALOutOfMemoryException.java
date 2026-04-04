package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALOutOfMemoryException extends ALRuntimeException {

	private static final long serialVersionUID = 1L;

	public ALOutOfMemoryException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public ALOutOfMemoryException(String str) {
		super(str);
	}

}
