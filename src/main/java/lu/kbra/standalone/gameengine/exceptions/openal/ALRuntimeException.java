package lu.kbra.standalone.gameengine.exceptions.openal;

public class ALRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ALRuntimeException(String str) {
		super(str);
	}

	public ALRuntimeException(String caller, int status, String msg) {
		super("" + caller + " triggered : " + status + " (" + msg + ")");
	}

}
