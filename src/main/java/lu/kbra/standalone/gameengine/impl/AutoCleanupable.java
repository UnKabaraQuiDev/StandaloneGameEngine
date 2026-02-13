package lu.kbra.standalone.gameengine.impl;

import java.lang.ref.Cleaner;
import java.util.Collections;
import java.util.Set;

public abstract class AutoCleanupable implements Cleanupable {

	private static final Set<GLObject> GL_RESOURCES = Collections.synchronizedSet(new WeakHashSet<>());
	private static final Set<ALObject> AL_RESOURCES = Collections.synchronizedSet(new WeakHashSet<>());

	private static final Cleaner CLEANER = Cleaner.create();

	public static Cleaner.Cleanable register(Cleanupable target, Runnable cleanupAction) {
		if (target instanceof GLObject glo) {
			GL_RESOURCES.add(glo);
		} else if (target instanceof ALObject alo) {
			AL_RESOURCES.add(alo);
		}
		return CLEANER.register(target, cleanupAction);
	}

	public static Cleaner.Cleanable register(Cleanupable target) {
		if (target instanceof GLObject glo) {
			GL_RESOURCES.add(glo);
		} else if (target instanceof ALObject alo) {
			AL_RESOURCES.add(alo);
		}
		return CLEANER.register(target, target::cleanup);
	}

	public static void cleanupGL() {
		GL_RESOURCES.forEach(c -> {
			try {
				c.cleanup();
			} catch (Exception ignored) {
			}
		});
		GL_RESOURCES.clear();
	}

	public static void cleanupAL() {
		AL_RESOURCES.forEach(c -> {
			try {
				c.cleanup();
			} catch (Exception ignored) {
			}
		});
		AL_RESOURCES.clear();
	}

	protected final Cleaner.Cleanable cleanable;

	public AutoCleanupable() {
		this.cleanable = register(this, this::cleanup);
	}

	public Cleaner.Cleanable getCleanable() {
		return cleanable;
	}

	@Override
	public void cleanup() {
		if (this instanceof GLObject glo) {
			GL_RESOURCES.remove(glo);
		} else if (this instanceof ALObject alo) {
			AL_RESOURCES.remove(alo);
		}
	}

	@Override
	public String toString() {
		return "AutoCleanupable@" + System.identityHashCode(this) + " [cleanable=" + cleanable + "]";
	}

}
