package lu.kbra.standalone.gameengine.geom;

import java.util.Map;

import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.cache.attrib.AttribArray;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;

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

	void addAttribArray(AttribArray data);

	void bind();

	void unbind();

	int getVertexCount();

	Map<Integer, Integer> getVbo();

	int getIndicesCount();

	Material getMaterial();

	BoundingBox getBoundingBox();

	public static LoadedQuadMesh newQuad(String name, Material material2, Vector2f size) {
		return new LoadedQuadMesh(name, material2, size);
	}

	public static LoadedQuadMesh newQuad(GeoPlane plane, String name, Material material2, Vector2f size) {
		return new LoadedQuadMesh(name, material2, size, plane);
	}

	public static CubeMesh newCube(String name, Material material2, Vector3f size) {
		return new CubeMesh(name, material2, size);
	}

}
