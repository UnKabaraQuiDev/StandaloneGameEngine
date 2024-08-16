package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidFrameBufferOperationException extends GLRuntimeException {

	public GLInvalidFrameBufferOperationException(String caller, int status, String msg) {
		super("" + caller + " triggered : " + status + " (" + msg + ")");
	}

}
