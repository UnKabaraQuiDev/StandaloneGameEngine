package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidEnumException extends GLESRuntimeException {

	private static final long serialVersionUID = 1L;

	public GLESInvalidEnumException(String str) {
		super(str);
	}

	public GLESInvalidEnumException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
