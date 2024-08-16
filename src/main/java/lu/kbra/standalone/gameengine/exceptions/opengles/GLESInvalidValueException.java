package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidValueException extends GLESRuntimeException {

	public GLESInvalidValueException(String str) {
		super(str);
	}

	public GLESInvalidValueException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
