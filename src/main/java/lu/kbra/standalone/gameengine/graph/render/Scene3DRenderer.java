package lu.kbra.standalone.gameengine.graph.render;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Gizmo;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.objs.entity.components.GizmoComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.InstanceEmitterComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.MeshComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.RenderComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.RenderConditionComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.SubEntitiesComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.TextEmitterComponent;
import lu.kbra.standalone.gameengine.objs.text.TextEmitter;
import lu.kbra.standalone.gameengine.scene.Scene3D;

public class Scene3DRenderer extends Renderer<GameEngine, Scene3D> {

	private MeshRenderer meshRenderer;
	private GizmoRenderer gizmoRenderer;
	private InstanceEmitterRenderer instanceEmitterRenderer;
	private TextEmitterRenderer textEmitterRenderer;

	public Scene3DRenderer() {
		super(Scene3D.class);
	}

	private static final Comparator<Entry<String, Entity>> COMPARATOR = (a, b) -> {
		return Float.compare(a.getValue().hasComponent(RenderComponent.class) ? a.getValue().getComponent(RenderComponent.class).getPriority() : 0,
				b.getValue().hasComponent(RenderComponent.class) ? b.getValue().getComponent(RenderComponent.class).getPriority() : 0);
	};

	private static final Comparator<Entity> COMPARATOR_ENTITY = (a, b) -> {
		return Float.compare(a.hasComponent(RenderComponent.class) ? a.getComponent(RenderComponent.class).getPriority() : 0, b.hasComponent(RenderComponent.class) ? b.getComponent(RenderComponent.class).getPriority() : 0);
	};

	@Override
	public void render_in(CacheManager cache, GameEngine ge, Scene3D scene) {
		meshRenderer = (MeshRenderer) cache.getRenderer(Mesh.class.getName());
		gizmoRenderer = (GizmoRenderer) cache.getRenderer(Gizmo.class.getName());
		instanceEmitterRenderer = (InstanceEmitterRenderer) cache.getRenderer(InstanceEmitter.class.getName());
		textEmitterRenderer = (TextEmitterRenderer) cache.getRenderer(TextEmitter.class.getName());

		LinkedHashMap<String, Entity> sortedMap = scene.getEntities().entrySet().stream().sorted(COMPARATOR).collect(LinkedHashMap::new, (linkedHashMap, entry) -> linkedHashMap.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
		scene.setEntities(sortedMap);

		Collection<Entity> ce = scene.getEntities().values();
		ce.forEach((e) -> {
			if (!e.isActive()) {
				return;
			}

			if (e.hasComponent(RenderConditionComponent.class) && !e.getComponent(RenderConditionComponent.class).get()) {
				return;
			}

			render(cache, scene, e);
		});
	}

	private void render(CacheManager cache, Scene3D scene, Entity e) {
		if (meshRenderer != null && e.hasComponent(MeshComponent.class)) {
			meshRenderer.render(cache, scene, (MeshComponent) e.getComponent(MeshComponent.class));
		}
		if (gizmoRenderer != null && e.hasComponent(GizmoComponent.class)) {
			gizmoRenderer.render(cache, scene, (GizmoComponent) e.getComponent(GizmoComponent.class));
		}
		if (instanceEmitterRenderer != null && e.hasComponent(InstanceEmitterComponent.class)) {
			instanceEmitterRenderer.render(cache, scene, (InstanceEmitterComponent) e.getComponent(InstanceEmitterComponent.class));
		}
		if (textEmitterRenderer != null && e.hasComponent(TextEmitterComponent.class)) {
			textEmitterRenderer.render(cache, scene, (TextEmitterComponent) e.getComponent(TextEmitterComponent.class));
		}

		if (e.hasComponent(SubEntitiesComponent.class)) {
			e.getComponent(SubEntitiesComponent.class).getEntities().sort(COMPARATOR_ENTITY);
			for (Entity en : e.getComponent(SubEntitiesComponent.class).getEntities()) {
				if (!en.isActive()) {
					return;
				}

				render(cache, scene, en);
			}
		}
	}

	@Override
	public void cleanup() {
		super.cleanup();
	}

}
