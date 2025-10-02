package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLInvalidEnumException extends GLRuntimeException {

	public GLInvalidEnumException(int status, String msg) {
		super(status, msg);
	}

	public GLInvalidEnumException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLInvalidEnumException(String str) {
		super(str);
	}


}
