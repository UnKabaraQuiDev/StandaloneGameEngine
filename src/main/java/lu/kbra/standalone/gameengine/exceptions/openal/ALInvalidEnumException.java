package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALInvalidEnumException extends ALRuntimeException {

	private static final long serialVersionUID = 1L;

	public ALInvalidEnumException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public ALInvalidEnumException(String str) {
		super(str);
	}

}
