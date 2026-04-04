package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadCurrentSurfaceException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadCurrentSurfaceException(String str) {
		super(str);
	}

	public EGLBadCurrentSurfaceException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
