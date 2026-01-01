package lu.kbra.standalone.gameengine.objs.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public interface ParentAware {

	void setParent(Object e);

	Object getParent();

	default boolean hasParent() {
		return this.getParent() != null;
	}

	default Deque<Object> getParents() {
		final Deque<Object> stack = new ArrayDeque<>();

		Object current = getParent();

		while (current instanceof ParentAware) {
			stack.push(current);
			current = ((ParentAware) current).getParent();
		}

		if (current != null) {
			stack.push(current);
		}

		return stack;
	}

}
