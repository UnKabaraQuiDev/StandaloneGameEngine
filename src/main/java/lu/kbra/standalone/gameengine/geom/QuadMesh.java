package lu.kbra.standalone.gameengine.geom;

import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class QuadMesh extends Mesh {

	private Vector2f size;

	public QuadMesh(String name, Material material, Vector2f size) {
		super(name, material,
				new Vec3fAttribArray(Mesh.ATTRIB_VERTICES_NAME, Mesh.ATTRIB_VERTICES_ID, 1,
						new Vector3f[] {
								new Vector3f(-1f, -1f, 0f).mul(size.x, size.y, 0).div(2),
								new Vector3f(1f, -1f, 0f).mul(size.x, size.y, 0).div(2),
								new Vector3f(1f, 1f, 0f).mul(size.x, size.y, 0).div(2),
								new Vector3f(-1f, 1f, 0f).mul(size.x, size.y, 0).div(2) }),
				new UIntAttribArray(Mesh.ATTRIB_INDICES_NAME, Mesh.ATTRIB_INDICES_ID, 1, new int[] { 0, 1, 2, 0, 2, 3 },
						BufferType.ELEMENT_ARRAY),
				new Vec3fAttribArray(Mesh.ATTRIB_NORMALS_NAME, Mesh.ATTRIB_NORMALS_ID, 1,
						new Vector3f[] { new Vector3f(0, 0, 1), new Vector3f(0, 0, 1), new Vector3f(0, 0, 1), new Vector3f(0, 0, 1) }),
				new Vec2fAttribArray(Mesh.ATTRIB_UVS_NAME, Mesh.ATTRIB_UVS_ID, 1,
						new Vector2f[] { new Vector2f(0, 0), new Vector2f(1, 0), new Vector2f(1, 1), new Vector2f(0, 1), }));

		this.size = size;
	}

	@Deprecated
	public QuadMesh(String name, Material material2, Vector2f size, GeoPlane plane) {
		super(name, material2,
				new Vec3fAttribArray(Mesh.ATTRIB_VERTICES_NAME, Mesh.ATTRIB_VERTICES_ID, 1,
						new Vector3f[] {
								new Vector3f(-1f, -1f, -1f).mul(plane.project(size)).div(2),
								new Vector3f(1f, -1f, 1f).mul(plane.project(size)).div(2),
								new Vector3f(1f, 1f, 1f).mul(plane.project(size)).div(2),
								new Vector3f(-1f, 1f, -1f).mul(plane.project(size)).div(2) }),
				new UIntAttribArray(Mesh.ATTRIB_INDICES_NAME, Mesh.ATTRIB_INDICES_ID, 1, new int[] { 0, 1, 2, 0, 2, 3 },
						BufferType.ELEMENT_ARRAY),
				new Vec3fAttribArray(Mesh.ATTRIB_NORMALS_NAME, Mesh.ATTRIB_NORMALS_ID, 1,
						new Vector3f[] { new Vector3f(0, 0, 1), new Vector3f(0, 0, 1), new Vector3f(0, 0, 1), new Vector3f(0, 0, 1) }),
				new Vec2fAttribArray(Mesh.ATTRIB_UVS_NAME, Mesh.ATTRIB_UVS_ID, 1,
						new Vector2f[] { new Vector2f(0, 0), new Vector2f(1, 0), new Vector2f(1, 1), new Vector2f(0, 1) }));

		this.size = plane.getBoundingPlane(vertices.getData());
	}

	public Vector2f getSize() {
		return size;
	}

}
