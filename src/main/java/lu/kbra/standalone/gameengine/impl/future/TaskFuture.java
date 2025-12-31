package lu.kbra.standalone.gameengine.impl.future;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
			return "TaskState@" + Integer.toHexString(System.identityHashCode(this)) + " [started=" + this.started.toSafeString()
					+ ", ongoing=" + this.ongoing.toSafeString() + ", done=" + this.done.toSafeString() + ", result=" + this.result
					+ ", source=" + this.source + "]";
		}

	}

	protected static final boolean PARENT = false;
	protected static final boolean SIMPLE = true;

	protected TaskFuture<?, ?> first;
	protected Dispatcher dispatcher;
	protected ThrowingFunction<I, O, ? extends Throwable> task;
	protected int priority;
	protected TaskFuture<? extends O, ?> next;
	protected String currentSource;

	protected TaskFuture(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
		this.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		this.first = this;
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingFunction<I, O, ? extends Throwable> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingFunction<I, O, ? extends Throwable> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = task;
		this.priority = priority;
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingSupplier<O, ? extends Throwable> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingSupplier<O, ? extends Throwable> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = (v) -> task.get();
		this.priority = priority;
		this.first = this;
		this.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingRunnable<? extends Throwable> task) {
		this(dispatcher, (ThrowingSupplier<O, ? extends Throwable>) () -> {
			task.run();
			return null;
		}, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, ThrowingRunnable<? extends Throwable> task, int priority) {
		this(dispatcher, (ThrowingSupplier<O, ? extends Throwable>) () -> {
			task.run();
			return null;
		}, priority);
	}

//	protected TaskFuture(Dispatcher dispatcher, Function<I, O> task) {
//		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
//	}
//
//	protected TaskFuture(Dispatcher dispatcher, Function<I, O> task, int priority) {
//		this.dispatcher = dispatcher;
//		this.task = task;
//		this.priority = priority;
//	}

	public TaskFuture(Dispatcher dispatcher, Supplier<O> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, Supplier<O> task, int priority) {
		this.dispatcher = dispatcher;
		this.task = (v) -> task.get();
		this.priority = priority;
		this.first = this;
		this.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
	}

	public TaskFuture(Dispatcher dispatcher, Runnable task) {
		this(dispatcher, (ThrowingSupplier<O, Throwable>) () -> {
			task.run();
			return null;
		}, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(Dispatcher dispatcher, Runnable task, int priority) {
		this(dispatcher, (ThrowingSupplier<O, Throwable>) () -> {
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

	public <N> TaskFuture<O, N> then(Dispatcher nextDispatcher, ThrowingFunction<O, N, Throwable> function, int priority) {
		final TaskFuture<O, N> nextFuture = new TaskFuture<O, N>(nextDispatcher, function, priority);
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<O, Void> then(Dispatcher nextDispatcher, Consumer<O> function) {
		return then(nextDispatcher, (ThrowingConsumer<O, Throwable>) (i) -> function.accept(i), 0);
	}

	public <N> TaskFuture<O, Void> then(Dispatcher nextDispatcher, Consumer<O> function, int priority) {
		return then(nextDispatcher, (ThrowingConsumer<O, Throwable>) (i) -> function.accept(i), priority);
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

	public <P extends O> TaskFuture<P, Void> then(Dispatcher nextDispatcher, Runnable consumer) {
		return then(nextDispatcher, (ThrowingRunnable<Throwable>) () -> consumer.run(), 0);
	}

	public <P extends O> TaskFuture<P, Void> then(Dispatcher nextDispatcher, Runnable consumer, int priority) {
		return then(nextDispatcher, (ThrowingRunnable<Throwable>) () -> consumer.run(), priority);
	}

	public <P extends O> TaskFuture<P, Void> then(Dispatcher nextDispatcher, ThrowingRunnable<Throwable> consumer) {
		return then(nextDispatcher, consumer, 0);
	}

	public <P extends O> TaskFuture<P, Void> then(Dispatcher nextDispatcher, ThrowingRunnable<Throwable> consumer, int priority) {
		final TaskFuture<P, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.run();
			return null;
		}, priority);
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <P extends O, N> TaskFuture<P, N> then(Dispatcher nextDispatcher, TaskFuture<P, N> nextFuture) {
		return then(nextDispatcher, nextFuture, 0);
	}

	public <P extends O, N> TaskFuture<P, N> then(Dispatcher nextDispatcher, TaskFuture<P, N> nextFuture, int priority) {
		nextFuture.currentSource = PCUtils.getCallerClassName(PARENT, SIMPLE, TaskFuture.class);
		nextFuture.first = this.first;
		nextFuture.dispatcher = nextDispatcher;
		this.next = nextFuture;
		return nextFuture;
	}

	public <T extends TaskFuture<P, N>, P extends O, N> T then(T nextFuture) {
		return then(nextFuture, 0);
	}

	public <T extends TaskFuture<P, N>, P extends O, N> T then(T nextFuture, int priority) {
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
				throw new RuntimeException(state.source, e);
			} finally {
				state.ongoing.set(false);
			}
		}, priority, currentSource);
	}

	private class ExecTaskState<V> {

		protected V result;

	}

	public O exec() {
		final ExecTaskState<O> state = new ExecTaskState<>();
		first.execInternal(null, state);
		return state.result;
	}

	private void execInternal(Object v, ExecTaskState state) {
		O result = null;
		try {
			result = task.apply((I) v);
			if (next != null) {
				next.execInternal(result, state);
			} else {
				state.result = result;
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
				current.next.execInternal(st.getObj(), state);
			} else {
				state.result = st.getObj();
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
