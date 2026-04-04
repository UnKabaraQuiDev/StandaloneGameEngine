package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadDisplayException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadDisplayException(String str) {
		super(str);
	}

	public EGLBadDisplayException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
