package lu.kbra.standalone.gameengine.graph.render;

import java.util.logging.Level;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Gizmo;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.objs.entity.components.GizmoComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.InstanceEmitterComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.MeshComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.TextEmitterComponent;
import lu.kbra.standalone.gameengine.objs.text.TextEmitter;
import lu.kbra.standalone.gameengine.scene.Scene2D;

public class Scene2DRenderer extends Renderer<GameEngine, Scene2D> {

	public Scene2DRenderer() {
		super(Scene2D.class);
	}

	@Override
	public void render_in(CacheManager cache, GameEngine engine, Scene2D scene) {
		GlobalLogger.log(Level.INFO, "Scene2D : " + scene.getId());

		MeshRenderer meshRenderer = (MeshRenderer) cache.getRenderer(Mesh.NAME);
		GizmoRenderer gizmoRenderer = (GizmoRenderer) cache.getRenderer(Gizmo.NAME);
		InstanceEmitterRenderer instanceEmitterRenderer = (InstanceEmitterRenderer) cache.getRenderer(InstanceEmitter.NAME);
		TextEmitterRenderer textEmitterRenderer = (TextEmitterRenderer) cache.getRenderer(TextEmitter.NAME);

		for (Entity e : scene.getEntities().values()) {
			if (!e.isActive())
				continue;

			Component c = null;
			if ((c = e.getComponent(MeshComponent.class)) != null) {
				meshRenderer.render(cache, scene, (MeshComponent) c);
			} else if ((c = e.getComponent(GizmoComponent.class)) != null) {
				gizmoRenderer.render(cache, scene, (GizmoComponent) c);
			} else if ((c = e.getComponent(InstanceEmitterComponent.class)) != null) {
				instanceEmitterRenderer.render(cache, scene, (InstanceEmitterComponent) c);
			} else if ((c = e.getComponent(TextEmitterComponent.class)) != null) {
				textEmitterRenderer.render(cache, scene, (TextEmitterComponent) c);
			}
		}
	}

}
