package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidValueException extends GLESRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLESInvalidValueException(String str) {
		super(str);
	}

	public GLESInvalidValueException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
