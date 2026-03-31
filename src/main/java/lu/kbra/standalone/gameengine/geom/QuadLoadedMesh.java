package lu.kbra.standalone.gameengine.geom;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3f;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class QuadLoadedMesh extends LoadedMesh implements QuadMesh {

	private final Vector2fc size;

	public QuadLoadedMesh(String name, Material material, Vector2fc size, JavaAttribArray... arrays) {
		super(name,
				material,
				new Vec3fAttribArray(Mesh.ATTRIB_VERTICES_NAME,
						Mesh.ATTRIB_VERTICES_ID,
						new Vector3f[] {
								new Vector3f(-1f, 0, -1f).mul(size.x(), 0, size.y()).div(2),
								new Vector3f(1f, 0, -1f).mul(size.x(), 0, size.y()).div(2),
								new Vector3f(1f, 0, 1f).mul(size.x(), 0, size.y()).div(2),
								new Vector3f(-1f, 0, 1f).mul(size.x(), 0, size.y()).div(2) }),
				new UIntAttribArray(Mesh.ATTRIB_INDICES_NAME,
						Mesh.ATTRIB_INDICES_ID,
						new int[] { 0, 2, 1, 0, 3, 2 },
						BufferType.ELEMENT_ARRAY),
				PCUtils.combineArrays(new JavaAttribArray[] {
						new Vec3fAttribArray(Mesh.ATTRIB_NORMALS_NAME,
								Mesh.ATTRIB_NORMALS_ID,
								new Vector3f[] {
										new Vector3f(0, 0, 1),
										new Vector3f(0, 0, 1),
										new Vector3f(0, 0, 1),
										new Vector3f(0, 0, 1) }),
						new Vec2fAttribArray(Mesh.ATTRIB_UVS_NAME,
								Mesh.ATTRIB_UVS_ID,
								new Vector2f[] { new Vector2f(0, 1), new Vector2f(1, 1), new Vector2f(1, 0), new Vector2f(0, 0) }) },
						arrays));

		this.size = size;
	}

	@Deprecated
	public QuadLoadedMesh(String name, Material material2, Vector2fc size, GeoPlane plane) {
		super(name,
				material2,
				new Vec3fAttribArray(Mesh.ATTRIB_VERTICES_NAME,
						Mesh.ATTRIB_VERTICES_ID,
						new Vector3f[] {
								new Vector3f(-1f, -1f, -1f).mul(plane.project(size)).div(2),
								new Vector3f(1f, -1f, 1f).mul(plane.project(size)).div(2),
								new Vector3f(1f, 1f, 1f).mul(plane.project(size)).div(2),
								new Vector3f(-1f, 1f, -1f).mul(plane.project(size)).div(2) }),
				new UIntAttribArray(Mesh.ATTRIB_INDICES_NAME,
						Mesh.ATTRIB_INDICES_ID,
						new int[] { 0, 1, 2, 0, 2, 3 },
						BufferType.ELEMENT_ARRAY),
				new Vec3fAttribArray(Mesh.ATTRIB_NORMALS_NAME,
						Mesh.ATTRIB_NORMALS_ID,
						new Vector3f[] { new Vector3f(0, 0, 1), new Vector3f(0, 0, 1), new Vector3f(0, 0, 1), new Vector3f(0, 0, 1) }),
				new Vec2fAttribArray(Mesh.ATTRIB_UVS_NAME,
						Mesh.ATTRIB_UVS_ID,
						new Vector2f[] { new Vector2f(0, 0), new Vector2f(1, 0), new Vector2f(1, 1), new Vector2f(0, 1) }));

		this.size = plane.getBoundingPlane(vertices.getData());
	}

	@Override
	public Vector2fc getSize() {
		return size;
	}

}
