package lu.kbra.standalone.gameengine.graph.render;

import java.util.logging.Level;

import org.joml.Matrix4f;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.objs.entity.Entity;
import lu.kbra.standalone.gameengine.objs.entity.components.MeshComponent;
import lu.kbra.standalone.gameengine.objs.entity.components.TransformComponent;
import lu.kbra.standalone.gameengine.scene.Scene;
import lu.kbra.standalone.gameengine.scene.camera.Camera;
import lu.kbra.standalone.gameengine.scene.camera.Camera3D;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class MeshRenderer extends Renderer<Scene, MeshComponent> {

	public MeshRenderer() {
		super(Mesh.class);
	}

	@Override
	public void render_in(CacheManager cache, Scene scene, MeshComponent m) {
		Entity e = m.getParent();

		Mesh mesh = m.getMesh(cache);
		if (mesh == null) {
			GlobalLogger.log(Level.WARNING, "Mesh is null, for entity: " + e + "!");
			cache.dump(GlobalLogger.getLogger().getFileWriter());
			return;
		}

		GlobalLogger.log(Level.FINE, "Mesh : " + mesh.getId() + ", vao:" + mesh.getVao() + ", vec:" + mesh.getVertexCount() + ", vbo:" + mesh.getVbo());

		mesh.bind();

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
				material.setProperty(RenderShader.TRANSFORMATION_MATRIX, transformationMatrix);
			}
		}
		
		material.bindProperties(cache, scene, shader);

		if (shader.isTransparent()) {
			GL_W.glBlendFunc(GL_W.GL_SRC_ALPHA, GL_W.GL_ONE_MINUS_SRC_ALPHA);
			GL_W.glEnable(GL_W.GL_BLEND);
		}

		// GL_W.glPolygonMode(shader.getFaceMode().getGlId(), shader.getRenderType().getGlId());

		GL_W.glDrawElements(shader.getBeginMode().getGlId(), mesh.getIndicesCount(), GL_W.GL_UNSIGNED_INT, 0);

		GL_W.glDisable(GL_W.GL_BLEND);

		// debug only
		GameEngine.DEBUG.wireframe(cache, scene, mesh, projectionMatrix, viewMatrix, transformationMatrix);

		mesh.unbind();

		GameEngine.DEBUG.gizmos(cache, scene, projectionMatrix, viewMatrix, transformationMatrix);
	}

	@Override
	public void cleanup() {
		super.cleanup();
	}

}
