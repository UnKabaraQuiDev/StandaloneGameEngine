package lu.kbra.standalone.gameengine.graph.render;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
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
	private InstanceEmitterRenderer instanceEmitterRenderer;
	private TextEmitterRenderer textEmitterRenderer;

	public Scene3DRenderer() {
		super(Scene3D.class);
	}

	public static final Comparator<Entry<String, Entity>> PRIORITY_COMPARATOR = (a, b) -> {
		return Float
				.compare(
						a.getValue().hasComponentMatching(RenderComponent.class)
								? a.getValue().getComponent(RenderComponent.class).getPriority()
								: 0,
						b.getValue().hasComponentMatching(RenderComponent.class)
								? b.getValue().getComponent(RenderComponent.class).getPriority()
								: 0);
	};

	public static final Comparator<Entity> PRIORITY_COMPARATOR_ENTITY = (a, b) -> {
		return Float
				.compare(a.hasComponentMatching(RenderComponent.class) ? a.getComponent(RenderComponent.class).getPriority() : 0,
						b.hasComponentMatching(RenderComponent.class) ? b.getComponent(RenderComponent.class).getPriority() : 0);
	};

	@Override
	public void render_in(CacheManager cache, GameEngine ge, Scene3D scene) {
		meshRenderer = (MeshRenderer) cache.getRenderer(Mesh.class.getName());
		instanceEmitterRenderer = (InstanceEmitterRenderer) cache.getRenderer(InstanceEmitter.class.getName());
		textEmitterRenderer = (TextEmitterRenderer) cache.getRenderer(TextEmitter.class.getName());

		LinkedHashMap<String, Entity> sortedMap = scene
				.getEntities()
				.entrySet()
				.stream()
				.sorted(PRIORITY_COMPARATOR)
				.collect(LinkedHashMap::new,
						(linkedHashMap, entry) -> linkedHashMap.put(entry.getKey(), entry.getValue()),
						LinkedHashMap::putAll);
		scene.setEntities(sortedMap);

		Collection<Entity> ce = scene.getEntities().values();
		ce.forEach((e) -> {
			if (!e.isActive()) {
				return;
			}

			if (e.hasComponentMatching(RenderConditionComponent.class) && !e.getComponent(RenderConditionComponent.class).get()) {
				return;
			}

			render(cache, scene, e);
		});
	}

	private void render(CacheManager cache, Scene3D scene, Entity e) {
		if (meshRenderer != null && e.hasComponentMatching(MeshComponent.class)) {
			meshRenderer.render(cache, scene, (MeshComponent) e.getComponent(MeshComponent.class));
		}
		if (instanceEmitterRenderer != null && e.hasComponentMatching(InstanceEmitterComponent.class)) {
			instanceEmitterRenderer.render(cache, scene, (InstanceEmitterComponent) e.getComponent(InstanceEmitterComponent.class));
		}
		if (textEmitterRenderer != null && e.hasComponentMatching(TextEmitterComponent.class)) {
			textEmitterRenderer.render(cache, scene, (TextEmitterComponent) e.getComponent(TextEmitterComponent.class));
		}

		if (e.hasComponentMatching(SubEntitiesComponent.class)) {
			e.getComponent(SubEntitiesComponent.class).getEntities().sort(PRIORITY_COMPARATOR_ENTITY);
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
