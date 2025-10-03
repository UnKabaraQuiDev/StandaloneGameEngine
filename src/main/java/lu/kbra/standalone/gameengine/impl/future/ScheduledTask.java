package lu.kbra.standalone.gameengine.impl.future;

public class ScheduledTask implements Comparable<ScheduledTask>, Runnable {

	public static final int DEFAULT_PRIORITY = 100;

	private final Runnable task;
	private final int priority;

	public ScheduledTask(Runnable task, int priority) {
		this.task = task;
		this.priority = priority;
	}

	@Override
	public int compareTo(ScheduledTask o) {
		return Integer.compare(o.priority, this.priority); // higher first
	}

	@Override
	public void run() {
		task.run();
	}

	public int getPriority() {
		return priority;
	}

}