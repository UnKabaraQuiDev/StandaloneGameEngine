package lu.kbra.standalone.gameengine.impl.future;

import java.util.function.Supplier;

import lu.pcy113.pclib.pointer.prim.BooleanPointer;

public class YieldExecutionThrowable extends Throwable {

	protected boolean setTimeout = false;
	protected long timeoutNanos = 0;

	protected Supplier<Boolean> predicate;

	public YieldExecutionThrowable() {
	}

	public YieldExecutionThrowable(Supplier<Boolean> predicate) {
		this.predicate = predicate;
	}

	public YieldExecutionThrowable(BooleanPointer lock) {
		this.predicate = lock::get;
	}

	public YieldExecutionThrowable(long timeoutNanos) {
		this.timeoutNanos = timeoutNanos;
		this.setTimeout = true;
	}

	public boolean isSetTimeout() {
		return setTimeout;
	}

	public long getTimeoutNanos() {
		return timeoutNanos;
	}

	public boolean isSetPredicate() {
		return predicate != null;
	}

	public Supplier<Boolean> getPredicate() {
		return predicate;
	}

}
