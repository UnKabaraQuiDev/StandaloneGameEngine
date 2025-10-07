package lu.kbra.standalone.gameengine.impl.future;

import lu.pcy113.pclib.impl.ExceptionConsumer;
import lu.pcy113.pclib.impl.ExceptionFunction;
import lu.pcy113.pclib.impl.ExceptionRunnable;
import lu.pcy113.pclib.impl.ExceptionSupplier;

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
	private final ExceptionFunction<T, U> task;
	private final int priority;
	private TaskFuture<U, ?> next;

	protected TaskFuture(Dispatcher dispatcher, ExceptionFunction<T, U> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	protected TaskFuture(Dispatcher dispatcher, ExceptionFunction<T, U> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = task;
		this.priority = priority;
		this.first = this;
	}

	public TaskFuture(Dispatcher dispatcher, ExceptionSupplier<U> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ExceptionSupplier<U> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = (v) -> task.get();
		this.priority = priority;
		this.first = this;
	}

	public TaskFuture(Dispatcher dispatcher, ExceptionRunnable task) {
		this(dispatcher, () -> {
			task.run();
			return null;
		}, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ExceptionRunnable task, int priority) {
		this(dispatcher, () -> {
			task.run();
			return null;
		}, priority);
	}

	public <V> TaskFuture<U, V> then(Dispatcher nextDispatcher, ExceptionFunction<U, V> function) {
		return then(nextDispatcher, function, 0);
	}

	public <V> TaskFuture<U, V> then(Dispatcher nextDispatcher, ExceptionFunction<U, V> function, int priority) {
		TaskFuture<U, V> nextFuture = new TaskFuture<U, V>(nextDispatcher, function, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public TaskFuture<U, Void> then(Dispatcher nextDispatcher, ExceptionConsumer<U> consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public TaskFuture<U, Void> then(Dispatcher nextDispatcher, ExceptionConsumer<U> consumer, int priority) {
		TaskFuture<U, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.accept(v);
			return null;
		}, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public TaskFuture<U, Void> then(Dispatcher nextDispatcher, ExceptionRunnable consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public TaskFuture<U, Void> then(Dispatcher nextDispatcher, ExceptionRunnable consumer, int priority) {
		TaskFuture<U, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.run();
			return null;
		}, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<U, N> then(Dispatcher nextDispatcher, TaskFuture<U, N> nextFuture) {
		return then(nextDispatcher, nextFuture, 0);
	}

	public <N> TaskFuture<U, N> then(Dispatcher nextDispatcher, TaskFuture<U, N> nextFuture, int priority) {
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
	private void pushInternal(Object v, TaskState state) {
		dispatcher.post(() -> {
			state.ongoing = true;
			U result = null;
			try {
				result = task.apply((T) v);
				if (next != null) {
					next.pushInternal(result, state);
				} else {
					state.result = result;
					state.done = true;
					state.ongoing = false;
				}
			} catch (SkipThen st) {
				TaskFuture<?, ?> current = next;
				int remaining = st.getCount();

				while (current != null && remaining > 1) {
					current = current.next;
					remaining--;
				}

				if (current != null && current.next != null) {
					current.next.pushInternal(st.getObj(), state);
				} else {
					state.result = st.getObj();
					state.done = true;
					state.ongoing = false;
				}
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		}, priority);
	}

}
