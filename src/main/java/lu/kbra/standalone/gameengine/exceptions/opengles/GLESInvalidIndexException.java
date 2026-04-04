package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidIndexException extends GLESRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLESInvalidIndexException(String str) {
		super(str);
	}

	public GLESInvalidIndexException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
