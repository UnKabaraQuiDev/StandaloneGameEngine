package lu.kbra.standalone.gameengine.graph.render;

import java.util.logging.Level;

import org.joml.Matrix4f;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Gizmo;
import lu.kbra.standalone.gameengine.graph.material.gizmo.GizmoShader;
import lu.kbra.standalone.gameengine.graph.material.gizmo.GizmoShader.GizmoMaterial;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.objs.entity.components.GizmoComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.TransformComponent;
import lu.kbra.standalone.gameengine.scene.Scene;
import lu.kbra.standalone.gameengine.scene.camera.Camera;
import lu.kbra.standalone.gameengine.scene.camera.Camera3D;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;
import lu.pcy113.pclib.logger.GlobalLogger;

public class GizmoRenderer extends Renderer<Scene, GizmoComponent> {

	public GizmoRenderer() {
		super(Gizmo.class);
	}

	@Override
	public void render_in(CacheManager cache, Scene scene, GizmoComponent gi) {
		Entity e = gi.getParent();

		Gizmo gizmo = gi.getGizmo(cache);
		if (gizmo == null)
			return;

		GlobalLogger.log(Level.FINE, "Gizmo : " + gizmo.getId());

		gizmo.bind();

		GizmoMaterial material;
		if (cache.hasMaterial(GizmoShader.GizmoMaterial.NAME)) {
			material = (GizmoMaterial) cache.getMaterial(GizmoShader.GizmoMaterial.NAME);
		} else {
			material = (GizmoMaterial) cache.loadMaterial(GizmoShader.GizmoMaterial.class);
		}
		RenderShader shader = material.getRenderShader();

		shader.bind();

		Matrix4f projectionMatrix = null, viewMatrix = null, transformationMatrix = new Matrix4f().identity();
		if (scene != null) {
			Camera camera = scene.getCamera();
			projectionMatrix = camera.getProjection().getProjectionMatrix();
			viewMatrix = camera.getViewMatrix();
			shader.setUniform(RenderShader.PROJECTION_MATRIX, projectionMatrix);
			shader.setUniform(RenderShader.VIEW_MATRIX, viewMatrix);
			if (camera instanceof Camera3D) {
				material.setPropertyIfPresent(RenderShader.VIEW_POSITION, ((Camera3D) camera).getPosition());
			}
		}

		if (material.hasProperty(RenderShader.TRANSFORMATION_MATRIX)) {
			if (e.hasComponent(TransformComponent.class)) {
				TransformComponent transform = (TransformComponent) e.getComponent(e.getComponents(TransformComponent.class).get(0));
				if (transform != null) {
					transformationMatrix = transform.getTransform().getMatrix();
				}
			}
			material.setProperty(RenderShader.TRANSFORMATION_MATRIX, transformationMatrix);
		}

		material.bindProperties(cache, scene, shader);

		if (GameEngine.DEBUG.ignoreDepth)
			GL_W.glDisable(GL_W.GL_DEPTH_TEST);

		// GL_W.glPolygonMode(shader.getFaceMode().getGlId(), shader.getRenderType().getGlId());
		GL_W.glLineWidth(Gizmo.LINE_WIDTH);

		GL_W.glDrawElements(shader.getBeginMode().getGlId(), gizmo.getIndicesCount(), GL_W.GL_UNSIGNED_INT, 0);

		// GL_W.glPolygonMode(GL_W.GL_FRONT_AND_BACK, GL_W.GL_FILL);
		GL_W.glEnable(GL_W.GL_DEPTH_TEST);

		gizmo.unbind();
	}

	@Override
	public void cleanup() {
		super.cleanup();
	}

}
