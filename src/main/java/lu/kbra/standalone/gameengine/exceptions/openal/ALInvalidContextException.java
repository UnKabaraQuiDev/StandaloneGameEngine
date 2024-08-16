package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALInvalidContextException extends ALRuntimeException {

	public ALInvalidContextException(String str) {
		super(str);
	}

	public ALInvalidContextException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
