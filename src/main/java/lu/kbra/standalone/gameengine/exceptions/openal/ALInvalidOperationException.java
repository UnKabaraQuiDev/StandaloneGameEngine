package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALInvalidOperationException extends ALRuntimeException {

	public ALInvalidOperationException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public ALInvalidOperationException(String str) {
		super(str);
	}

}
