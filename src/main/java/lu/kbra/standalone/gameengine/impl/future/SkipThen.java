package lu.kbra.standalone.gameengine.impl.future;

public class SkipThen extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int count = 1;
	private Object obj;
	private TaskFuture next;

	public SkipThen(int count, Object obj) {
		this.count = count;
		this.obj = obj;
	}

	public SkipThen(int count, TaskFuture next) {
		this.count = count;
		this.next = next;
	}

	public SkipThen(TaskFuture next) {
		this.next = next;
	}

	public SkipThen(int count, Object obj, TaskFuture next) {
		this.count = count;
		this.obj = obj;
		this.next = next;
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

	public TaskFuture getNext() {
		return next;
	}

}
