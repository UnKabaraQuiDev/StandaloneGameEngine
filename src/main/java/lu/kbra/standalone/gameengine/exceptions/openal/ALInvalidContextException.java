package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALInvalidContextException extends ALRuntimeException {

	private static final long serialVersionUID = 1L;

	public ALInvalidContextException(String str) {
		super(str);
	}

	public ALInvalidContextException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
