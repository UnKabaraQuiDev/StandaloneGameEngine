package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidFramebufferOperationException extends GLESRuntimeException {

	public GLESInvalidFramebufferOperationException(String str) {
		super(str);
	}

	public GLESInvalidFramebufferOperationException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
