package lu.kbra.standalone.gameengine.exceptions.egl;

@Deprecated
public class EGLNoContextException extends EGLRuntimeException {

	private static final long serialVersionUID = 1L;

	@Deprecated
	public EGLNoContextException(String str) {
		super(str);
	}

	@Deprecated
	public EGLNoContextException(String caller, int status, String msg) {
		super(caller, status, msg);
	}

}
