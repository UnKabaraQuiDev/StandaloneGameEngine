package lu.kbra.standalone.gameengine.geom.utils;

import static org.lwjgl.assimp.Assimp.aiGetErrorString;
import static org.lwjgl.assimp.Assimp.aiProcess_FlipUVs;
import static org.lwjgl.assimp.Assimp.aiProcess_JoinIdenticalVertices;
import static org.lwjgl.assimp.Assimp.aiProcess_Triangulate;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.lwjgl.assimp.AIFace;
import org.lwjgl.assimp.AIMesh;
import org.lwjgl.assimp.AIScene;
import org.lwjgl.assimp.AIVector3D;
import org.lwjgl.assimp.Assimp;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec4fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.geom.Gizmo;
import lu.kbra.standalone.gameengine.geom.LoadedMesh;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public final class ObjLoader {

	public record LoadedMeshData(Vec3fAttribArray vertices, UIntAttribArray indices, AttribArray[] attribs, String name,
			Material material) {

	}

	public static Gizmo loadGizmo(String name, String path) {
		String[] lines = PCUtils.readStringFile(path).split("\n");

		List<Vector3f> vertices = new ArrayList<>();
		List<Vector2i> edges = new ArrayList<>();
		List<Vector4f> colors = new ArrayList<>();

		int li = 0;
		while (li < lines.length) {
			String line = lines[li++];
			String[] tokens = line.split("\\s+");

			switch (tokens[0]) {
			case "v":
				vertices.add(new Vector3f(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2]), Float.parseFloat(tokens[3])));
				if (tokens.length > 4)
					colors
							.add(new Vector4f(Float.parseFloat(tokens[4]), Float.parseFloat(tokens[5]), Float.parseFloat(tokens[6]),
									tokens.length > 7 ? Float.parseFloat(tokens[7]) : 1));
				break;
			case "l":
				edges.add(new Vector2i(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
				break;
			}
		}

		if (colors.isEmpty()) {
			colors = null;
		}

		List<Integer> indices = new ArrayList<>();
		Vector3f[] verticesArr = new Vector3f[vertices.size()];
		Vector4f[] colorArr = new Vector4f[vertices.size()];

		for (int i = 0; i < vertices.size(); i++) {
			Vector3f pos = vertices.get(i);

			verticesArr[i] = pos;

			if (colors != null) {
				Vector4f col = colors.get(i);
				colorArr[i] = col;
			}
		}

		for (Vector2i edge : edges) {
			int i1 = edge.x;
			int i2 = edge.y;

			indices.add(i1 - 1);
			indices.add(i2 - 1);
		}
		int[] indicesArr = indices.stream().mapToInt((v) -> v).toArray();

		return new Gizmo(name, new Vec3fAttribArray("pos", 0, verticesArr, BufferType.ARRAY),
				new UIntAttribArray("ind", -1, indicesArr, BufferType.ELEMENT_ARRAY),
				new Vec4fAttribArray("col", 1, colorArr, BufferType.ARRAY));
	}

	public static Mesh loadMesh(String name, Material material, String path) {
		return loadMesh(name, material, path, (t) -> new LoadedMesh(t.name, t.material, t.vertices, t.indices, t.attribs));
	}

	public static <T extends Mesh> T loadMesh(String name, Material material, String path, Function<LoadedMeshData, T> factory) {
		final byte[] data = PCUtils.readBytesSource(path);
		final ByteBuffer buffer = MemoryUtil.memAlloc(data.length).put(data).flip();

		final AIScene scene = Assimp
				.aiImportFileFromMemory(buffer,
						aiProcess_Triangulate/* | aiProcess_GenSmoothNormals */ | aiProcess_FlipUVs | aiProcess_JoinIdenticalVertices,
						PCUtils.getFileExtension(path));

		if (scene == null) {
			throw new RuntimeException("Failed to load OBJ: " + aiGetErrorString());
		}

		List<Vector3f> positionsList = new ArrayList<>();
		List<Vector3f> normalsList = new ArrayList<>();
		List<Vector2f> uvsList = new ArrayList<>();
		List<Integer> indicesList = new ArrayList<>();

		Map<String, Integer> vertexMap = new HashMap<>(); // key = "posIndex/uvIndex/normIndex"

		int globalIndex = 0;

		for (int m = 0; m < scene.mNumMeshes(); m++) {
			AIMesh mesh = AIMesh.create(scene.mMeshes().get(m));

			AIVector3D.Buffer verts = mesh.mVertices();
			AIVector3D.Buffer norms = mesh.mNormals();
			AIVector3D.Buffer texCoords = mesh.mTextureCoords(0);

			for (int f = 0; f < mesh.mNumFaces(); f++) {
				AIFace face = mesh.mFaces().get(f);
				IntBuffer faceIndices = face.mIndices();

				for (int j = 0; j < face.mNumIndices(); j++) {
					int idx = faceIndices.get(j);

					Vector3f pos = new Vector3f(verts.get(idx).x(), verts.get(idx).y(), verts.get(idx).z());

					Vector3f norm = new Vector3f(0, 0, 0);
					if (norms != null) {
						norm = new Vector3f(norms.get(idx).x(), norms.get(idx).y(), norms.get(idx).z());
					}

					Vector2f uv = new Vector2f(0, 0);
					if (texCoords != null) {
						AIVector3D t = texCoords.get(idx);
						uv = new Vector2f(t.x(), 1.0f - t.y()); // flip V
					}

					String key = idx + "/" + uv.x + "/" + uv.y + "/" + norm.x + "/" + norm.y + "/" + norm.z;

					Integer existing = vertexMap.get(key);
					if (existing != null) {
						indicesList.add(existing);
					} else {
						positionsList.add(pos);
						normalsList.add(norm);
						uvsList.add(uv);
						indicesList.add(globalIndex);
						vertexMap.put(key, globalIndex);
						globalIndex++;
					}
				}
			}
		}

		// Convert lists to arrays
		Vector3f[] verticesArr = positionsList.toArray(new Vector3f[0]);
		Vector3f[] normalsArr = normalsList.toArray(new Vector3f[0]);
		Vector2f[] uvsArr = uvsList.toArray(new Vector2f[0]);
		int[] indicesArr = indicesList.stream().mapToInt(i -> i).toArray();

		final Vec3fAttribArray pos = new Vec3fAttribArray("pos", 0, verticesArr, BufferType.ARRAY);
		final UIntAttribArray ind = new UIntAttribArray("ind", -1, indicesArr, BufferType.ELEMENT_ARRAY);
		final Vec3fAttribArray norm = new Vec3fAttribArray("norm", 1, normalsArr, BufferType.ARRAY);
		final Vec2fAttribArray uv = new Vec2fAttribArray("uv", 2, uvsArr, BufferType.ARRAY);

		return factory.apply(new LoadedMeshData(pos, ind, new AttribArray[] { norm, uv }, name, material));
	}

	private static void processFace(String token, List<Vector3i> faces) {
		String[] tokens = token.split("/");
		int len = tokens.length;
		int pos = -1, coords = -1, normals = -1;
		pos = Integer.parseInt(tokens[0]) - 1;
		if (len > 1)
			coords = Integer.parseInt(tokens[1]) - 1;
		if (len > 2)
			normals = Integer.parseInt(tokens[2]) - 1;
		faces.add(new Vector3i(pos, coords, normals));
	}

}
