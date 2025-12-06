package lu.kbra.standalone.gameengine.impl.future;

import java.util.function.Consumer;
import java.util.function.Function;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.impl.ThrowingConsumer;
import lu.pcy113.pclib.impl.ThrowingFunction;
import lu.pcy113.pclib.impl.ThrowingRunnable;
import lu.pcy113.pclib.impl.ThrowingSupplier;
import lu.pcy113.pclib.pointer.prim.BooleanPointer;

public class TaskFuture<I, O> {

	public class TaskState<V> {

		private final BooleanPointer started = new BooleanPointer(false);
		private final BooleanPointer ongoing = new BooleanPointer(false);
		private final BooleanPointer done = new BooleanPointer(false);

		private V result;
		private String source;

		public TaskState(TaskFuture<?, ?> first) {
			this.source = first.currentSource;
		}

		public boolean isStarted() {
			return started.get();
		}

		public boolean isOngoing() {
			return ongoing.get();
		}

		public boolean isDone() {
			return done.get();
		}

		public V getResult() {
			return result;
		}

		public V join() {
			started.waitForTrue();
			ongoing.waitForFalse();
			return result;
		}

		public V join(long timeout) {
			started.waitForTrue();
			ongoing.waitForFalse(timeout);
			return result;
		}

		@Override
		public String toString() {
			return "TaskState@" + Integer.toHexString(System.identityHashCode(this)) + " [started="
					+ this.started.toSafeString() + ", ongoing=" + this.ongoing.toSafeString() + ", done="
					+ this.done.toSafeString() + ", result=" + this.result + ", source=" + this.source + "]";
		}

	}

	protected static final boolean PARENT = false;
	protected static final boolean SIMPLE = true;

	private TaskFuture<?, ?> first;
	private Dispatcher dispatcher;
	private final ThrowingFunction<I, O, Throwable> task;
	private final int priority;
	private TaskFuture<O, ?> next;
	private String currentSource;

	protected TaskFuture(Dispatcher dispatcher, ThrowingFunction<I, O, Throwable> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	protected TaskFuture(Dispatcher dispatcher, ThrowingFunction<I, O, Throwable> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = task;
		this.priority = priority;
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingSupplier<O, Throwable> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingSupplier<O, Throwable> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = (v) -> task.get();
		this.priority = priority;
		this.first = this;
		this.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingRunnable<Throwable> task) {
		this(dispatcher, () -> {
			task.run();
			return null;
		}, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingRunnable<Throwable> task, int priority) {
		this(dispatcher, () -> {
			task.run();
			return null;
		}, priority);
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, Function<O, N> function) {
		return then(nextDispatcher, (ThrowingFunction<O, N, Throwable>) (i) -> function.apply(i), 0);
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, ThrowingFunction<O, N, Throwable> function) {
		return then(nextDispatcher, function, 0);
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, ThrowingFunction<O, N, Throwable> function,
			int priority) {
		final TaskFuture<O, N> nextFuture = new TaskFuture<O, N>(nextDispatcher, function, priority);
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<O, Void> then(Dispatcher nextDispatcher, Consumer<O> function) {
		return then(nextDispatcher, (ThrowingConsumer<O, Throwable>) (i) -> function.accept(i), 0);
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ThrowingConsumer<O, Throwable> consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ThrowingConsumer<O, Throwable> consumer, int priority) {
		final TaskFuture<O, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.accept(v);
			return null;
		}, priority);
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, Runnable consumer) {
		return then(nextDispatcher, (ThrowingRunnable<Throwable>) () -> consumer.run(), 0);
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ThrowingRunnable<Throwable> consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public TaskFuture<O, Void> then(Dispatcher nextDispatcher, ThrowingRunnable<Throwable> consumer, int priority) {
		final TaskFuture<O, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.run();
			return null;
		}, priority);
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, TaskFuture<O, N> nextFuture) {
		return then(nextDispatcher, nextFuture, 0);
	}

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, TaskFuture<O, N> nextFuture, int priority) {
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
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
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		nextFuture.first = this.first;
		return nextFuture;
	}

	public TaskState<O> push() {
		final TaskState<O> state = new TaskState<>(first);
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
					state.done.set(true);
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
					state.done.set(true);
					state.ongoing.set(false);
				}
			} catch (Throwable e) {
				throw new RuntimeException(e);
			} finally {
				state.ongoing.set(false);
			}
		}, priority, currentSource);
	}

}
