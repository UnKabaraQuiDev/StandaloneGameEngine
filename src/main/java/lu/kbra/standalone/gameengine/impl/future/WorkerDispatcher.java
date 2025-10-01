package lu.kbra.standalone.gameengine.impl.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class WorkerDispatcher {

	private final PriorityBlockingQueue<ScheduledTask> queue = new PriorityBlockingQueue<>();
	private final ExecutorService[] workers;

	public WorkerDispatcher(int workerCount) {
		// final IntPointer ip = new IntPointer(0);
		// workers = Executors.newFixedThreadPool(workerCount, (run) ->
		// ThreadBuilder.create(run).name("Worker-" + ip.increment()).build());

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