package lu.kbra.standalone.gameengine.exceptions.opengles;

public class GLESInvalidIndexException extends GLESRuntimeException {

	public GLESInvalidIndexException(String str) {
		super(str);
	}

	public GLESInvalidIndexException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
