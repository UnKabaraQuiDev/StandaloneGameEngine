package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALInvalidValueException extends ALRuntimeException {

	private static final long serialVersionUID = 1L;

	public ALInvalidValueException(String str) {
		super(str);
	}

	public ALInvalidValueException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
