package lu.kbra.standalone.gameengine.exceptions.opengl;

public class GLContextLost extends GLRuntimeException {

	public GLContextLost(String caller, int status, String msg) {
		super(caller, status, msg);
	}

	public GLContextLost(int status, String msg) {
		super(status, msg);
	}

	public GLContextLost(String str) {
		super(str);
	}

}
