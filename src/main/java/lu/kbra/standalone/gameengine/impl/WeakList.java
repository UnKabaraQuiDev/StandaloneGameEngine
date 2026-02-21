package lu.kbra.standalone.gameengine.impl;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

public interface WeakList<T> extends Iterable<T> /* extends List<T> */ {

	void forEach(final Consumer<? super T> action);

	Iterator<T> iterator();

	boolean isEmpty();

	void clear();

	int size();

	boolean remove(final T value);

	void add(final T value);

	Optional<T> optGet(final int index);

	T get(final int index);

}
