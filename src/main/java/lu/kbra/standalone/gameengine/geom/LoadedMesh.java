package lu.kbra.standalone.gameengine.geom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class LoadedMesh extends AutoCleanupable implements Mesh {

	protected String name;
	protected int vao = -1;
	protected HashMap<Integer, Integer> vbo = new HashMap<>();
	protected Material material;

	protected Vec3fAttribArray vertices;
	protected UIntAttribArray indices;
	protected List<JavaAttribArray> attribs;

	protected int vertexCount;
	protected int indicesCount;
	protected final BoundingBox boundingBox;

	/**
	 * Positions are stored as attribArray 0, normals as attribArray 1, uvs as attribArray 2
	 */
	public LoadedMesh(
			final String name,
			final Material material,
			final Vec3fAttribArray vertices,
			final UIntAttribArray indices,
			final JavaAttribArray... attribs) {
		this.name = name;
		this.vertices = vertices;
		this.indices = indices;
		this.material = material;
		this.attribs = new ArrayList<>(Arrays.asList(attribs));

		vertexCount = vertices.getLength();
		indicesCount = indices.getLength();
		boundingBox = GameEngineUtils.getBoundingBox(vertices);

		vao = GL_W.glGenVertexArrays();
		bind();
		indices.setIndex(ATTRIB_INDICES_ID);
		indices.setBufferType(BufferType.ELEMENT_ARRAY);
		storeElementArray((UIntAttribArray) indices);
		vertices.setName(ATTRIB_VERTICES_NAME);
		vertices.setIndex(ATTRIB_VERTICES_ID);
		storeAttribArray((Vec3fAttribArray) vertices);

		for (final JavaAttribArray a : attribs) {
			if (vbo.containsKey(a.getIndex())) {
				GlobalLogger.log(Level.WARNING, "Duplicate of index: " + a.getIndex() + " from " + a.getName() + ", in Mesh: " + name);
				continue;
			}
			storeAttribArray(a);
		}

		unbind();

		GlobalLogger.log(Level.INFO, "Mesh " + name + ": " + vao + " & " + vbo + "; v:" + vertexCount + " ");
	}

	public void storeElementArray(final UIntAttribArray indices) {
		indices.setBufferType(BufferType.ELEMENT_ARRAY);
		vbo.put(indices.getIndex(), indices.gen());
		indices.bind();
		indices.init();
	}

	@Override
	public void cleanup() {
		if (vao == -1)
			return;

		GlobalLogger.log("Cleaning up: " + name + " (" + vao + ")");

		GL_W.glDeleteVertexArrays(vao);
		attribs.forEach(JavaAttribArray::cleanup);
		attribs = null;
		vbo = null;
		vao = -1;

		super.cleanup();
	}

	@Override
	public String getId() {
		return name;
	}

	@Override
	public int getVertexCount() {
		return vertexCount;
	}

	@Override
	public int getGlId() {
		return vao;
	}

	@Override
	public Map<Integer, Integer> getVbo() {
		return vbo;
	}

	public String getName() {
		return name;
	}

	public UIntAttribArray getIndices() {
		return indices;
	}

	public Vec3fAttribArray getVertices() {
		return vertices;
	}

	@Override
	public Material getMaterial() {
		return material;
	}

	@Override
	public List<JavaAttribArray> getAttribs() {
		return attribs;
	}

	@Override
	public int getIndicesCount() {
		return indicesCount;
	}

	public int getFaceCount() {
		return indicesCount / 6;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public boolean isValid() {
		return vao != -1;
	}

	@Override
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	@Override
	public boolean usesEBO() {
		return true;
	}

	@Override
	public String toString() {
		return "LoadedMesh [name=" + name + ", vao=" + vao + ", vbo=" + vbo + ", material=" + material + ", vertices=" + vertices
				+ ", indices=" + indices + ", attribs=" + attribs + ", vertexCount=" + vertexCount + ", indicesCount=" + indicesCount
				+ ", isValid()=" + isValid() + ", boundingBox=" + boundingBox + "]";
	}

	public static QuadLoadedMesh newQuad(final String name, final Material material2, final Vector2f size) {
		return new QuadLoadedMesh(name, material2, size);
	}

	public static QuadLoadedMesh newQuad(final GeoPlane plane, final String name, final Material material2, final Vector2f size) {
		return new QuadLoadedMesh(name, material2, size, plane);
	}

	public static CubeMesh newCube(final String name, final Material material2, final Vector3f size) {
		return new CubeMesh(name, material2, size);
	}

}
