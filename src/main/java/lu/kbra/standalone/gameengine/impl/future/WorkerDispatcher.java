package lu.kbra.standalone.gameengine.impl.future;

import lu.kbra.pclib.ThreadBuilder;
import lu.kbra.pclib.impl.ThrowingRunnable;

public class WorkerDispatcher extends Dispatcher implements Runnable {

	private final ThreadGroup group;
	private final Thread[] workers;

	public WorkerDispatcher(final String name, final int workerCount) {
		super(name);

		this.group = new ThreadGroup(name);
		this.workers = new Thread[workerCount];
		for (int i = 0; i < workerCount; i++) {
			final int index = i;
			this.workers[i] = ThreadBuilder.create(this.group, this).name("Worker-" + name + "-" + index).daemon(true).start();
		}
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				final ScheduledTask task = this.queue.take();
				task.run();
				if (!task.wasRan()) {
					this.queue.offer(task);
				}
			} catch (final InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ScheduledTask post(final ThrowingRunnable<YieldExecutionThrowable> task, final int priority) {
		final ScheduledTask task2 = new ScheduledTask(task, priority);
		this.queue.add(task2);
		return task2;
	}

	@Override
	public ScheduledTask post(final ThrowingRunnable<YieldExecutionThrowable> task, final int priority, final String source) {
		final ScheduledTask task2 = new ScheduledTask(task, priority, source);
		this.queue.add(task2);
		return task2;
	}

	@Override
	public ScheduledTask post(final ScheduledTask task) {
		this.queue.add(task);
		return task;
	}

	@Override
	public ScheduledTask post(final ThrowingRunnable<YieldExecutionThrowable> task) {
		final ScheduledTask task2 = new ScheduledTask(task, DEFAULT_PRIORITY);
		this.queue.add(task2);
		return task2;
	}

	public void shutdown() {
		this.group.interrupt();
	}

}
