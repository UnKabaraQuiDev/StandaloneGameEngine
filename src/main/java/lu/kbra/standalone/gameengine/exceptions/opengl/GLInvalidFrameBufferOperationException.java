package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidFrameBufferOperationException extends GLRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLInvalidFrameBufferOperationException(int status, String msg) {
		super(status, msg);
	}

	public GLInvalidFrameBufferOperationException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLInvalidFrameBufferOperationException(String str) {
		super(str);
	}

}
