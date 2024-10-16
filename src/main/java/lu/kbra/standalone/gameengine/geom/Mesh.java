package lu.kbra.standalone.gameengine.geom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;

import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.attrib.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.MultiAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Mesh implements UniqueID, Cleanupable, Renderable {

	public static final String NAME = Mesh.class.getName();

	protected String name;
	protected int vao = -1;
	protected HashMap<Integer, Integer> vbo = new HashMap<>();
	protected Material material;

	protected Vec3fAttribArray vertices;
	protected UIntAttribArray indices;
	protected AttribArray[] attribs;

	protected int vertexCount, indicesCount;

	/**
	 * Positions are stored as attribArray 0, normals as attribArray 1, uvs as attribArray 2
	 */
	public Mesh(String name, Material material, Vec3fAttribArray vertices, UIntAttribArray indices, AttribArray... attribs) {
		this.name = name;
		this.vertices = vertices;
		indices.setBufferType(GL_W.GL_ELEMENT_ARRAY_BUFFER);
		this.indices = indices;
		this.material = material;
		this.attribs = attribs;

		this.vertexCount = vertices.getDataCount();
		this.indicesCount = indices.getLength();

		this.vao = GL_W.glGenVertexArrays();
		bind();
		storeElementArray((UIntAttribArray) indices);
		vertices.setIndex(0);
		storeAttribArray((Vec3fAttribArray) vertices);

		for (AttribArray a : attribs) {
			if (vbo.containsKey(a.getIndex())) {
				GlobalLogger.log(Level.WARNING, "Duplicate of index: " + a.getIndex() + " from " + a.getName() + ", in Mesh: " + name);
				continue;
			}
			storeAttribArray(a);
		}

		unbind();

		GlobalLogger.log(Level.INFO, "Mesh " + name + ": " + vao + " & " + vbo + "; v:" + vertexCount);
	}

	private void storeAttribArray(AttribArray data) {
		this.vbo.put(data.getIndex(), data.gen());
		data.bind();
		data.init();
		data.enable();
		data.unbind();

		if (data instanceof MultiAttribArray) {
			MultiAttribArray ma = (MultiAttribArray) data;
			for (int a = ma.getMinIndex() + 1; a <= ma.getMaxIndex(); a++) {
				vbo.put(a, data.getBufferIndex());
			}
		}
	}

	public void addAttribArray(AttribArray data) {
		bind();

		this.vbo.put(data.getIndex(), data.gen());
		data.bind();
		data.init();
		data.enable();
		data.unbind();

		if (data instanceof MultiAttribArray) {
			MultiAttribArray ma = (MultiAttribArray) data;
			for (int a = ma.getMinIndex() + 1; a <= ma.getMaxIndex(); a++) {
				vbo.put(a, data.getBufferIndex());
			}
		}

		AttribArray[] newAttribs = new AttribArray[this.attribs.length + 1];
		System.arraycopy(this.attribs, 0, newAttribs, 0, this.attribs.length);
		newAttribs[this.attribs.length] = data;
		this.attribs = newAttribs;
	}

	private void storeElementArray(UIntAttribArray indices) {
		indices.setBufferType(GL_W.GL_ELEMENT_ARRAY_BUFFER);
		this.vbo.put(indices.getIndex(), indices.gen());
		indices.bind();
		indices.init();
	}

	public void bind() {
		GL_W.glBindVertexArray(vao);
		GL_W.checkError("BindVertexArray(" + vao + ") (" + name + ")");
	}

	public void unbind() {
		GL_W.glBindVertexArray(0);
		GL_W.checkError("BindVertexArray(" + 0 + ") (" + name + ")");
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name + " (" + vao + ")");

		if (vao == -1)
			return;

		GL_W.glDeleteVertexArrays(vao);
		Arrays.stream(attribs).forEach(AttribArray::cleanup);
		attribs = null;
		vbo = null;
		vao = -1;
	}

	@Override
	public String getId() {
		return name;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public int getVao() {
		return vao;
	}

	public HashMap<Integer, Integer> getVbo() {
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

	public Material getMaterial() {
		return material;
	}

	public AttribArray[] getAttribs() {
		return attribs;
	}

	public int getIndicesCount() {
		return indicesCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{" + name + " | VAO: " + vao + " | VBO: " + vbo + " | V: " + vertexCount + "/" + indicesCount + " | Attribs: " + Arrays.toString(attribs) + "}";
	}

	public static QuadMesh newQuad(String name, Material material2, Vector2f size) {
		return new QuadMesh(name, material2, size);
	}

	public static QuadMesh newQuad(GeoPlane plane, String name, Material material2, Vector2f size) {
		return new QuadMesh(name, material2, size, plane);
	}

	public static CubeMesh newCube(String name, Material material2, Vector3f size) {
		return new CubeMesh(name, material2, size);
	}

}
