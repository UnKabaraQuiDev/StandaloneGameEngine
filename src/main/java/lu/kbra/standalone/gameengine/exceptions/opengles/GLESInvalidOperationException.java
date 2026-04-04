package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidOperationException extends GLESRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLESInvalidOperationException(String str) {
		super(str);
	}

	public GLESInvalidOperationException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
