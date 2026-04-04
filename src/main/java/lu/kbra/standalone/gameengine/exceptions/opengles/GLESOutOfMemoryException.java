package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESOutOfMemoryException extends GLESRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLESOutOfMemoryException(String str) {
		super(str);
	}

	public GLESOutOfMemoryException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
