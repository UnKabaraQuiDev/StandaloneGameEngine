package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadConfigException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLBadConfigException(String str) {
		super(str);
	}

	public EGLBadConfigException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
