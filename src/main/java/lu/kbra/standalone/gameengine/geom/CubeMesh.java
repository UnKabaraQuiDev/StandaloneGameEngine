package lu.kbra.standalone.gameengine.geom;

import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class CubeMesh extends Mesh {

	private Vector3f size;

	public CubeMesh(String name, Material material2, Vector3f size) {
		super(name, material2,
				new Vec3fAttribArray(Mesh.ATTRIB_NORMALS_NAME, Mesh.ATTRIB_NORMALS_ID, 1,
						new Vector3f[] {
								new Vector3f(-1, -1, -1).mul(size.x, size.y, size.z).div(2),
								new Vector3f(1, -1, -1).mul(size.x, size.y, size.z).div(2),
								new Vector3f(1, 1, -1).mul(size.x, size.y, size.z).div(2),
								new Vector3f(-1, 1, -1).mul(size.x, size.y, size.z).div(2),
								new Vector3f(-1, -1, 1).mul(size.x, size.y, size.z).div(2),
								new Vector3f(1, -1, 1).mul(size.x, size.y, size.z).div(2),
								new Vector3f(1, 1, 1).mul(size.x, size.y, size.z).div(2),
								new Vector3f(-1, 1, 1).mul(size.x, size.y, size.z).div(2) }),
				new UIntAttribArray(Mesh.ATTRIB_INDICES_NAME, Mesh.ATTRIB_INDICES_ID, 1, new int[] {
						// back face (-Z)
						0,
						1,
						2,
						2,
						3,
						0,

						// front face (+Z)
						4,
						5,
						6,
						6,
						7,
						4,

						// left face (-X)
						0,
						3,
						7,
						7,
						4,
						0,

						// right face (+X)
						1,
						5,
						6,
						6,
						2,
						1,

						// bottom face (-Y)
						0,
						1,
						5,
						5,
						4,
						0,

						// top face (+Y)
						3,
						7,
						6,
						6,
						2,
						3 }, BufferType.ELEMENT_ARRAY),
				new Vec3fAttribArray(Mesh.ATTRIB_NORMALS_NAME, Mesh.ATTRIB_NORMALS_ID, 1,
						new Vector3f[] {
								new Vector3f(-1, -1, -1).normalize(),
								new Vector3f(1, -1, -1).normalize(),
								new Vector3f(1, 1, -1).normalize(),
								new Vector3f(-1, 1, -1).normalize(),
								new Vector3f(-1, -1, 1).normalize(),
								new Vector3f(1, -1, 1).normalize(),
								new Vector3f(1, 1, 1).normalize(),
								new Vector3f(-1, 1, 1).normalize() }),
				new Vec2fAttribArray(Mesh.ATTRIB_UVS_NAME, Mesh.ATTRIB_UVS_ID, 1, // TODO: 3d uvs ?
						new Vector2f[] {
								new Vector2f(0, 0),
								new Vector2f(1, 0),
								new Vector2f(1, 1),
								new Vector2f(0, 1),
								new Vector2f(0, 0),
								new Vector2f(1, 0),
								new Vector2f(1, 1),
								new Vector2f(0, 1) }));

		this.size = size;
	}

	public Vector3f getSize() {
		return size;
	}

}
