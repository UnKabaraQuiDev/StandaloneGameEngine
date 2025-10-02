package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLStackUnderflowException extends GLRuntimeException {

	public GLStackUnderflowException(int status, String msg) {
		super(status, msg);
	}

	public GLStackUnderflowException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLStackUnderflowException(String str) {
		super(str);
	}

}
