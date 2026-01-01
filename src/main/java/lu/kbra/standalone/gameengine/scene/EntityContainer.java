package lu.kbra.standalone.gameengine.scene;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import lu.kbra.standalone.gameengine.objs.entity.SceneEntity;

public interface EntityContainer<B extends SceneEntity> extends Iterable<B> {

	<T extends B> T add(T e);

	<T extends B, O extends B> Optional<O> replace(O old, T new_);

	<T extends B> Optional<T> remove(T e);

	<T extends B> T[] addAll(T... entities);

	<T extends B> boolean contains(T e);

	<T extends B> boolean contains(String e);

	<T extends B> boolean addAll(Collection<? extends T> c);

	int size();

	<T extends SceneEntity> T getEntity(String str);

	Stream<B> parallelStream();

	Stream<B> stream();

}
