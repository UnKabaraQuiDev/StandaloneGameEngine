package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidIndexException extends GLRuntimeException {

	public GLInvalidIndexException(String caller, int status, String msg) {
		super("" + caller + " triggered : " + status + " (" + msg + ")");
	}

}
