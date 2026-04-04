package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadNativeWindowException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadNativeWindowException(String str) {
		super(str);
	}

	public EGLBadNativeWindowException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
