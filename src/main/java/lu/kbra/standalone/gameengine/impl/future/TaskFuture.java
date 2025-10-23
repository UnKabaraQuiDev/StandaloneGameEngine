package lu.kbra.standalone.gameengine.impl.future;

import lu.pcy113.pclib.impl.ExceptionConsumer;
import lu.pcy113.pclib.impl.ExceptionFunction;
import lu.pcy113.pclib.impl.ExceptionRunnable;
import lu.pcy113.pclib.impl.ExceptionSupplier;
import lu.pcy113.pclib.pointer.prim.BooleanPointer;

public class TaskFuture<I, O> {

	public class TaskState<V> {

		private BooleanPointer started = new BooleanPointer(false);
		private BooleanPointer ongoing = new BooleanPointer(false);
		private boolean done = false;

		private V result;

		public boolean isStarted() {
			return started.get();
		}

		public boolean isOngoing() {
			return ongoing.get();
		}

		public boolean isDone() {
			return done;
		}

		public V getResult() {
			return result;
		}

		void setDone() {
			ongoing.set(false);
		}

		public void join() {
			ongoing.waitForTrue();
			ongoing.waitForFalse();
		}

		public void join(long timeout) {
			ongoing.waitForTrue();
			ongoing.waitForFalse(timeout);
		}

		@Override
		public String toString() {
			return "TaskState [started=" + started + ", ongoing=" + ongoing + ", done=" + done + ", result=" + result + "]";
		}

	}

	private TaskFuture<?, ?> first;
	private Dispatcher dispatcher;
	private final ExceptionFunction<I, O> task;
	private final int priority;
	private TaskFuture<O, ?> next;

	protected TaskFuture(Dispatcher dispatcher, ExceptionFunction<I, O> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	protected TaskFuture(Dispatcher dispatcher, ExceptionFunction<I, O> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = task;
		this.priority = priority;
	}

	public TaskFuture(Dispatcher dispatcher, ExceptionSupplier<O> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ExceptionSupplier<O> task, int priority) {
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

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, ExceptionFunction<O, N> function) {
		return then(nextDispatcher, function, 0);
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, ExceptionFunction<O, N> function, int priority) {
		TaskFuture<O, N> nextFuture = new TaskFuture<O, N>(nextDispatcher, function, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ExceptionConsumer<O> consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ExceptionConsumer<O> consumer, int priority) {
		TaskFuture<O, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.accept(v);
			return null;
		}, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ExceptionRunnable consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ExceptionRunnable consumer, int priority) {
		TaskFuture<O, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.run();
			return null;
		}, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, TaskFuture<O, N> nextFuture) {
		return then(nextDispatcher, nextFuture, 0);
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, TaskFuture<O, N> nextFuture, int priority) {
		nextFuture.first = this.first;
		nextFuture.dispatcher = nextDispatcher;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<O, N> then(TaskFuture<O, N> nextFuture) {
		return then(nextFuture, 0);
	}

	public <N> TaskFuture<O, N> then(TaskFuture<O, N> nextFuture, int priority) {
		this.next = (TaskFuture<O, ?>) nextFuture.first;
		nextFuture.first = this.first;
		return nextFuture;
	}

	public TaskState<O> push() {
		final TaskState<O> state = new TaskState<>();
		state.started.set(true);
		first.pushInternal(null, state);
		return state;
	}

	@SuppressWarnings("unchecked")
	private void pushInternal(Object v, TaskState state) {
		dispatcher.post(() -> {
			state.ongoing.set(true);
			O result = null;
			try {
				result = task.apply((I) v);
				if (next != null) {
					next.pushInternal(result, state);
				} else {
					state.result = result;
					state.done = true;
					state.ongoing.set(false);
				}
			} catch (SkipThen st) {
				TaskFuture<?, ?> current = next;
				int remaining = st.getCount();

				while (current != null && remaining > 1) {
					current = current.next;
					remaining--;
				}

				if (current != null && current.next != null) {
					if (st.getNext() != null) {
						final TaskFuture tmp = current.next;
						current.next = st.getNext();
						st.getNext().next = tmp;
					}
					current.next.pushInternal(st.getObj(), state);
				} else {
					state.result = st.getObj();
					state.done = true;
					state.ongoing.set(false);
				}
			} catch (Throwable e) {
				throw new RuntimeException(e);
			} finally {
				state.ongoing.set(false);
			}
		}, priority);
	}

}
