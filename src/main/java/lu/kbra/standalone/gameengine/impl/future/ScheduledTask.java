package lu.kbra.standalone.gameengine.impl.future;

public class ScheduledTask implements Comparable<ScheduledTask>, Runnable {

	public static final int DEFAULT_PRIORITY = 100;

	private final Runnable task;
	private final int priority;
	private final String sourceString;

	public ScheduledTask(Runnable task, int priority, String source) {
		this.task = task;
		this.priority = priority;
		this.sourceString = source;
	}

	public ScheduledTask(Runnable task, int priority) {
		this.task = task;
		this.priority = priority;
		this.sourceString = task.toString();
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

	public String getSourceString() {
		return sourceString;
	}

}