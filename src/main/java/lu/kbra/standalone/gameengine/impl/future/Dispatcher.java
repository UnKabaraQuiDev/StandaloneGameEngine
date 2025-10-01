package lu.kbra.standalone.gameengine.impl.future;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Dispatcher {

	private final BlockingQueue<ScheduledTask> queue = new PriorityBlockingQueue<>();

	public void post(Runnable task, int priority) {
		queue.add(new ScheduledTask(task, priority));
	}

	public void pump(long timeBudgetMillis) {
		if (timeBudgetMillis <= 0)
			return;

		final long deadline = System.currentTimeMillis() + timeBudgetMillis;
		while (System.currentTimeMillis() < deadline) {
			final ScheduledTask task = queue.poll();
			if (task == null)
				break;
			task.run();
		}
	}

}
