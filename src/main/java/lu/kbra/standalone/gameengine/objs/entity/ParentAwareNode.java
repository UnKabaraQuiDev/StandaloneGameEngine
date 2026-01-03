package lu.kbra.standalone.gameengine.objs.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Optional;

non-sealed public interface ParentAwareNode extends ParentAwareComponent {

	<T extends ParentAwareComponent> void setParent(T e);

	ParentAwareComponent getParent();

	default <T> Optional<? extends T> getLastParentMatching(Class<T> type) {
		Iterator<ParentAwareComponent> it = getParents().descendingIterator();
		while (it.hasNext()) {
			ParentAwareComponent parent = it.next();
			if (type.isInstance(parent)) {
				return Optional.of(type.cast(parent));
			}
		}
		return null;
	}

	default <T> Optional<? extends T> getFirstParentMatching(Class<T> type) {
		for (ParentAwareComponent parent : getParents()) {
			if (type.isInstance(parent)) {
				return Optional.of(type.cast(parent));
			}
		}
		return Optional.empty();
	}

	default ParentAwareComponent getFirstParent() {
		ParentAwareComponent current = getParent();

		while (current instanceof ParentAwareNode pan && pan.hasParent()) {
			current = pan.getParent();
		}

		return current;
	}

	default boolean hasParent() {
		return this.getParent() != null;
	}

	default Deque<ParentAwareComponent> getParents() {
		final Deque<ParentAwareComponent> stack = new ArrayDeque<>();

		ParentAwareComponent current = getParent();

		while (current != null && current instanceof ParentAwareNode pan) {
			stack.push(current);
			current = pan.getParent();
		}

		return stack;
	}

}
