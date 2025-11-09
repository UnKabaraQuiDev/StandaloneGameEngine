package lu.kbra.standalone.gameengine.impl.future;

import lu.pcy113.pclib.builder.ThreadBuilder;

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
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void post(Runnable task) {
		queue.add(new ScheduledTask(task, ScheduledTask.DEFAULT_PRIORITY));
	}

	public void post(Runnable task, int priority) {
		queue.add(new ScheduledTask(task, priority));
	}

	public void shutdown() {
		group.interrupt();
	}

}