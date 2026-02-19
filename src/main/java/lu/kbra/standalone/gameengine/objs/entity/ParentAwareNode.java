package lu.kbra.standalone.gameengine.objs.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Optional;

non-sealed public interface ParentAwareNode extends ParentAwareComponent {

	<T extends ParentAwareComponent> void setParent(T e);

	ParentAwareComponent getParent();

	default <T> Optional<? extends T> getLastParentMatching(final Class<T> type) {
		return this.getLastParentMatching(type, false);
	}

	default <T> Optional<? extends T> getLastParentMatching(final Class<T> type, final boolean includeSelf) {
		final Iterator<ParentAwareComponent> it = this.getParents(includeSelf).descendingIterator();
		while (it.hasNext()) {
			final ParentAwareComponent parent = it.next();
			if (type.isInstance(parent)) {
				return Optional.of(type.cast(parent));
			}
		}
		return Optional.empty();
	}

	default <T> Optional<? extends T> getFirstParentMatching(final Class<T> type) {
		return this.getFirstParentMatching(type, false);
	}

	default <T> Optional<? extends T> getFirstParentMatching(final Class<T> type, final boolean includeSelf) {
		for (final ParentAwareComponent parent : this.getParents(includeSelf)) {
			if (type.isInstance(parent)) {
				return Optional.of(type.cast(parent));
			}
		}
		return Optional.empty();
	}

	default Deque<ParentAwareComponent> getParents(final boolean includeSelf) {
		final Deque<ParentAwareComponent> stack = new ArrayDeque<>();

		ParentAwareComponent current = this;

		while (current != null && current instanceof final ParentAwareNode pan) {
			stack.push(current);
			current = pan.getParent();
		}

		return stack;
	}

	default ParentAwareComponent getFirstParent() {
		ParentAwareComponent current = this.getParent();

		while (current instanceof final ParentAwareNode pan && pan.hasParent()) {
			current = pan.getParent();
		}

		return current;
	}

	default boolean hasParent() {
		return this.getParent() != null;
	}

	default Deque<ParentAwareComponent> getParents() {
		return this.getParents(false);
	}

}
