package lu.kbra.standalone.gameengine.impl.nexttask;

import java.util.function.Function;
import java.util.function.Supplier;

public class TaskFuture<T> {
	
	private final Dispatcher dispatcher;
	private final Supplier<T> task;

	public TaskFuture(Dispatcher dispatcher, Supplier<T> task) {
		this.dispatcher = dispatcher;
		this.task = task;
	}
	// Run task in this dispatcher and chain result to next dispatcher
	public <U> TaskFuture<U> then(Dispatcher nextDispatcher, Function<T, U> callback, int priority) {
		TaskFuture<U> nextFuture = new TaskFuture<>(nextDispatcher, () -> null);

		dispatcher.post(() -> {
			T result = task.get(); // run original task
			nextDispatcher.post(() -> callback.apply(result), priority); // schedule callback
		}, priority);

		return nextFuture;
	}
	
}