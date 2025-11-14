package lu.kbra.standalone.gameengine.impl.future;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Dispatcher {

	public static final int DEFAULT_PRIORITY = 100;

	protected final String name;
	protected final BlockingQueue<ScheduledTask> queue = new PriorityBlockingQueue<>();

	public Dispatcher(String name) {
		this.name = name;
	}

	public void post(Runnable task, int priority) {
		queue.add(new ScheduledTask(task, priority));
	}

	public void post(Runnable task, int priority, String source) {
		queue.add(new ScheduledTask(task, priority, source));
	}

	public void post(ScheduledTask task) {
		queue.add(task);
	}

	public void post(Runnable task) {
		queue.add(new ScheduledTask(task, DEFAULT_PRIORITY));
	}

	// duplicated for optimisation
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
			list.add(task.getSourceString());
			count++;
		}

		return count;
	}

	public String getName() {
		return name;
	}

}
