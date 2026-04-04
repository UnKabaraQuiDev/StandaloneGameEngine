package lu.kbra.standalone.gameengine.impl;

import java.lang.ref.Cleaner;
import java.util.Set;

import lu.kbra.pclib.datastructure.set.WeakHashSet;

public abstract class AutoCleanupable implements Cleanupable {

	private static final Set<GLObject> GL_RESOURCES = new WeakHashSet<>();
	private static final Set<ALObject> AL_RESOURCES = new WeakHashSet<>();

	private static volatile boolean GLOBAL_GL_CLEANUP = false;
	private static volatile boolean GLOBAL_AL_CLEANUP = false;

	private static final Cleaner CLEANER = Cleaner.create();

	public static Cleaner.Cleanable register(Cleanupable target, Runnable cleanupAction) {
		if (target instanceof GLObject glo)
			synchronized (GL_RESOURCES) {
				GL_RESOURCES.add(glo);
			}
		else if (target instanceof ALObject alo)
			synchronized (AL_RESOURCES) {
				AL_RESOURCES.add(alo);
			}
		return CLEANER.register(target, cleanupAction);
	}

	public static Cleaner.Cleanable register(Cleanupable target) {
		if (target instanceof GLObject glo)
			synchronized (GL_RESOURCES) {
				GL_RESOURCES.add(glo);
			}
		else if (target instanceof ALObject alo)
			synchronized (AL_RESOURCES) {
				AL_RESOURCES.add(alo);
			}
		return CLEANER.register(target, target::cleanup);
	}

	public static void cleanupGL() {
		synchronized (GL_RESOURCES) {
			GLOBAL_GL_CLEANUP = true;
			GL_RESOURCES.forEach(c -> {
				try {
					c.cleanup();
				} catch (Exception ignored) {
				}
			});
			GL_RESOURCES.clear();
		}
	}

	public static void cleanupAL() {
		synchronized (AL_RESOURCES) {
			GLOBAL_AL_CLEANUP = true;
			AL_RESOURCES.forEach(c -> {
				try {
					c.cleanup();
				} catch (Exception ignored) {
				}
			});
			AL_RESOURCES.clear();
		}
	}

	protected final Cleaner.Cleanable cleanable;

	public AutoCleanupable() {
		cleanable = register(this, this::cleanup);
	}

	public Cleaner.Cleanable getCleanable() {
		return cleanable;
	}

	@Override
	public void cleanup() {
		if (this instanceof GLObject glo && !GLOBAL_GL_CLEANUP)
			synchronized (GL_RESOURCES) {
				GL_RESOURCES.remove(glo);
			}
		else if (this instanceof ALObject alo && !GLOBAL_AL_CLEANUP)
			synchronized (AL_RESOURCES) {
				AL_RESOURCES.remove(alo);
			}
	}

	@Override
	public String toString() {
		return "AutoCleanupable@" + System.identityHashCode(this) + " [cleanable=" + cleanable + "]";
	}

}
