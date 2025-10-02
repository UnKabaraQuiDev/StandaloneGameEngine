package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLOutOfMemoryException extends GLRuntimeException {

	public GLOutOfMemoryException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLOutOfMemoryException(int status, String msg) {
		super(status, msg);
	}

	public GLOutOfMemoryException(String str) {
		super(str);
	}

}
