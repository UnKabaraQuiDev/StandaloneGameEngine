package lu.kbra.standalone.gameengine.geom;

import java.util.List;
import java.util.Map;

import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.MultiAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;
import lu.kbra.standalone.gameengine.utils.gl.consts.BeginMode;
import lu.kbra.standalone.gameengine.utils.gl.consts.PolygonDrawMode;
import lu.kbra.standalone.gameengine.utils.gl.consts.PolygonMode;

public interface Mesh extends UniqueID, Cleanupable, Renderable, GLObject {

	String ATTRIB_VERTICES_NAME = "vertices";
	String ATTRIB_INDICES_NAME = "ids";
	String ATTRIB_NORMALS_NAME = "normals";
	String ATTRIB_UVS_NAME = "uvs";

	int ATTRIB_VERTICES_ID = 0;
	int ATTRIB_INDICES_ID = -1;
	int ATTRIB_NORMALS_ID = 1;
	int ATTRIB_UVS_ID = 2;

	Vector2f UV_RANGE = new Vector2f(0, 1);

	default void bind() {
		GL_W.glBindVertexArray(this.getGlId());
	}

	default void unbind() {
		GL_W.glBindVertexArray(0);
	}

	int getVertexCount();

	Map<Integer, Integer> getVbo();

	int getIndicesCount();

	Material getMaterial();

	BoundingBox getBoundingBox();

	default PolygonMode getPolygonMode() {
		return PolygonMode.FRONT;
	}

	default PolygonDrawMode getPolygonDrawMode() {
		return PolygonDrawMode.FILL;
	}

	default BeginMode getBeginMode() {
		return BeginMode.TRIANGLES;
	}

	@Deprecated
	boolean usesEBO();

	default void storeAttribArray(AttribArray data) {
		bind();
		final boolean valid = data.isValid();
		if (!valid) {
			data.gen();
		}
		getVbo().put(data.getIndex(), data.getGlId());
		data.bind();
		if (!valid) {
			data.init();
		}
		data.enable();
		data.unbind();

		if (data instanceof MultiAttribArray) {
			final MultiAttribArray ma = (MultiAttribArray) data;
			for (int a = ma.getMinIndex() + 1; a <= ma.getMaxIndex(); a++) {
				getVbo().put(a, data.getGlId());
			}
		}
	}

	default void addAttribArray(AttribArray data) {
		bind();
		final boolean valid = data.isValid();
		if (!valid) {
			data.gen();
		}
		getVbo().put(data.getIndex(), data.getGlId());
		data.bind();
		if (!valid) {
			data.init();
		}
		data.enable();
		data.unbind();

		if (data instanceof MultiAttribArray) {
			final MultiAttribArray ma = (MultiAttribArray) data;
			for (int a = ma.getMinIndex() + 1; a <= ma.getMaxIndex(); a++) {
				getVbo().put(a, data.getGlId());
			}
		}

		getAttribs().add(data);
	}

	List<AttribArray> getAttribs();

	public static QuadLoadedMesh newQuad(String name, Material material2, Vector2f size) {
		return new QuadLoadedMesh(name, material2, size);
	}

	public static QuadLoadedMesh newQuad(GeoPlane plane, String name, Material material2, Vector2f size) {
		return new QuadLoadedMesh(name, material2, size, plane);
	}

	public static CubeMesh newCube(String name, Material material2, Vector3f size) {
		return new CubeMesh(name, material2, size);
	}

}
