package lu.kbra.standalone.gameengine.impl.future;

public class SkipThen extends RuntimeException {

	private int count = 1;
	private Object obj;

	public SkipThen(int count, Object obj) {
		this.count = count;
		this.obj = obj;
	}

	public SkipThen(Object obj) {
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	public int getCount() {
		return count;
	}

}
