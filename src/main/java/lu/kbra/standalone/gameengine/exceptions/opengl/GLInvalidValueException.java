package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidValueException extends GLRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLInvalidValueException(int status, String msg) {
		super(status, msg);
	}

	public GLInvalidValueException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLInvalidValueException(String str) {
		super(str);
	}

}
