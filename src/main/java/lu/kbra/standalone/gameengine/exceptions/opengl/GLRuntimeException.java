package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLRuntimeException extends RuntimeException {

	public GLRuntimeException(String str) {
		super(str);
	}

	public GLRuntimeException(String caller, int status, String msg) {
		super("" + caller + " triggered : " + status + " (" + msg + ")");
	}

}
