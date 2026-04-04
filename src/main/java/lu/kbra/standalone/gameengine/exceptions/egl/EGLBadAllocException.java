package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadAllocException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadAllocException(String str) {
		super(str);
	}

	public EGLBadAllocException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
