package lu.kbra.standalone.gameengine.scene;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;

public interface EntityContainer<B extends SceneEntity> extends Iterable<B> {

	<T extends B> T add(T e);

	<T extends B, O extends B> Optional<O> replace(O old, T new_);

	<T extends B, O extends B> Optional<O> replace(String oldId, T new_);

	<T extends B> Optional<T> remove(T e);

	<T extends B> T[] addAll(T... entities);

	<T extends B> boolean contains(T e);

	<T extends B> boolean contains(String e);

	<T extends B> boolean addAll(Collection<? extends T> c);

	int size();

	<T extends SceneEntity> T getEntity(String str);

	Stream<B> parallelStream();

	Stream<B> stream();

	@Override
	void forEach(Consumer<? super B> action);

	void flatForEach(Consumer<? super SceneEntity> action);

	default Stream<SceneEntity> flatStream() {
		return stream().flatMap(this::flatten);
	}

	default Stream<SceneEntity> flatParallelStream() {
		return parallelStream().flatMap(this::flatten);
	}

	default Stream<SceneEntity> flatten(SceneEntity entity) {
		if (!(entity instanceof EntityContainer<?> container))
			return Stream.of(entity);

		final EntityContainer<? extends SceneEntity> typed = (EntityContainer<? extends SceneEntity>) container;
		return Stream.concat(Stream.of(entity), typed.stream().flatMap(this::flatten));
	}

}
