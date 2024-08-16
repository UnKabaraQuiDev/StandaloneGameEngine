package lu.kbra.standalone.gameengine.utils;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Gizmo;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.utils.ObjLoader;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.graph.material.gizmo.GizmoShader;
import lu.kbra.standalone.gameengine.graph.material.gizmo.GizmoShader.GizmoMaterial;
import lu.kbra.standalone.gameengine.graph.material.wireframe.WireframeMaterial;
import lu.kbra.standalone.gameengine.graph.material.wireframe.WireframeShader;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.scene.Scene;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;
import lu.pcy113.pclib.logger.GlobalLogger;

public class DebugOptions implements Cleanupable {

	public boolean ignoreDepth = true;

	public boolean gizmos = true;
	public Gizmo gizmoXYZ, gizmoRect;

	public void gizmos(CacheManager cache, Scene scene, Matrix4f projectionMatrix, Matrix4f viewMatrix, Object modelMatrix) {
		if (!gizmos)
			return;

		if (gizmoXYZ == null) {
			gizmoXYZ = ObjLoader.loadGizmo("named_xyz", "./resources/models/gizmos/named_XYZ.obj");
		}

		gizmoXYZ.bind();

		GizmoMaterial deb;
		if (cache.hasMaterial(GizmoShader.GizmoMaterial.NAME)) {
			deb = (GizmoMaterial) cache.getMaterial(GizmoShader.GizmoMaterial.NAME);
		} else {
			deb = (GizmoMaterial) cache.loadMaterial(GizmoShader.GizmoMaterial.class);
		}
		RenderShader debShader = deb.getRenderShader();

		debShader.bind();

		deb.setPropertyIfPresent(RenderShader.PROJECTION_MATRIX, projectionMatrix);
		deb.setPropertyIfPresent(RenderShader.VIEW_MATRIX, viewMatrix);
		if (modelMatrix != null)
			deb.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, modelMatrix);
		else
			deb.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, new Matrix4f().identity());
		deb.bindProperties(cache, scene, debShader);

		if (GameEngine.DEBUG.ignoreDepth)
			GL_W.glDisable(GL_W.GL_DEPTH_TEST);

		GL_W.glLineWidth(2.5f);
		GL_W.glDrawElements(GL_W.GL_LINES, gizmoXYZ.getIndicesCount(), GL_W.GL_UNSIGNED_INT, 0);

		GL_W.glEnable(GL_W.GL_DEPTH_TEST);

		gizmoXYZ.unbind();
	}

	public boolean wireframe = true, bones = true;
	public Vector4f wireframeColor = new Vector4f(1, 0, 0, 1), bonesColor = new Vector4f(0, 1, 0, 1), textBoxColor = new Vector4f(1, 0, 1, 1);

	public void wireframe(CacheManager cache, Scene scene, Mesh mesh, Matrix4f projectionMatrix, Matrix4f viewMatrix, Matrix4f transformationMatrix) {
		if (!wireframe)
			return;

		Material deb = cache.getMaterial(WireframeMaterial.NAME);
		if (deb == null) {
			WireframeShader shader = new WireframeShader();
			cache.addRenderShader(shader);
			deb = new WireframeMaterial(shader);
			cache.addMaterial(deb);
		}
		RenderShader debShader = deb.getRenderShader();
		debShader.bind();

		deb.setPropertyIfPresent(RenderShader.PROJECTION_MATRIX, projectionMatrix);
		deb.setPropertyIfPresent(RenderShader.VIEW_MATRIX, viewMatrix);
		if (transformationMatrix != null)
			deb.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, transformationMatrix);
		else
			deb.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, new Matrix4f().identity());
		deb.setPropertyIfPresent(WireframeShader.COLOR, wireframeColor);
		deb.bindProperties(cache, scene, debShader);

		if (GameEngine.DEBUG.ignoreDepth)
			GL_W.glDisable(GL_W.GL_DEPTH_TEST);

		GL_W.glDrawElements(GL_W.GL_LINE_STRIP, mesh.getIndicesCount(), GL_W.GL_UNSIGNED_INT, 0);

		GL_W.glEnable(GL_W.GL_DEPTH_TEST);
	}

	public void pointWireframe(CacheManager cache, Scene scene, Mesh mesh, Matrix4f projectionMatrix, Matrix4f viewMatrix, Matrix4f transformationMatrix) {
		if (!wireframe)
			return;

		Material deb = cache.getMaterial(WireframeMaterial.NAME);
		if (deb == null) {
			WireframeShader shader = new WireframeShader();
			cache.addRenderShader(shader);
			deb = new WireframeMaterial(shader);
			cache.addMaterial(deb);
		}
		RenderShader debShader = deb.getRenderShader();
		debShader.bind();

		deb.setPropertyIfPresent(RenderShader.PROJECTION_MATRIX, projectionMatrix);
		deb.setPropertyIfPresent(RenderShader.VIEW_MATRIX, viewMatrix);
		deb.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, transformationMatrix);
		deb.setPropertyIfPresent(WireframeShader.COLOR, wireframeColor);
		deb.bindProperties(cache, scene, debShader);

		if (GameEngine.DEBUG.ignoreDepth)
			GL_W.glDisable(GL_W.GL_DEPTH_TEST);

		GL_W.glDrawElements(GL_W.GL_POINTS, mesh.getIndicesCount(), GL_W.GL_UNSIGNED_INT, 0);

		GL_W.glEnable(GL_W.GL_DEPTH_TEST);
	}

	public void boundingRect(CacheManager cache, Scene scene, Matrix4f projectionMatrix, Matrix4f viewMatrix, Matrix4f modelMatrix, Vector2f boxSize) {
		if (!gizmos)
			return;

		if (gizmoRect == null) {
			gizmoRect = Gizmo.newRect("rect", new Vector2f(1), textBoxColor);
		}

		gizmoRect.bind();

		GizmoMaterial deb;
		if (cache.hasMaterial(GizmoShader.GizmoMaterial.NAME)) {
			deb = (GizmoMaterial) cache.getMaterial(GizmoShader.GizmoMaterial.NAME);
		} else {
			deb = (GizmoMaterial) cache.loadMaterial(GizmoShader.GizmoMaterial.class);
		}
		RenderShader debShader = deb.getRenderShader();

		debShader.bind();

		deb.setPropertyIfPresent(RenderShader.PROJECTION_MATRIX, projectionMatrix);
		deb.setPropertyIfPresent(RenderShader.VIEW_MATRIX, viewMatrix);
		if (modelMatrix != null)
			deb.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, modelMatrix.get(new Matrix4f()).scale(new Vector3f(boxSize.x, boxSize.y, 1)));
		else
			deb.setPropertyIfPresent(RenderShader.TRANSFORMATION_MATRIX, new Matrix4f().identity().scale(new Vector3f(boxSize.x, boxSize.y, 1)));
		deb.bindProperties(cache, scene, debShader);

		if (GameEngine.DEBUG.ignoreDepth)
			GL_W.glDisable(GL_W.GL_DEPTH_TEST);

		GL_W.glLineWidth(2.5f);
		GL_W.glDrawElements(GL_W.GL_LINES, gizmoRect.getIndicesCount(), GL_W.GL_UNSIGNED_INT, 0);

		GL_W.glEnable(GL_W.GL_DEPTH_TEST);

		gizmoRect.unbind();
	}

	/*
	 * private FileWriter eventFileWriter; private HashMap<String, Pair<Long, Long>> statuses = new HashMap<>();
	 * 
	 * public DebugOptions() { try { this.eventFileWriter = new
	 * FileWriter(PCUtils.appendFileName(GlobalLogger.getLogger().getLogFile().getPath(), "-time")); } catch (IOException e)
	 * { e.printStackTrace(); } }
	 * 
	 * public synchronized void start(String type) { statuses.put(type, new Pair<Long, Long>(System.currentTimeMillis(),
	 * System.nanoTime())); }
	 * 
	 * public synchronized void end(String type) { if(eventFileWriter == null) return; try { Pair<Long, Long> status =
	 * statuses.remove(type); if (status == null) return; eventFileWriter.append("start>" + type + ":" + status.getKey() +
	 * ":" + status.getValue() + "/end>" + System.currentTimeMillis() + ":" + System.nanoTime() + "\n"); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + getClass().getName());

		/*
		 * if(eventFileWriter == null) return;
		 * 
		 * try { eventFileWriter.flush(); eventFileWriter.close(); eventFileWriter = null; } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
	}

}
