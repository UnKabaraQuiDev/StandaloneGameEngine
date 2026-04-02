package lu.kbra.standalone.gameengine.utils;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.swing.GroupLayout.Alignment;

import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.joml.Vector4i;
import org.joml.Vector4ic;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lwjgl.egl.EGL10;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL45;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.GLES30;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
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
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.geom.BoundingBox;

public final class GameEngineUtils {

	public static <T> T alcNullError(final T obj, final String string) {
		GameEngineUtils.alcError(obj == null, string);
		return obj;
	}

	public static void alcError(final boolean b, final String string) {
		if (b) {
			throw new ALRuntimeException(string);
		}
	}

	public static boolean checkAlError() {
		return checkAlError("");
	}

	public static boolean checkAlError(final String msg) throws ALRuntimeException {
		final int status = AL10.alGetError();

		if (status == AL10.AL_NO_ERROR)
			return true;

		final String caller = PCUtils.getCallerClassName(false);

		switch (status) {
		/*
		 * case AL11.AL_INVALID_DEVICE: throw new ALInvalidDeviceException(caller, status, msg);
		 */
		case AL10.AL_INVALID_OPERATION:
			throw new ALInvalidOperationException(caller, status, msg);
		/*
		 * case AL11.AL_INVALID_CONTEXT: throw new ALInvalidContextException(caller, status, msg);
		 */
		case AL10.AL_INVALID_NAME:
			throw new ALInvalidNameException(caller, status, msg);
		case AL10.AL_INVALID_ENUM:
			throw new ALInvalidEnumException(caller, status, msg);
		case AL10.AL_INVALID_VALUE:
			throw new ALInvalidValueException(caller, status, msg);
		case AL10.AL_OUT_OF_MEMORY:
			throw new ALOutOfMemoryException(caller, status, msg);
		default:
			return true;
		}
	}

	public static boolean checkAlcError(final long device) {
		boolean b;
		if (b = ALC10.alcGetError(device) != ALC10.ALC_NO_ERROR)
			throw new RuntimeException("Alc error triggered: " + AL10.alGetError());
		return b;
	}

	public static boolean checkGlESError() {
		return checkGlESError("");
	}

	public static boolean checkGlESError(final String msg) {
		final int status = GLES20.glGetError();

		if (status == GLES20.GL_NO_ERROR)
			return true;

		final String caller = PCUtils.getCallerClassName(false);

		switch (status) {
		case GLES20.GL_INVALID_OPERATION:
			throw new GLESInvalidOperationException(caller, status, msg);
		case GLES30.GL_INVALID_INDEX:
			throw new GLESInvalidIndexException(caller, status, msg);
		case GLES20.GL_INVALID_ENUM:
			throw new GLESInvalidEnumException(caller, status, msg);
		case GLES20.GL_INVALID_VALUE:
			throw new GLESInvalidValueException(caller, status, msg);
		case GLES20.GL_INVALID_FRAMEBUFFER_OPERATION:
			throw new GLESInvalidFramebufferOperationException(caller, status, msg);
		case GLES20.GL_OUT_OF_MEMORY:
			throw new GLESOutOfMemoryException(caller, status, msg);
		default:
			return true;

		}

	}

	public static boolean checkEGLError(final String msg) {
		final int status = EGL10.eglGetError();

		if (status == EGL10.EGL_SUCCESS)
			return true;

		final String caller = PCUtils.getCallerClassName(false);

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

	public static void throwGLESError(final String string) {
		throw new EGLRuntimeException(string);
	}

	public static boolean checkGlError() {
		return checkGlError("");
	}

	public static boolean checkGlError(final String msg) {
		final int status = GL_W.glGetError();

		if (status == GL_W.GL_NO_ERROR)
			return true;

		// GL_W.glGetError(); // to clear

		switch (status) {
		case GL11.GL_INVALID_OPERATION:
			throw new GLInvalidOperationException(status, msg);
		case GL31.GL_INVALID_INDEX:
			throw new GLInvalidIndexException(status, msg);
		case GL11.GL_INVALID_ENUM:
			throw new GLInvalidEnumException(status, msg);
		case GL11.GL_INVALID_VALUE:
			throw new GLInvalidValueException(status, msg);
		case GL30.GL_INVALID_FRAMEBUFFER_OPERATION:
			throw new GLInvalidFrameBufferOperationException(status, msg);
		case GL11.GL_STACK_OVERFLOW:
			throw new GLStackOverflowException(status, msg);
		case GL11.GL_STACK_UNDERFLOW:
			throw new GLStackUnderflowException(status, msg);
		case GL11.GL_OUT_OF_MEMORY:
			throw new GLOutOfMemoryException(status, msg);
		case GL45.GL_CONTEXT_LOST:
			throw new GLContextLost(status, msg);
		default:
			return true;
		}
	}

	public static void throwGLError(final String string) {
		throw new GLRuntimeException(string);
	}

	public static int[] intCountingUp(final int start, final int end) {
		final int[] in = new int[end - start];
		for (int i = 0; i < in.length; i++)
			in[i] = start + i;
		return in;
	}

	public static int[] intCountingUpTriQuads(final int quadCount) {
		final int[] in = new int[quadCount * 6];
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

	public static Vector2f[] vec2Repeating(final Vector2f[] is, final int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size should be greater than 0");
		}

		final int originalLength = is.length;
		final int repeatedLength = originalLength * size;
		final Vector2f[] result = new Vector2f[repeatedLength];

		for (int i = 0; i < size; i++) {
			System.arraycopy(is, 0, result, i * originalLength, originalLength);
		}

		return result;
	}

	public static Vector4f[] vec4Repeating(final Vector4f[] is, final int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size should be greater than 0");
		}

		final int originalLength = is.length;
		final int repeatedLength = originalLength * size;
		final Vector4f[] result = new Vector4f[repeatedLength];

		for (int i = 0; i < size; i++) {
			System.arraycopy(is, 0, result, i * originalLength, originalLength);
		}

		return result;
	}

	public static Matrix4f[] castArrayMat4f(final Object transforms) {
		if (transforms instanceof Matrix4f[]) {
			return (Matrix4f[]) transforms;
		}
		return Arrays.stream((Object[]) transforms).map(c -> (Matrix4f) c).toArray(Matrix4f[]::new);
	}

	public static Matrix3x2f[] castArrayMat3x2f(final Object transforms) {
		if (transforms instanceof Matrix4f[]) {
			return (Matrix3x2f[]) transforms;
		}
		return Arrays.stream((Object[]) transforms).map(c -> (Matrix3x2f) c).toArray(Matrix3x2f[]::new);
	}

	public static Vector3f[] floatArrayToVec3f(final float[] arr) {
		return IntStream.range(0, arr.length / 3)
				.mapToObj(i -> new Vector3f(arr[i * 3 + 0], arr[i * 3 + 1], arr[i * 3 + 2]))
				.toArray(Vector3f[]::new);
	}

	public static Vector2f[] floatArrayToVec2f(final float[] arr) {
		return IntStream.range(0, arr.length / 2).mapToObj(i -> new Vector2f(arr[i * 2 + 0], arr[i * 2 + 1])).toArray(Vector2f[]::new);
	}

	public static Vector3f[] intArrayToVec3f(final int[] arr) {
		return IntStream.range(0, arr.length / 3)
				.mapToObj(i -> new Vector3f(arr[i * 3 + 0], arr[i * 3 + 1], arr[i * 3 + 2]))
				.toArray(Vector3f[]::new);
	}

	public static Vector2f getCoordinates(final Vector2f in, final int[] viewport) {
		return new Vector2f(in.x, viewport[3] - in.y);
	}

	public static Vector3f getCoordinates(final Vector3f in, final int[] viewport) {
		return new Vector3f(in.x, viewport[3] - in.y, in.z);
	}

	public static Vector2f loadRangeFloat(final JSONObject sobj, final String key) {
		final JSONArray arr = sobj.getJSONArray(key);
		return new Vector2f(arr.getFloat(0), arr.getFloat(1));
	}

	public static Vector2f clamp(final Vector2f vec) {
		return vec.set(PCUtils.clamp(0, 1, vec.x), PCUtils.clamp(0, 1, vec.y));
	}

	public static Vector3f clampPositive(final Vector3f vec) {
		return vec.set(PCUtils.clampGreaterOrEquals(0, vec.x),
				PCUtils.clampGreaterOrEquals(0, vec.y),
				PCUtils.clampGreaterOrEquals(0, vec.z));
	}

	public static Vector2f normalizeGreater(final Vector2f vec) {
		if (vec.lengthSquared() > 1) {
			return vec.normalize();
		}
		return vec;
	}

	public static Vector2i parseVec2i(final String property, final Vector2i else_) {
		try {
			final String[] tokens = property.split(":");
			return new Vector2i(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		} catch (final Exception e) {
			return else_;
		}
	}

	public static Vector2f getYDown(final Vector2f vec) {
		if (vec.y > -vec.y) {
			return vec.mul(-1);
		}
		return vec;
	}

	public static Vector3f jsonArrayToVec3f(final JSONArray jsonArray) {
		if (jsonArray == null)
			return new Vector3f(0);
		return new Vector3f(jsonArray.getFloat(0), jsonArray.getFloat(1), jsonArray.getFloat(2));
	}

	public static Quaternionf jsonArrayToQuatf(final JSONArray jsonArray) {
		if (jsonArray == null)
			return new Quaternionf();
		return new Quaternionf(jsonArray.getFloat(0), jsonArray.getFloat(1), jsonArray.getFloat(2), jsonArray.getFloat(3));
	}

	public static int[] toFlatArray(final Vector2i[] data) {
		final int[] flatArray = new int[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			final Vector2i cdata = data[i];
			if (cdata != null) {
				flatArray[i * 2] = cdata.x;
				flatArray[i * 2 + 1] = cdata.y;
			}
		}
		return flatArray;
	}

	public static int[] toFlatArray(final Vector3i[] data) {
		final int[] flatArray = new int[data.length * 3];
		for (int i = 0; i < data.length; i++) {
			final Vector3i cdata = data[i];
			if (cdata != null) {
				flatArray[i * 3] = cdata.x;
				flatArray[i * 3 + 1] = cdata.y;
				flatArray[i * 3 + 2] = cdata.z;
			}
		}
		return flatArray;
	}

	public static int[] toFlatArray(final Vector4i[] data) {
		final int[] flatArray = new int[data.length * 4];
		for (int i = 0; i < data.length; i++) {
			final Vector4i cdata = data[i];
			if (cdata != null) {
				flatArray[i * 4] = cdata.x;
				flatArray[i * 4 + 1] = cdata.y;
				flatArray[i * 4 + 2] = cdata.z;
				flatArray[i * 4 + 3] = cdata.z;
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Vector2f[] data) {
		final float[] flatArray = new float[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			final Vector2f cdata = data[i];
			if (cdata != null) {
				flatArray[i * 2] = cdata.x;
				flatArray[i * 2 + 1] = cdata.y;
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Vector3f[] data) {
		final float[] flatArray = new float[data.length * 3];
		for (int i = 0; i < data.length; i++) {
			final Vector3f cdata = data[i];
			if (cdata != null) {
				flatArray[i * 3] = cdata.x;
				flatArray[i * 3 + 1] = cdata.y;
				flatArray[i * 3 + 2] = cdata.z;
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Vector4f[] data) {
		final float[] flatArray = new float[data.length * 4];
		for (int i = 0; i < data.length; i++) {
			final Vector4f cdata = data[i];
			if (cdata != null) {
				flatArray[i * 4] = cdata.x;
				flatArray[i * 4 + 1] = cdata.y;
				flatArray[i * 4 + 2] = cdata.z;
				flatArray[i * 4 + 3] = cdata.z;
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Matrix4f[] data) {
		final float[] flatArray = new float[data.length * 16];
		for (int i = 0; i < data.length; i++) {
			final float[] dat = new float[16];
			if (data[i] != null)
				data[i].get(dat);
			System.arraycopy(dat, 0, flatArray, i * 16, 16);
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Matrix3x2f[] data) {
		final float[] flatArray = new float[data.length * 6];
		for (int i = 0; i < data.length; i++) {
			final float[] dat = new float[3 * 2];
			data[i].get(dat);
			System.arraycopy(dat, 0, flatArray, i * 6, 6);
		}
		return flatArray;
	}

	// --

	public static int[] toFlatArray(final Vector2ic[] data) {
		final int[] flatArray = new int[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			final Vector2ic cdata = data[i];
			if (cdata != null) {
				flatArray[i * 2] = cdata.x();
				flatArray[i * 2 + 1] = cdata.y();
			}
		}
		return flatArray;
	}

	public static int[] toFlatArray(final Vector3ic[] data) {
		final int[] flatArray = new int[data.length * 3];
		for (int i = 0; i < data.length; i++) {
			final Vector3ic cdata = data[i];
			if (cdata != null) {
				flatArray[i * 3] = cdata.x();
				flatArray[i * 3 + 1] = cdata.y();
				flatArray[i * 3 + 2] = cdata.z();
			}
		}
		return flatArray;
	}

	public static int[] toFlatArray(final Vector4ic[] data) {
		final int[] flatArray = new int[data.length * 4];
		for (int i = 0; i < data.length; i++) {
			final Vector4ic cdata = data[i];
			if (cdata != null) {
				flatArray[i * 4] = cdata.x();
				flatArray[i * 4 + 1] = cdata.y();
				flatArray[i * 4 + 2] = cdata.z();
				flatArray[i * 4 + 3] = cdata.w();
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Vector2fc[] data) {
		final float[] flatArray = new float[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			final Vector2fc cdata = data[i];
			if (cdata != null) {
				flatArray[i * 2] = cdata.x();
				flatArray[i * 2 + 1] = cdata.y();
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Vector3fc[] data) {
		final float[] flatArray = new float[data.length * 3];
		for (int i = 0; i < data.length; i++) {
			final Vector3fc cdata = data[i];
			if (cdata != null) {
				flatArray[i * 3] = cdata.x();
				flatArray[i * 3 + 1] = cdata.y();
				flatArray[i * 3 + 2] = cdata.z();
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Vector4fc[] data) {
		final float[] flatArray = new float[data.length * 4];
		for (int i = 0; i < data.length; i++) {
			final Vector4fc cdata = data[i];
			if (cdata != null) {
				flatArray[i * 4] = cdata.x();
				flatArray[i * 4 + 1] = cdata.y();
				flatArray[i * 4 + 2] = cdata.z();
				flatArray[i * 4 + 3] = cdata.w();
			}
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Matrix4fc[] data) {
		final float[] flatArray = new float[data.length * 16];
		for (int i = 0; i < data.length; i++) {
			final float[] dat = new float[16];
			if (data[i] != null)
				data[i].get(dat);
			System.arraycopy(dat, 0, flatArray, i * 16, 16);
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Matrix3x2fc[] data) {
		final float[] flatArray = new float[data.length * 6];
		for (int i = 0; i < data.length; i++) {
			final float[] dat = new float[3 * 2];
			data[i].get(dat);
			System.arraycopy(dat, 0, flatArray, i * 6, 6);
		}
		return flatArray;
	}

	public static float[] toFlatArray(final Vector3f[] data, final int padLength) {
		if (padLength < 3)
			throw new IllegalArgumentException("padLength must be >= 3");

		final float[] flatArray = new float[data.length * padLength];
		for (int i = 0; i < data.length; i++) {
			final Vector3f cdata = data[i];
			final int offset = i * padLength;
			if (cdata != null) {
				flatArray[offset] = cdata.x;
				flatArray[offset + 1] = cdata.y;
				flatArray[offset + 2] = cdata.z;
				// remaining floats up to padLength remain 0
			}
		}
		return flatArray;
	}

	public static Vector2f normalizeSize(final float width, final float height) {
		final float max = Math.max(width, height);
		return new Vector2f(width / max, height / max);
	}

	public static Rectangle2D.Float toRectangleBounds(final Vector2fc size, final Alignment horizontal, final Alignment vertical) {
		float x = 0;
		float y = 0;

		if (horizontal == Alignment.LEADING) {
			x = 0;
		} else if (horizontal == Alignment.CENTER) {
			x = -size.x() / 2f;
		} else if (horizontal == Alignment.TRAILING) {
			x = -size.x();
		}

		if (vertical == Alignment.LEADING) {
			y = 0;
		} else if (vertical == Alignment.CENTER) {
			y = -size.y() / 2f;
		} else if (vertical == Alignment.TRAILING) {
			y = -size.y();
		}

		return new Rectangle2D.Float(x, y, size.x(), size.y());
	}

	public static BoundingBox getBoundingBox(final Vec3fAttribArray vertices) {
		final Vector3f min = new Vector3f(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
		final Vector3f max = new Vector3f(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

		boolean nonNull = false;
		for (final Vector3f v : vertices.getData()) {
			if (v == null) {
				continue;
			}

			nonNull = true;

			min.x = Math.min(min.x, v.x);
			min.y = Math.min(min.y, v.y);
			min.z = Math.min(min.z, v.z);

			max.x = Math.max(max.x, v.x);
			max.y = Math.max(max.y, v.y);
			max.z = Math.max(max.z, v.z);
		}

		if (nonNull) {
			return new BoundingBox(min, max);
		} else {
			return new BoundingBox(new Vector3f(0), new Vector3f(0));
		}
	}

	public static Vector4f hexToColorToVec4f(final String hex) {
		return colorToVec4f(PCUtils.hexToColor(hex));
	}

	public static Vector4f hexToColorToVec4f(final String hex, final Vector4f v) {
		return colorToVec4f(PCUtils.hexToColor(hex), v);
	}

	public static Vector4f colorToVec4f(final Color c) {
		return new Vector4f(c.getRed() / 255.0f, c.getGreen() / 255.0f, c.getBlue() / 255.0f, c.getAlpha() / 255.0f);
	}

	public static Vector4f rgbToVec4f(final int argb) {
		final float a = ((argb >> 24) & 0xFF) / 255.0f;
		final float r = ((argb >> 16) & 0xFF) / 255.0f;
		final float g = ((argb >> 8) & 0xFF) / 255.0f;
		final float b = (argb & 0xFF) / 255.0f;

		return new Vector4f(r, g, b, a);
	}

	public static Vector4f colorToVec4f(final Color c, final Vector4f v) {
		return v.set(c.getRed() / 255.0f, c.getGreen() / 255.0f, c.getBlue() / 255.0f, c.getAlpha() / 255.0f);
	}

	public static Vector4f hsvToColorToVec4f(float h, final float s, final float v, final float a) {
		h = h - (float) Math.floor(h); // wrap hue to [0,1)

		float r, g, b;

		if (s == 0.0f) {
			r = g = b = v;
		} else {
			final float hf = h * 6.0f;
			final int i = (int) hf;
			final float f = hf - i;

			final float p = v * (1.0f - s);
			final float q = v * (1.0f - s * f);
			final float t = v * (1.0f - s * (1.0f - f));

			switch (i) {
			case 0 -> {
				r = v;
				g = t;
				b = p;
			}
			case 1 -> {
				r = q;
				g = v;
				b = p;
			}
			case 2 -> {
				r = p;
				g = v;
				b = t;
			}
			case 3 -> {
				r = p;
				g = q;
				b = v;
			}
			case 4 -> {
				r = t;
				g = p;
				b = v;
			}
			default -> {
				r = v;
				g = p;
				b = q;
			}
			}
		}

		return new Vector4f(r, g, b, a);
	}

	@Deprecated
	public static Vector2f clone(final Vector2fc vec) {
		return vec instanceof Vector4f ? (Vector2f) vec : new Vector2f(vec);
	}

	@Deprecated
	public static Vector3f clone(final Vector3fc vec) {
		return vec instanceof Vector3f ? (Vector3f) vec : new Vector3f(vec);
	}

	@Deprecated
	public static Vector4f clone(final Vector4fc vec) {
		return vec instanceof Vector4f ? (Vector4f) vec : new Vector4f(vec);
	}

	public static Vector3f randomVector3f() {
		return new Vector3f((float) Math.random() * 2 - 1, (float) Math.random() * 2 - 1, (float) Math.random() * 2 - 1).normalize();
	}

	public static Quaternionf randomQuaterionf() {
		return new Quaternionf().rotateXYZ((float) Math.random() * (float) Math.PI * 2f,
				(float) Math.random() * (float) Math.PI * 2f,
				(float) Math.random() * (float) Math.PI * 2f);
	}

	public static float halfFloatToFloat(final short half) {
		return switch ((int) half) {
		case 0x0000 -> 0.0f;
		case 0x8000 -> -0.0f;
		case 0x7c00 -> Float.POSITIVE_INFINITY;
		case 0xfc00 -> Float.NEGATIVE_INFINITY;
		default -> Float.intBitsToFloat(((half & 0x8000) << 16) | (((half & 0x7c00) + 0x1C000) << 13) | ((half & 0x03FF) << 13));
		};
	}

}
