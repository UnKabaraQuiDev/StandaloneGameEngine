package lu.kbra.standalone.gameengine.impl.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerDispatcher extends Dispatcher {

	private final ExecutorService[] workers;

	public WorkerDispatcher(String name, int workerCount) {
		super(name);

		workers = new ExecutorService[workerCount];
		for (int i = 0; i < workerCount; i++) {
			final int index = i;
			workers[i] = Executors.newSingleThreadExecutor(r -> new Thread(r, "Worker-" + index));
		}
		startWorkers();
	}

	private void startWorkers() {
		for (ExecutorService worker : workers) {
			worker.submit(() -> {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						final ScheduledTask task = queue.take(); // block until task
						task.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	@Override
	public void pump(long timeBudgetMillis) {
		// do nothing
	}

	public void post(Runnable task) {
		queue.add(new ScheduledTask(task, ScheduledTask.DEFAULT_PRIORITY));
	}

	public void post(Runnable task, int priority) {
		queue.add(new ScheduledTask(task, priority));
	}

	public void shutdown() {
		for (ExecutorService worker : workers) {
			worker.shutdownNow();
		}
	}

}