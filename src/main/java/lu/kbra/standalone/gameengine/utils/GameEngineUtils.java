package lu.kbra.standalone.gameengine.utils;

import java.io.PrintStream;
import java.nio.IntBuffer;
import java.util.stream.IntStream;

import org.joml.Matrix3x2f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lwjgl.PointerBuffer;
import org.lwjgl.assimp.AIAnimation;
import org.lwjgl.assimp.AIMaterial;
import org.lwjgl.assimp.AIMesh;
import org.lwjgl.assimp.AINode;
import org.lwjgl.assimp.AIScene;
import org.lwjgl.egl.EGL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.ALC11;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL45;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.GLES30;

import lu.pcy113.pclib.PCUtils;

import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadAccessException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadAllocException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadAttributeException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadConfigException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadContextException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadCurrentSurfaceException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadDisplayException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadMatchException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadNativePixmapException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadNativeWindowException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadParameterException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLBadSurfaceException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLNotInitializedException;
import lu.kbra.standalone.gameengine.exceptions.egl.EGLRuntimeException;
import lu.kbra.standalone.gameengine.exceptions.openal.ALInvalidEnumException;
import lu.kbra.standalone.gameengine.exceptions.openal.ALInvalidNameException;
import lu.kbra.standalone.gameengine.exceptions.openal.ALInvalidOperationException;
import lu.kbra.standalone.gameengine.exceptions.openal.ALInvalidValueException;
import lu.kbra.standalone.gameengine.exceptions.openal.ALOutOfMemoryException;
import lu.kbra.standalone.gameengine.exceptions.openal.ALRuntimeException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLContextLost;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLInvalidEnumException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLInvalidFrameBufferOperationException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLInvalidIndexException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLInvalidOperationException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLInvalidValueException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLOutOfMemoryException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLRuntimeException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLStackOverflowException;
import lu.kbra.standalone.gameengine.exceptions.opengl.GLStackUnderflowException;
import lu.kbra.standalone.gameengine.exceptions.opengles.GLESInvalidEnumException;
import lu.kbra.standalone.gameengine.exceptions.opengles.GLESInvalidFramebufferOperationException;
import lu.kbra.standalone.gameengine.exceptions.opengles.GLESInvalidIndexException;
import lu.kbra.standalone.gameengine.exceptions.opengles.GLESInvalidOperationException;
import lu.kbra.standalone.gameengine.exceptions.opengles.GLESInvalidValueException;
import lu.kbra.standalone.gameengine.exceptions.opengles.GLESOutOfMemoryException;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public final class GameEngineUtils {

	public static <T> T alcNullError(T obj, String string) {
		GameEngineUtils.alcError(obj == null, string);
		return obj;
	}

	public static void alcError(boolean b, String string) {
		if (b) {
			throw new ALRuntimeException(string);
		}
	}

	public static boolean checkAlError() {
		return checkAlError("");
	}

	public static boolean checkAlError(String msg) throws ALRuntimeException {
		int status = AL11.alGetError();

		if (status == AL11.AL_NO_ERROR)
			return true;

		String caller = PCUtils.getCallerClassName(false);

		switch (status) {
		/*
		 * case AL11.AL_INVALID_DEVICE: throw new ALInvalidDeviceException(caller, status, msg);
		 */
		case AL11.AL_INVALID_OPERATION:
			throw new ALInvalidOperationException(caller, status, msg);
		/*
		 * case AL11.AL_INVALID_CONTEXT: throw new ALInvalidContextException(caller, status, msg);
		 */
		case AL11.AL_INVALID_NAME:
			throw new ALInvalidNameException(caller, status, msg);
		case AL11.AL_INVALID_ENUM:
			throw new ALInvalidEnumException(caller, status, msg);
		case AL11.AL_INVALID_VALUE:
			throw new ALInvalidValueException(caller, status, msg);
		case AL11.AL_OUT_OF_MEMORY:
			throw new ALOutOfMemoryException(caller, status, msg);
		default:
			return true;
		}
	}

	public static boolean checkAlcError(long device) {
		boolean b;
		if (b = ALC11.alcGetError(device) != ALC11.ALC_NO_ERROR)
			throw new RuntimeException("Alc error triggered: " + AL11.alGetError());
		return b;
	}

	public static boolean checkGlESError() {
		return checkGlESError("");
	}

	public static boolean checkGlESError(String msg) {
		int status = GLES20.glGetError();

		if (status == GLES20.GL_NO_ERROR)
			return true;

		String caller = PCUtils.getCallerClassName(false);

		switch (status) {
		case GLES30.GL_INVALID_OPERATION:
			throw new GLESInvalidOperationException(caller, status, msg);
		case GLES30.GL_INVALID_INDEX:
			throw new GLESInvalidIndexException(caller, status, msg);
		case GLES30.GL_INVALID_ENUM:
			throw new GLESInvalidEnumException(caller, status, msg);
		case GLES30.GL_INVALID_VALUE:
			throw new GLESInvalidValueException(caller, status, msg);
		case GLES30.GL_INVALID_FRAMEBUFFER_OPERATION:
			throw new GLESInvalidFramebufferOperationException(caller, status, msg);
		case GLES30.GL_OUT_OF_MEMORY:
			throw new GLESOutOfMemoryException(caller, status, msg);
		default:
			return true;

		}

	}

	public static boolean checkEGLError(String msg) {
		int status = EGL10.eglGetError();

		if (status == EGL10.EGL_SUCCESS)
			return true;

		String caller = PCUtils.getCallerClassName(false);

		switch (status) {
		case EGL10.EGL_NOT_INITIALIZED:
			throw new EGLNotInitializedException(caller, status, msg);
		case EGL10.EGL_BAD_ACCESS:
			throw new EGLBadAccessException(caller, status, msg);
		case EGL10.EGL_BAD_ATTRIBUTE:
			throw new EGLBadAttributeException(caller, status, msg);
		case EGL10.EGL_BAD_ALLOC:
			throw new EGLBadAllocException(caller, status, msg);
		case EGL10.EGL_BAD_CONTEXT:
			throw new EGLBadContextException(caller, status, msg);
		case EGL10.EGL_BAD_CONFIG:
			throw new EGLBadConfigException(caller, status, msg);
		case EGL10.EGL_BAD_CURRENT_SURFACE:
			throw new EGLBadCurrentSurfaceException(caller, status, msg);
		case EGL10.EGL_BAD_DISPLAY:
			throw new EGLBadDisplayException(caller, status, msg);
		case EGL10.EGL_BAD_SURFACE:
			throw new EGLBadSurfaceException(caller, status, msg);
		case EGL10.EGL_BAD_MATCH:
			throw new EGLBadMatchException(caller, status, msg);
		case EGL10.EGL_BAD_PARAMETER:
			throw new EGLBadParameterException(caller, status, msg);
		case EGL10.EGL_BAD_NATIVE_PIXMAP:
			throw new EGLBadNativePixmapException(caller, status, msg);
		case EGL10.EGL_BAD_NATIVE_WINDOW:
			throw new EGLBadNativeWindowException(caller, status, msg);
		/*
		 * case EGL10.EGL_NO_CONTEXT: throw new EGLNoContextException(caller, status, msg);
		 */
		default:
			return true;
		}
	}

	public static void throwGLESError(String string) {
		throw new EGLRuntimeException(string);
	}

	public static boolean checkGlError() {
		return checkGlError("");
	}

	public static boolean checkGlError(String msg) {
		final int status = GL_W.glGetError();

		if (status == GL_W.GL_NO_ERROR)
			return true;

		GL_W.glGetError(); // to clear
		
		switch (status) {
		case GL40.GL_INVALID_OPERATION:
			throw new GLInvalidOperationException(status, msg);
		case GL40.GL_INVALID_INDEX:
			throw new GLInvalidIndexException(status, msg);
		case GL40.GL_INVALID_ENUM:
			throw new GLInvalidEnumException(status, msg);
		case GL40.GL_INVALID_VALUE:
			throw new GLInvalidValueException(status, msg);
		case GL40.GL_INVALID_FRAMEBUFFER_OPERATION:
			throw new GLInvalidFrameBufferOperationException(status, msg);
		case GL40.GL_STACK_OVERFLOW:
			throw new GLStackOverflowException(status, msg);
		case GL40.GL_STACK_UNDERFLOW:
			throw new GLStackUnderflowException(status, msg);
		case GL40.GL_OUT_OF_MEMORY:
			throw new GLOutOfMemoryException(status, msg);
		case GL45.GL_CONTEXT_LOST:
			throw new GLContextLost(status, msg);
		default:
			return true;
		}
	}

	public static void throwGLError(String string) {
		throw new GLRuntimeException(string);
	}

	public static int[] intCountingUp(int start, int end) {
		int[] in = new int[end - start];
		for (int i = 0; i < in.length; i++)
			in[i] = start + i;
		return in;
	}

	public static int[] intCountingUpTriQuads(int quadCount) {
		int[] in = new int[quadCount * 6];
		for (int q = 0; q < quadCount; q++) {
			in[q * 6 + 0] = q * 4 + 0;
			in[q * 6 + 1] = q * 4 + 1;
			in[q * 6 + 2] = q * 4 + 2;
			in[q * 6 + 3] = q * 4 + 0;
			in[q * 6 + 4] = q * 4 + 2;
			in[q * 6 + 5] = q * 4 + 3;
		}
		return in;
	}

	public static Vector2f[] vec2Repeating(Vector2f[] is, int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size should be greater than 0");
		}

		int originalLength = is.length;
		int repeatedLength = originalLength * size;
		Vector2f[] result = new Vector2f[repeatedLength];

		for (int i = 0; i < size; i++) {
			System.arraycopy(is, 0, result, i * originalLength, originalLength);
		}

		return result;
	}

	public static Matrix4f[] castArrayMat4f(Object[] transforms) {
		Matrix4f[] t = new Matrix4f[transforms.length];
		for (int i = 0; i < transforms.length; i++)
			t[i] = (Matrix4f) transforms[i];
		return t;
	}

	public static Matrix3x2f[] castArrayMat3x2f(Object[] transforms) {
		Matrix3x2f[] t = new Matrix3x2f[transforms.length];
		for (int i = 0; i < transforms.length; i++)
			t[i] = (Matrix3x2f) transforms[i];
		return t;
	}

	public static Vector3f[] floatArrayToVec3f(float[] arr) {
		return IntStream
				.range(0, arr.length / 3)
				.mapToObj(i -> new Vector3f(arr[i * 3 + 0], arr[i * 3 + 1], arr[i * 3 + 2]))
				.toArray(Vector3f[]::new);
	}

	public static Vector2f[] floatArrayToVec2f(float[] arr) {
		return IntStream.range(0, arr.length / 2).mapToObj(i -> new Vector2f(arr[i * 2 + 0], arr[i * 2 + 1])).toArray(Vector2f[]::new);
	}

	public static Vector3f[] intArrayToVec3f(int[] arr) {
		return IntStream
				.range(0, arr.length / 3)
				.mapToObj(i -> new Vector3f(arr[i * 3 + 0], arr[i * 3 + 1], arr[i * 3 + 2]))
				.toArray(Vector3f[]::new);
	}

	public static Vector2f getCoordinates(Vector2f in, int[] viewport) {
		return new Vector2f(in.x, viewport[3] - in.y);
	}

	public static Vector3f getCoordinates(Vector3f in, int[] viewport) {
		return new Vector3f(in.x, viewport[3] - in.y, in.z);
	}

	public static Vector2f loadRangeFloat(JSONObject sobj, String key) {
		JSONArray arr = sobj.getJSONArray(key);
		return new Vector2f(arr.getFloat(0), arr.getFloat(1));
	}

	public static Vector2f clamp(Vector2f vec) {
		return vec.set(PCUtils.clamp(0, 1, vec.x), PCUtils.clamp(0, 1, vec.y));
	}

	public static Vector3f clampPositive(Vector3f vec) {
		return vec
				.set(PCUtils.clampGreaterOrEquals(0, vec.x),
						PCUtils.clampGreaterOrEquals(0, vec.y),
						PCUtils.clampGreaterOrEquals(0, vec.z));
	}

	public static Vector2f normalizeGreater(Vector2f vec) {
		if (vec.lengthSquared() > 1) {
			return vec.normalize();
		}
		return vec;
	}

	public static Vector2i parseVec2i(String property, Vector2i else_) {
		try {
			String[] tokens = property.split(":");
			return new Vector2i(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		} catch (Exception e) {
			return else_;
		}
	}

	public static Vector2f getYDown(Vector2f vec) {
		if (vec.y > -vec.y) {
			return vec.mul(-1);
		}
		return vec;
	}

	public static void list(AIScene scene, PrintStream out) {
		// List meshes
		int numMeshes = scene.mNumMeshes();
		PointerBuffer meshes = scene.mMeshes();
		out.println("Meshes (" + numMeshes + "):");
		for (int i = 0; i < numMeshes; i++) {
			AIMesh mesh = AIMesh.create(meshes.get(i));
			out.println("  Mesh " + i + ": vertices=" + mesh.mNumVertices() + ", faces=" + mesh.mNumFaces());
		}

		// List materials
		int numMaterials = scene.mNumMaterials();
		PointerBuffer materials = scene.mMaterials();
		out.println("Materials (" + numMaterials + "):");
		for (int i = 0; i < numMaterials; i++) {
			AIMaterial material = AIMaterial.create(materials.get(i));
			out.println("  Material " + i);
		}

		// List animations
		int numAnimations = scene.mNumAnimations();
		PointerBuffer animations = scene.mAnimations();
		out.println("Animations (" + numAnimations + "):");
		for (int i = 0; i < numAnimations; i++) {
			AIAnimation animation = AIAnimation.create(animations.get(i));
			out.println("  Animation " + i + ": duration=" + animation.mDuration() + ", ticksPerSecond=" + animation.mTicksPerSecond());
		}

		// List nodes recursively
		out.println("Node Hierarchy:");
		listNode(scene.mRootNode(), 0, out);
	}

	private static void listNode(AINode node, int level, PrintStream out) {
		String indent = PCUtils.repeatString("  ", level);
		out.println(indent + "Node: " + node.mName().dataString());

		// List meshes attached to this node
		int numMeshes = node.mNumMeshes();
		IntBuffer meshes = node.mMeshes();
		for (int i = 0; i < numMeshes; i++) {
			out.println(indent + "  Mesh Index: " + meshes.get(i));
		}

		// Recursively list child nodes
		int numChildren = node.mNumChildren();
		PointerBuffer children = node.mChildren();
		for (int i = 0; i < numChildren; i++) {
			listNode(AINode.create(children.get(i)), level + 1, out);
		}
	}

}