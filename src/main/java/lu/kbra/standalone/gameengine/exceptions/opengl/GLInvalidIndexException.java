package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidIndexException extends GLRuntimeException {

	public GLInvalidIndexException(int status, String msg) {
		super(status, msg);
	}

	public GLInvalidIndexException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLInvalidIndexException(String str) {
		super(str);
	}

}
