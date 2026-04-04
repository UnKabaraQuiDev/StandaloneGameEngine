package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GLESRuntimeException(String str) {
		super(str);
	}

	public GLESRuntimeException(String caller, int status, String msg) {
		super("" + caller + " triggered : " + status + " (" + msg + ")");
	}

}
