package lu.kbra.standalone.gameengine.impl.future;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TaskFuture<T, U> {

	private TaskFuture<?, ?> first;
	private final Dispatcher dispatcher;
	private final Function<T, U> task;
	private final int priority;
	private TaskFuture<U, ?> next;

	public TaskFuture(Dispatcher dispatcher, Function<T, U> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, Function<T, U> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = task;
		this.priority = priority;
		this.first = this;
	}

	public TaskFuture(Dispatcher dispatcher, Supplier<U> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, Supplier<U> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = (v) -> task.get();
		this.priority = priority;
		this.first = this;
	}

	public TaskFuture(Dispatcher dispatcher, Runnable task) {
		this(dispatcher, () -> {
			task.run();
			return null;
		}, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, Runnable task, int priority) {
		this(dispatcher, () -> {
			task.run();
			return null;
		}, priority);
	}

	public <V> TaskFuture<U, V> then(Dispatcher nextDispatcher, Function<U, V> function) {
		return then(nextDispatcher, function, 0);
	}

	public <V> TaskFuture<U, V> then(Dispatcher nextDispatcher, Function<U, V> function, int priority) {
		TaskFuture<U, V> nextFuture = new TaskFuture<U, V>(nextDispatcher, function, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public TaskFuture<U, Void> then(Dispatcher nextDispatcher, Consumer<U> consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public TaskFuture<U, Void> then(Dispatcher nextDispatcher, Consumer<U> consumer, int priority) {
		TaskFuture<U, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.accept(v);
			return null;
		}, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public void push() {
		first.pushInternal(null);
	}

	private void pushInternal(T v) {
		dispatcher.post(() -> {
			final U result = task.apply((T) v);
			if (next != null) {
				next.pushInternal(result);
			}
		}, priority);
	}

}
