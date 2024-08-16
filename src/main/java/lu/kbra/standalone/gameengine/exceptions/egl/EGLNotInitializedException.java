package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLNotInitializedException extends EGLRuntimeException {
	
	public EGLNotInitializedException(String str) {
		super(str);
	}

	public EGLNotInitializedException(String caller, int status, String msg) {
		super(caller, status, msg);
	}
	
}
