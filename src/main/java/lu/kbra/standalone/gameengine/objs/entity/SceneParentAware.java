package lu.kbra.standalone.gameengine.objs.entity;

import lu.kbra.standalone.gameengine.scene.Scene;

public interface SceneParentAware extends ParentAwareNode {

	default boolean hasSceneParent() {
		return this.getSceneParent() != null;
	}

	default Scene getSceneParent() {
		Object current = this.getParent();

		while (current != null) {
			if (current instanceof final Scene scene) {
				return scene;
			}

			if (!(current instanceof final ParentAwareNode pa)) {
				return null;
			}
			current = pa.getParent();
		}

		return null;
	}

}
