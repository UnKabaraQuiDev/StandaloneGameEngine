package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALInvalidNameException extends ALRuntimeException {

	private static final long serialVersionUID = 1L;

	public ALInvalidNameException(String str) {
		super(str);
	}

	public ALInvalidNameException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
