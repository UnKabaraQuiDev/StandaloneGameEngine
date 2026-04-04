package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GLRuntimeException(String str) {
		super(str);
	}

	public GLRuntimeException(String caller, int status, String msg) {
		super("" + caller + " triggered : " + status + " (" + msg + ")");
	}

	public GLRuntimeException(int status, String msg) {
		super(status + " (" + msg + ")");
	}

}
