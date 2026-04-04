package lu.kbra.standalone.gameengine.impl.future;

import java.util.List;
import java.util.concurrent.DelayQueue;

import lu.kbra.pclib.impl.ThrowingRunnable;

public class Dispatcher {

	public static final int DEFAULT_PRIORITY = 0;

	protected final String name;
	protected final DelayQueue<ScheduledTask> queue = new DelayQueue<>();

	public Dispatcher(String name) {
		this.name = name;
	}

	public ScheduledTask post(ThrowingRunnable<YieldExecutionThrowable> task, int priority) {
		final ScheduledTask task2 = new ScheduledTask(task, priority);
		queue.add(task2);
		return task2;
	}

	public ScheduledTask post(ThrowingRunnable<YieldExecutionThrowable> task, int priority, String source) {
		final ScheduledTask task2 = new ScheduledTask(task, priority, source);
		queue.add(task2);
		return task2;
	}

	public ScheduledTask post(ScheduledTask task) {
		queue.add(task);
		return task;
	}

	public ScheduledTask post(ThrowingRunnable<YieldExecutionThrowable> task) {
		final ScheduledTask task2 = new ScheduledTask(task, DEFAULT_PRIORITY);
		queue.add(task2);
		return task2;
	}

	// duplicated for optimization
	public int pump(long timeBudgetNanos) {
		if (timeBudgetNanos <= 0)
			return 0;

		int count = 0;
		final long deadline = System.nanoTime() + timeBudgetNanos;
		while (System.nanoTime() < deadline) {
			final ScheduledTask task = queue.poll();
			if (task == null)
				break;
			task.run();
			task.setRan(true);
			count++;
		}

		return count;
	}

	public int pump(long timeBudgetNanos, List<String> list) {
		list.clear();

		if (timeBudgetNanos <= 0)
			return 0;

		int count = 0;
		final long deadline = System.nanoTime() + timeBudgetNanos;
		while (System.nanoTime() < deadline) {
			final ScheduledTask task = queue.poll();
			if (task == null)
				break;
			task.run();
			task.setRan(true);
			list.add(task.getSourceString());
			count++;
		}

		return count;
	}

	public String getName() {
		return name;
	}

	public void clear() {
		queue.clear();
	}

}
