package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidEnumException extends GLESRuntimeException {

	public GLESInvalidEnumException(String str) {
		super(str);
	}

	public GLESInvalidEnumException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
