package lu.kbra.standalone.gameengine.exceptions.egl;

public class EGLBadParameterException extends EGLRuntimeException {
	
	public EGLBadParameterException(String str) {
		super(str);
	}

	public EGLBadParameterException(String caller, int status, String msg) {
		super(caller, status, msg);
	}
	
}
