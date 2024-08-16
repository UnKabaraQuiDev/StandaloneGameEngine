package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadDisplayException extends EGLRuntimeException {
	
	public EGLBadDisplayException(String str) {
		super(str);
	}

	public EGLBadDisplayException(String caller, int status, String msg) {
		super(caller, status, msg);
	}
	
}
