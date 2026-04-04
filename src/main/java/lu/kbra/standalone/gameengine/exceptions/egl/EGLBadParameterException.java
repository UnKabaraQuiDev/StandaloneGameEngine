package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadParameterException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadParameterException(String str) {
		super(str);
	}

	public EGLBadParameterException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
