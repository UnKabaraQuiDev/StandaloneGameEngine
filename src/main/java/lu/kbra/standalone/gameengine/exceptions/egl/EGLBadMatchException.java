package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadMatchException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadMatchException(String str) {
		super(str);
	}

	public EGLBadMatchException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
