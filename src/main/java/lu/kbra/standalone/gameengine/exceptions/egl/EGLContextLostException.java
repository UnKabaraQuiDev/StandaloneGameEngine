package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLContextLostException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	public EGLContextLostException(String str) {
		super(str);
	}

	public EGLContextLostException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
