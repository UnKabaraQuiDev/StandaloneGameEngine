package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLStackOverflowException extends GLRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLStackOverflowException(int status, String msg) {
		super(status, msg);
	}

	public GLStackOverflowException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLStackOverflowException(String str) {
		super(str);
	}

}
