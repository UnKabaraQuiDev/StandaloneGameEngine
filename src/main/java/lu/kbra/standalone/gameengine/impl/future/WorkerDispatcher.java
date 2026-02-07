package lu.kbra.standalone.gameengine.impl.future;

import lu.kbra.pclib.ThreadBuilder;
import lu.kbra.pclib.impl.ThrowingRunnable;

public class WorkerDispatcher extends Dispatcher implements Runnable {

	private final ThreadGroup group;
	private final Thread[] workers;

	public WorkerDispatcher(String name, int workerCount) {
		super(name);

		group = new ThreadGroup(name);
		workers = new Thread[workerCount];
		for (int i = 0; i < workerCount; i++) {
			final int index = i;
			workers[i] = ThreadBuilder.create(group, this).name("Worker-" + name + "-" + index).daemon(true).start();
		}
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				final ScheduledTask task = queue.take();
//				System.err.println(Thread.currentThread().getName() + " took task " + System.identityHashCode(task));
//				if (!task.isReady()) {
//					queue.offer(task);
//				}
				task.run();
				if (!task.wasRan()) {
					queue.offer(task);
				}
			} catch (InterruptedException e) {
				// e.printStackTrace();
				Thread.currentThread().interrupt();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

	public void shutdown() {
		group.interrupt();
	}

}