package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadAccessException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadAccessException(String str) {
		super(str);
	}

	public EGLBadAccessException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
