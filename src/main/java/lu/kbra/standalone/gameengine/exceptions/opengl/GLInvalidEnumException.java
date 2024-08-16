package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidEnumException extends GLRuntimeException {

	public GLInvalidEnumException(String caller, int status, String msg) {
		super("" + caller + " triggered : " + status + " (" + msg + ")");
	}

}
