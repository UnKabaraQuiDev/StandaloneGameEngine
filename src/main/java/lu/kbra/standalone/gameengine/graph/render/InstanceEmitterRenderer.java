package lu.kbra.standalone.gameengine.graph.render;

import java.util.logging.Level;

import org.joml.Matrix4f;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.objs.entity.components.InstanceEmitterComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.PointLightSurfaceComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.TransformComponent;
import lu.kbra.standalone.gameengine.scene.Scene;
import lu.kbra.standalone.gameengine.scene.Scene3D;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class InstanceEmitterRenderer extends Renderer<Scene, InstanceEmitterComponent> {

	public InstanceEmitterRenderer() {
		super(InstanceEmitter.class);
	}

	@Override
	public void render_in(CacheManager cache, Scene scene, InstanceEmitterComponent pec) {
		InstanceEmitter pe = pec.getInstanceEmitter(cache);
		if (pe == null) {
			GlobalLogger.log(Level.WARNING, "InstanceEmitter is null!");
			return;
		}

		GlobalLogger.log(Level.FINE, "InstanceEmitter : " + pe.getId());

		Mesh mesh = pe.getParticleMesh();
		if (mesh == null)
			return;

		Material material = mesh.getMaterial();
		if (material == null) {
			GlobalLogger.log(Level.WARNING, "Material is null!");
			return;
		}
		RenderShader shader = material.getRenderShader();
		if (shader == null) {
			GlobalLogger.log(Level.WARNING, "Shader is null!");
			return;
		}

		shader.bind();

		Matrix4f projectionMatrix = null, viewMatrix = null, transformationMatrix = new Matrix4f().identity();
		if (scene != null) {
			projectionMatrix = scene.getCamera().getProjection().getProjectionMatrix();
			viewMatrix = scene.getCamera().getViewMatrix();
			material.setPropertyIfPresent(RenderShader.PROJECTION_MATRIX, projectionMatrix);
			material.setPropertyIfPresent(RenderShader.VIEW_MATRIX, viewMatrix);
		}
		if (pec.getParent().hasComponentMatching(TransformComponent.class)) {
			TransformComponent transform = (TransformComponent) pec.getParent()
					.getComponent(pec.getParent().getComponentTypesMatching(TransformComponent.class).get(0));
			if (transform != null) {
				transformationMatrix = transform.getTransform().getMatrix();
			}
		}
		material.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, transformationMatrix);

		if (scene instanceof Scene3D) {
			PointLightSurfaceComponent plsc = pec.getParent().getComponent(PointLightSurfaceComponent.class);
			if (plsc != null)
				plsc.bindLights(cache, ((Scene3D) scene).getLights(), material);
		}

		material.bindProperties(cache, scene);

		if (shader.isTransparent()) {
			GL_W.glEnable(GL_W.GL_BLEND);
			GL_W.glBlendFunc(GL_W.GL_SRC_ALPHA, GL_W.GL_ONE_MINUS_SRC_ALPHA);
		}

		pe.bind();

		GL_W.glDrawElementsInstanced(shader.getBeginMode().getGlId(), mesh.getIndicesCount(), GL_W.GL_UNSIGNED_INT, 0,
				pe.getParticleCount());

		GL_W.glDisable(GL_W.GL_BLEND);

		mesh.unbind();

		GameEngine.DEBUG.gizmos(cache, scene, projectionMatrix, viewMatrix, transformationMatrix);
	}

	@Override
	public void cleanup() {
		super.cleanup();
	}

}
