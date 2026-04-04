package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALInvalidDeviceException extends ALRuntimeException {

	private static final long serialVersionUID = 1L;

	public ALInvalidDeviceException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public ALInvalidDeviceException(String str) {
		super(str);
	}

}
