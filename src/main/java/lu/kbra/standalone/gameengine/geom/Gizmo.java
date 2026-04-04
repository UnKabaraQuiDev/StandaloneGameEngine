package lu.kbra.standalone.gameengine.geom;

import java.util.HashMap;
import java.util.logging.Level;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec4fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

@Deprecated
public class Gizmo implements UniqueID, Cleanupable, Renderable {

	@Deprecated
	public static final float LINE_WIDTH = 2.5f;

	@Deprecated
	protected final String name;
	@Deprecated
	protected int vao = -1;
	@Deprecated
	protected HashMap<Integer, Integer> vbo = new HashMap<>();

	@Deprecated
	protected Vec3fAttribArray vertices;
	@Deprecated
	protected UIntAttribArray indices;
	@Deprecated
	protected Vec4fAttribArray color;

	@Deprecated
	@Deprecated
	protected int vertexCount, indicesCount;

	/**
	 * Positions are stored as attribArray 0, normals as attribArray 1, uvs as attribArray 2
	 */
	@Deprecated
	public Gizmo(String name, Vec3fAttribArray vertices, UIntAttribArray indices, Vec4fAttribArray color) {
		this.name = name;
		this.vertices = vertices;
		this.indices = indices;
		this.color = color;

		vertexCount = vertices.getLength();
		indicesCount = indices.getLength();

		vao = GL_W.glGenVertexArrays();
		bind();
		storeElementArray(indices);
		vertices.setIndex(0);
		storeAttribArray(vertices);
		color.setIndex(1);
		storeAttribArray(color);
		unbind();

		GlobalLogger.log(Level.INFO, "Gizmo " + name + ": " + vao + " & " + vbo);
	}

	@Deprecated
	protected void storeAttribArray(JavaAttribArray data) {
		vbo.put(data.getIndex(), data.gen());
		data.bind();
		data.init();
		data.enable();
		data.unbind();
	}

	private void storeElementArray(UIntAttribArray indices) {
		if (indices == null)
			throw new NullPointerException("UintAttribArray indices is null");
		indices.setBufferType(BufferType.ELEMENT_ARRAY);
		vbo.put(indices.getIndex(), indices.gen());
		indices.bind();
		indices.init();
	}

	@Deprecated
	public void bind() {
		GL_W.glBindVertexArray(vao);
	}

	@Deprecated
	public void unbind() {
		GL_W.glBindVertexArray(0);
	}

	@Deprecated
	@Override
	public void cleanup() {
		if (vao == -1)
			return;

		GlobalLogger.log("Cleaning up: " + name + " (" + vao + ")");

		GL_W.glDeleteVertexArrays(vao);
		vbo = null;
		vertices.cleanup();
		vertices = null;
		indices.cleanup();
		indices = null;
		vao = -1;
	}

	@Deprecated
	@Override
	public String getId() {
		return name;
	}

	@Deprecated
	public int getVertexCount() {
		return vertexCount;
	}

	@Deprecated
	public int getGlId() {
		return vao;
	}

	@Deprecated
	public HashMap<Integer, Integer> getVbo() {
		return vbo;
	}

	@Deprecated
	public String getName() {
		return name;
	}

	@Deprecated
	public UIntAttribArray getIndices() {
		return indices;
	}

	@Deprecated
	public Vec3fAttribArray getVertices() {
		return vertices;
	}

	@Deprecated
	public Vec4fAttribArray getColor() {
		return color;
	}

	@Deprecated
	public int getIndicesCount() {
		return indicesCount;
	}

	@Deprecated
	public static Gizmo newRect(String name, Vector2f scale, Vector4f textBoxColor) {
		return new Gizmo(name,
				new Vec3fAttribArray("pos",
						0,
						new Vector3f[] {
								new Vector3f(0, 0, 0),
								new Vector3f(scale.x, 0, 0),
								new Vector3f(scale.x, scale.y, 0),
								new Vector3f(0, scale.y, 0) }),
				new UIntAttribArray("ind", -1, new int[] { 0, 1, 1, 2, 2, 3, 3, 0 }),
				new Vec4fAttribArray("color", 1, new Vector4f[] { textBoxColor, textBoxColor, textBoxColor, textBoxColor }));
	}

}
