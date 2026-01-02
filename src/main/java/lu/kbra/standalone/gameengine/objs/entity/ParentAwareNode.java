package lu.kbra.standalone.gameengine.objs.entity;

import java.util.ArrayDeque;
import java.util.Deque;

non-sealed public interface ParentAwareNode extends ParentAwareComponent {

	<T extends ParentAwareComponent> void setParent(T e);

	ParentAwareComponent getParent();

	default boolean hasParent() {
		return this.getParent() != null;
	}

	default Deque<Object> getParents() {
		final Deque<Object> stack = new ArrayDeque<>();

		Object current = getParent();

		while (current instanceof ParentAwareNode) {
			stack.push(current);
			current = ((ParentAwareNode) current).getParent();
		}

		if (current != null) {
			stack.push(current);
		}

		return stack;
	}

}
