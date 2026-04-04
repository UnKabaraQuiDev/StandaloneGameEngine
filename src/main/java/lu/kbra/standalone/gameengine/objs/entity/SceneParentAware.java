package lu.kbra.standalone.gameengine.objs.entity;

import java.util.Optional;

import lu.kbra.standalone.gameengine.scene.Scene;

public interface SceneParentAware extends ParentAwareNode {

	//	default boolean hasSceneParent() {
	//		return this.getSceneParent() != null;
	//	}

	default Optional<Scene> getSceneParent() {
		Object current = getParent();

		while (current != null) {
			if (current instanceof final Scene scene)
				return Optional.of(scene);

			if (!(current instanceof final ParentAwareNode pa))
				return null;
			current = pa.getParent();
		}

		return Optional.empty();
	}

}
