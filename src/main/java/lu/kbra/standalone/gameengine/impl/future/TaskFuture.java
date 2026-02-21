package lu.kbra.standalone.gameengine.impl.future;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.impl.ThrowingConsumer;
import lu.kbra.pclib.impl.ThrowingFunction;
import lu.kbra.pclib.impl.ThrowingRunnable;
import lu.kbra.pclib.impl.ThrowingSupplier;
import lu.kbra.pclib.pointer.prim.BooleanPointer;

public class TaskFuture<I, O> {

	public static final String STACK_TRACE_PROPERTY = TaskFuture.class.getSimpleName() + ".stack_trace";
	public static boolean STACK_TRACE = Boolean.getBoolean(STACK_TRACE_PROPERTY);

	public class TaskState<V> {

		private final BooleanPointer started = new BooleanPointer(false);
		private final BooleanPointer ongoing = new BooleanPointer(false);
		private final BooleanPointer done = new BooleanPointer(false);

		private V result;
		private Throwable stackTrace;

		public TaskState(final TaskFuture<?, ?> first) {
		}

		public boolean isStarted() {
			return this.started.get();
		}

		public boolean isOngoing() {
			return this.ongoing.get();
		}

		public boolean isDone() {
			return this.done.get();
		}

		public V getResult() {
			return this.result;
		}

		public V join() {
			this.started.waitForTrue();
			this.ongoing.waitForFalse();
			return this.result;
		}

		public V join(final long timeout) {
			this.started.waitForTrue();
			this.ongoing.waitForFalse(timeout);
			return this.result;
		}

		public Throwable getStackTrace() {
			return stackTrace;
		}

		@Override
		public String toString() {
			return "TaskState@" + System.identityHashCode(this) + " [started=" + started + ", ongoing=" + ongoing + ", done=" + done
					+ ", result=" + result + ", stackTrace=" + stackTrace + "]";
		}

	}

	protected static final boolean PARENT = false;
	protected static final boolean SIMPLE = true;

	protected TaskFuture<?, ?> first;
	protected Dispatcher dispatcher;
	protected ThrowingFunction<I, O, ? extends Throwable> task;
	protected int priority;
	protected TaskFuture<? extends O, ?> next;
	protected Throwable stackTrace = STACK_TRACE ? new Throwable().fillInStackTrace() : null;

	protected TaskFuture(final Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
		this.first = this;
	}

	public TaskFuture(final Dispatcher dispatcher, final ThrowingFunction<I, O, ? extends Throwable> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(final Dispatcher dispatcher, final ThrowingFunction<I, O, ? extends Throwable> task, final int priority) {
		this.dispatcher = dispatcher;
		this.task = task;
		this.priority = priority;
	}

	public TaskFuture(final Dispatcher dispatcher, final ThrowingSupplier<O, ? extends Throwable> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(final Dispatcher dispatcher, final ThrowingSupplier<O, ? extends Throwable> task, final int priority) {
		this.dispatcher = dispatcher;
		this.task = (v) -> task.get();
		this.priority = priority;
		this.first = this;
	}

	public TaskFuture(final Dispatcher dispatcher, final ThrowingRunnable<? extends Throwable> task) {
		this(dispatcher, (ThrowingSupplier<O, ? extends Throwable>) () -> {
			task.run();
			return null;
		}, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(final Dispatcher dispatcher, final ThrowingRunnable<? extends Throwable> task, final int priority) {
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

	public TaskFuture(final Dispatcher dispatcher, final Supplier<O> task) {
		this(dispatcher, task, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(final Dispatcher dispatcher, final Supplier<O> task, final int priority) {
		this.dispatcher = dispatcher;
		this.task = (v) -> task.get();
		this.priority = priority;
		this.first = this;
	}

	public TaskFuture(final Dispatcher dispatcher, final Runnable task) {
		this(dispatcher, (ThrowingSupplier<O, Throwable>) () -> {
			task.run();
			return null;
		}, Dispatcher.DEFAULT_PRIORITY);
	}

	public TaskFuture(final Dispatcher dispatcher, final Runnable task, final int priority) {
		this(dispatcher, (ThrowingSupplier<O, Throwable>) () -> {
			task.run();
			return null;
		}, priority);
	}

	public <N> TaskFuture<O, N> then(final Dispatcher nextDispatcher, final Supplier<N> function) {
		return this.then(nextDispatcher, (ThrowingFunction<O, N, Throwable>) (i) -> function.get(), this.priority + 1);
	}

	public <N> TaskFuture<O, N> then(final Dispatcher nextDispatcher, final ThrowingSupplier<N, Throwable> function) {
		return this.then(nextDispatcher, function, this.priority + 1);
	}

	public <N> TaskFuture<O, N> then(final Dispatcher nextDispatcher, final ThrowingSupplier<N, Throwable> function, final int priority) {
		final TaskFuture<O, N> nextFuture = new TaskFuture<>(nextDispatcher, function, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<O, N> then(final Dispatcher nextDispatcher, final Function<O, N> function) {
		return this.then(nextDispatcher, (ThrowingFunction<O, N, Throwable>) (i) -> function.apply(i), this.priority + 1);
	}

	public <N> TaskFuture<O, N> then(final Dispatcher nextDispatcher, final ThrowingFunction<O, N, Throwable> function) {
		return this.then(nextDispatcher, function, this.priority + 1);
	}

	public <N> TaskFuture<O, N> then(
			final Dispatcher nextDispatcher,
			final ThrowingFunction<O, N, Throwable> function,
			final int priority) {
		final TaskFuture<O, N> nextFuture = new TaskFuture<>(nextDispatcher, function, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <N> TaskFuture<O, Void> then(final Dispatcher nextDispatcher, final Consumer<O> function) {
		return this.then(nextDispatcher, (ThrowingConsumer<O, Throwable>) (i) -> function.accept(i), this.priority + 1);
	}

	public <N> TaskFuture<O, Void> then(final Dispatcher nextDispatcher, final Consumer<O> function, final int priority) {
		return this.then(nextDispatcher, (ThrowingConsumer<O, Throwable>) (i) -> function.accept(i), priority);
	}

	public TaskFuture<O, Void> then(final Dispatcher nextDispatcher, final ThrowingConsumer<O, Throwable> consumer) {
		return this.then(nextDispatcher, consumer, this.priority + 1);
	}

	public TaskFuture<O, Void> then(final Dispatcher nextDispatcher, final ThrowingConsumer<O, Throwable> consumer, final int priority) {
		final TaskFuture<O, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.accept(v);
			return null;
		}, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <P extends O> TaskFuture<P, Void> then(final Dispatcher nextDispatcher, final Runnable consumer) {
		return this.then(nextDispatcher, (ThrowingRunnable<Throwable>) () -> consumer.run(), this.priority + 1);
	}

	public <P extends O> TaskFuture<P, Void> then(final Dispatcher nextDispatcher, final Runnable consumer, final int priority) {
		return this.then(nextDispatcher, (ThrowingRunnable<Throwable>) () -> consumer.run(), priority);
	}

	public <P extends O> TaskFuture<P, Void> then(final Dispatcher nextDispatcher, final ThrowingRunnable<Throwable> consumer) {
		return this.then(nextDispatcher, consumer, this.priority + 1);
	}

	public <P extends O> TaskFuture<P, Void> then(
			final Dispatcher nextDispatcher,
			final ThrowingRunnable<Throwable> consumer,
			final int priority) {
		final TaskFuture<P, Void> nextFuture = new TaskFuture<>(nextDispatcher, (v) -> {
			consumer.run();
			return null;
		}, priority);
		nextFuture.first = this.first;
		this.next = nextFuture;
		return nextFuture;
	}

	public <P extends O, N> TaskFuture<P, N> then(final Dispatcher nextDispatcher, final TaskFuture<P, N> nextFuture) {
		return this.then(nextDispatcher, nextFuture, this.priority + 1);
	}

	public <P extends O, N> TaskFuture<P, N> then(final Dispatcher nextDispatcher, final TaskFuture<P, N> nextFuture, final int priority) {
		nextFuture.first = this.first;
		nextFuture.dispatcher = nextDispatcher;
		this.next = nextFuture;
		return nextFuture;
	}

	public <T extends TaskFuture<P, N>, P extends O, N> T then(final T nextFuture) {
		return this.then(nextFuture, this.priority + 1);
	}

	public <T extends TaskFuture<P, N>, P extends O, N> T then(final T nextFuture, final int priority) {
		this.next = (TaskFuture<O, ?>) nextFuture.first;
		nextFuture.first = this.first;
		return nextFuture;
	}

	public TaskState<O> push() {
		final TaskState<O> state = new TaskState<>(this.first);
		state.started.set(true);
		this.first.pushInternal(null, state);
		return state;
	}

	@SuppressWarnings("unchecked")
	private void pushInternal(final Object v, final TaskState state) {
		this.dispatcher.post(() -> {
			state.ongoing.set(true);
			O result = null;
			try {
				result = this.task.apply((I) v);
				if (this.next != null) {
					this.next.pushInternal(result, state);
				} else {
					state.result = result;
					state.done.set(true);
					state.ongoing.set(false);
				}
			} catch (final SkipThen st) {
				TaskFuture<?, ?> current = this.next;
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
			} catch (final Throwable e) {
				if (e instanceof final YieldExecutionThrowable yield) {
					throw yield;
				}
				if (STACK_TRACE) {
					e.addSuppressed(this.stackTrace);
				}
				throw new RuntimeException(e);
			} finally {
				state.ongoing.set(false);
			}
		}, this.priority);
	}

	private class ExecTaskState<V> {

		protected V result;

	}

	public O exec() {
		final ExecTaskState<O> state = new ExecTaskState<>();
		this.first.execInternal(null, state);
		return state.result;
	}

	private void execInternal(final Object v, final ExecTaskState state) {
		O result = null;
		try {
			result = this.task.apply((I) v);
			if (this.next != null) {
				this.next.execInternal(result, state);
			} else {
				state.result = result;
			}
		} catch (final SkipThen st) {
			TaskFuture<?, ?> current = this.next;
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
		} catch (final Throwable e) {
			if (STACK_TRACE) {
				e.addSuppressed(this.stackTrace);
			}
			throw new RuntimeException(e);
		}
	}

}
