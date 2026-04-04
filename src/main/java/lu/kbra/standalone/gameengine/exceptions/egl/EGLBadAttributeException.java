package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadAttributeException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadAttributeException(String str) {
		super(str);
	}

	public EGLBadAttributeException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
