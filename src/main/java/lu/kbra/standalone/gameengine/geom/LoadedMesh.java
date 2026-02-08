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
import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public class LoadedMesh implements Mesh {

//	public static final String ATTRIB_VERTICES_NAME = "vertices";
//	public static final String ATTRIB_INDICES_NAME = "ids";
//	public static final String ATTRIB_NORMALS_NAME = "normals";
//	public static final String ATTRIB_UVS_NAME = "uvs";
//
//	public static final int ATTRIB_VERTICES_ID = 0;
//	public static final int ATTRIB_INDICES_ID = -1;
//	public static final int ATTRIB_NORMALS_ID = 1;
//	public static final int ATTRIB_UVS_ID = 2;

	protected String name;
	protected int vao = -1;
	protected HashMap<Integer, Integer> vbo = new HashMap<>();
	protected Material material;

	protected Vec3fAttribArray vertices;
	protected UIntAttribArray indices;
	protected List<AttribArray> attribs;

	protected int vertexCount;
	protected int indicesCount;
	protected final BoundingBox boundingBox;

	/**
	 * Positions are stored as attribArray 0, normals as attribArray 1, uvs as attribArray 2
	 */
	public LoadedMesh(final String name, final Material material, final Vec3fAttribArray vertices, final UIntAttribArray indices,
			final AttribArray... attribs) {
		this.name = name;
		this.vertices = vertices;
		this.indices = indices;
		this.material = material;
		this.attribs = new ArrayList<>(Arrays.asList(attribs));

		this.vertexCount = vertices.getLength();
		this.indicesCount = indices.getLength();
		this.boundingBox = GameEngineUtils.getBoundingBox(vertices);

		this.vao = GL_W.glGenVertexArrays();
		this.bind();
		indices.setIndex(ATTRIB_INDICES_ID);
		indices.setBufferType(BufferType.ELEMENT_ARRAY);
		this.storeElementArray((UIntAttribArray) indices);
		vertices.setName(ATTRIB_VERTICES_NAME);
		vertices.setIndex(ATTRIB_VERTICES_ID);
		this.storeAttribArray((Vec3fAttribArray) vertices);

		for (final AttribArray a : attribs) {
			if (this.vbo.containsKey(a.getIndex())) {
				GlobalLogger.log(Level.WARNING, "Duplicate of index: " + a.getIndex() + " from " + a.getName() + ", in Mesh: " + name);
				continue;
			}
			this.storeAttribArray(a);
		}

		this.unbind();

		GlobalLogger.log(Level.INFO, "Mesh " + name + ": " + this.vao + " & " + this.vbo + "; v:" + this.vertexCount + " ");
	}

	public void storeElementArray(final UIntAttribArray indices) {
		indices.setBufferType(BufferType.ELEMENT_ARRAY);
		this.vbo.put(indices.getIndex(), indices.gen());
		indices.bind();
		indices.init();
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + this.name + " (" + this.vao + ")");

		if (this.vao == -1) {
			return;
		}

		GL_W.glDeleteVertexArrays(this.vao);
		attribs.forEach(AttribArray::cleanup);
		this.attribs = null;
		this.vbo = null;
		this.vao = -1;
	}

	@Override
	public String getId() {
		return this.name;
	}

	@Override
	public int getVertexCount() {
		return this.vertexCount;
	}

	@Override
	public int getGlId() {
		return this.vao;
	}

	@Override
	public Map<Integer, Integer> getVbo() {
		return this.vbo;
	}

	public String getName() {
		return this.name;
	}

	public UIntAttribArray getIndices() {
		return this.indices;
	}

	public Vec3fAttribArray getVertices() {
		return this.vertices;
	}

	@Override
	public Material getMaterial() {
		return this.material;
	}

	@Override
	public List<AttribArray> getAttribs() {
		return this.attribs;
	}

	@Override
	public int getIndicesCount() {
		return this.indicesCount;
	}

	public int getFaceCount() {
		return this.indicesCount / 6;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public boolean isValid() {
		return this.vao != -1;
	}

	@Override
	public BoundingBox getBoundingBox() {
		return this.boundingBox;
	}
	
	@Override
	public boolean usesEBO() {
		return true;
	}

	@Override
	public String toString() {
		return "LoadedMesh [name=" + this.name + ", vao=" + this.vao + ", vbo=" + this.vbo + ", material=" + this.material + ", vertices="
				+ this.vertices + ", indices=" + this.indices + ", attribs=" + attribs + ", vertexCount=" + this.vertexCount
				+ ", indicesCount=" + this.indicesCount + ", isValid()=" + this.isValid() + ", boundingBox=" + this.boundingBox + "]";
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
