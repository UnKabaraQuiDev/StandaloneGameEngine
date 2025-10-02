package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidFrameBufferOperationException extends GLRuntimeException {

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
