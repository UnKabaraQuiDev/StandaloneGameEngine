package lu.kbra.standalone.gameengine.scene;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import lu.kbra.standalone.gameengine.impl.IdOwner;
import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;

public interface EntityContainer<B extends SceneEntity> extends Iterable<B>, IdOwner {

	<T extends B> T add(T e);

	<T extends B, O extends B> Optional<O> replace(O old, T new_);

	<T extends B, O extends B> Optional<O> replace(String oldId, T new_);

	<T extends B> Optional<T> remove(T e);

	<T extends B> T[] addAll(T... entities);

	<T extends B> boolean contains(T e);

	<T extends B> boolean contains(String e);

	<T extends B> boolean addAll(Collection<? extends T> c);

	int size();

	<T extends B> T getEntity(String str);

	Stream<B> parallelStream();

	Stream<B> stream();

	@Override
	void forEach(Consumer<? super B> action);

	void flatForEach(Consumer<? super B> action);

	default Stream<B> flatStream() {
		return this.stream().flatMap(this::flatten);
	}

	default Stream<B> flatParallelStream() {
		return this.parallelStream().flatMap(this::flatten);
	}

	default Stream<B> flatten(final B entity) {
		if (!(entity instanceof final EntityContainer<?> container)) {
			return Stream.of(entity);
		}

		final EntityContainer<? extends B> typed = (EntityContainer<? extends B>) container;
		return Stream.concat(Stream.of(entity), typed.stream().flatMap(this::flatten));
	}

}
