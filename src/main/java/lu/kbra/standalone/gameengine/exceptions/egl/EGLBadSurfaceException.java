package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadSurfaceException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadSurfaceException(String str) {
		super(str);
	}

	public EGLBadSurfaceException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
