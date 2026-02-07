package lu.kbra.standalone.gameengine.impl.future;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import lu.kbra.pclib.impl.ThrowingRunnable;
import lu.kbra.pclib.logger.GlobalLogger;

public class ScheduledTask implements Runnable, Delayed {

//	public static final int DEFAULT_PRIORITY = 100;
	public static final long RETRY_DELAY_NANOS = TimeUnit.MILLISECONDS.toNanos(1);

	private final ThrowingRunnable<YieldExecutionThrowable> task;
	private final int priority;
	private final String sourceString;
	private volatile boolean ran;
	private volatile long nextTry;
	private volatile long nextTryDelay;
	private volatile Supplier<Boolean> predicate;

	public ScheduledTask(ThrowingRunnable<YieldExecutionThrowable> task, int priority, String source) {
		this.task = task;
		this.priority = priority;
		this.sourceString = source;
	}

	public ScheduledTask(ThrowingRunnable<YieldExecutionThrowable> task, int priority) {
		this.task = task;
		this.priority = priority;
		this.sourceString = task.toString();
	}

//	@Override
//	public int compareTo(ScheduledTask o) {
//		return Integer.compare(o.priority, this.priority); // higher first
//	}
	@Override
	public long getDelay(TimeUnit unit) {
		long delay = nextTry - System.nanoTime();
		return unit.convert(delay, TimeUnit.NANOSECONDS);
	}

	@Override
	public int compareTo(Delayed other) {
		if (other == this)
			return 0;
		if (other instanceof ScheduledTask o) {
			int cmp = Long.compare(this.nextTry, o.nextTry); // soonest first
			if (cmp == 0) {
				return Integer.compare(o.priority, this.priority); // higher priority first
			}
			return cmp;
		}
		return Long.compare(getDelay(TimeUnit.NANOSECONDS), other.getDelay(TimeUnit.NANOSECONDS));
	}

	@Override
	public void run() {
//		System.err.println(Thread.currentThread().getName() + ": " + (predicate == null ? "null" : predicate.get()));
		if (!isReady()) {
			nextTry = nextTryDelay;
			ran = false;
			return;
		}
		try {
			task.run();
			ran = true;
		} catch (YieldExecutionThrowable e) {
			nextTryDelay = (e.isSetTimeout() ? e.getTimeoutNanos() : RETRY_DELAY_NANOS);
			nextTry = System.nanoTime() + nextTryDelay;
			GlobalLogger.info("Task yielded, retrying in " + (float) (nextTry - System.nanoTime()) / 1e6 + "ms");
			predicate = e.getPredicate();
			ran = false;
		}
	}

	public long getNextTry() {
		return nextTry;
	}

	public void setNextTry(long nextTry) {
		this.nextTry = nextTry;
	}

	public boolean isReady() {
		return predicate == null ? this.nextTry <= System.nanoTime() : predicate.get();
	}

	public int getPriority() {
		return priority;
	}

	public String getSourceString() {
		return sourceString;
	}

	public boolean wasRan() {
		return ran;
	}

	public void setRan(boolean ran) {
		this.ran = ran;
	}

}