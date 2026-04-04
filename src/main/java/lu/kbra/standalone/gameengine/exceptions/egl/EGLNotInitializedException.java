package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLNotInitializedException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLNotInitializedException(String str) {
		super(str);
	}

	public EGLNotInitializedException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
