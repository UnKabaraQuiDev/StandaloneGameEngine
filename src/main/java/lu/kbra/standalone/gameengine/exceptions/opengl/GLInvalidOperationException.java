package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidOperationException extends GLRuntimeException {

	public GLInvalidOperationException(int status, String msg) {
		super(status, msg);
	}

	public GLInvalidOperationException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLInvalidOperationException(String str) {
		super(str);
	}

}
