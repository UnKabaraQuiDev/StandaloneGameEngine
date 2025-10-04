package lu.kbra.standalone.gameengine.impl.future;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TaskFuture<T, U> {

	public class TaskState<V> {

		private boolean started = false;
		private boolean ongoing = false;
		private boolean done = false;

		private V result;

		public boolean isStarted() {
			return started;
		}

		public boolean isOngoing() {
			return ongoing;
		}

		public boolean isDone() {
			return done;
		}

		public V getResult() {
			return result;
		}

		@Override
		public String toString() {
			return "TaskState [started=" + started + ", ongoing=" + ongoing + ", done=" + done + ", result=" + result
					+ "]";
		}

	}

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

	public TaskState<U> push() {
		final TaskState<U> state = new TaskState<>();
		state.started = true;
		first.pushInternal(null, state);
		return state;
	}

	@SuppressWarnings("unchecked")
	private void pushInternal(T v, TaskState state) {
		dispatcher.post(() -> {
			state.ongoing = true;
			final U result = task.apply((T) v);
			if (next != null) {
				next.pushInternal(result, state);
			} else {
				state.result = result;
				state.done = true;
				state.ongoing = false;
			}
		}, priority);
	}

}
