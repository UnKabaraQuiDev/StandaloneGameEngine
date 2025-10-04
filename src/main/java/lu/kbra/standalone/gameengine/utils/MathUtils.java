package lu.kbra.standalone.gameengine.utils;

import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.GameEngine;

public final class MathUtils {

	public static float map(float x, float in_min, float in_max, float out_min, float out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}

	public static double map(double x, double in_min, double in_max, double out_min, double out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}

	public static float snap(float x, float interval) {
		return Math.round(x / interval) * interval;
	}

	public static boolean compare(float a, float b, float epsilon) {
		return Math.abs(a - b) <= epsilon;
	}

	public static Vector3f vec3fromQuatf(Quaternionf rotation) {
		return rotation.transform(GameEngine.Z_POS, new Vector3f());
	}

	public static int greatestAbsIndex(float... arr) {
		int index = -1;
		float max = Float.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i]) > max) {
				index = i;
				max = Math.abs(arr[i]);
			}
		}
		return index;
	}

	public static int greatestAbsIndex(byte... arr) {
		int index = -1;
		byte max = Byte.MIN_VALUE, min = Byte.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i]) > max) {
				index = i;
				max = (byte) Math.abs(arr[i]);
			}
			if (Math.abs(arr[i]) < min) {
				min = (byte) Math.abs(arr[i]);
			}
		}
		return min != max ? index : -1;
	}

	public static float greatestAbs(byte... arr) {
		byte max = Byte.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i]) > max) {
				max = (byte) Math.abs(arr[i]);
			}
		}
		return max;
	}

	public static byte sum(byte... arr) {
		byte sum = Byte.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += (byte) Math.abs(arr[i]);
		}
		return sum;
	}

	public static String fillPrefix(int desiredLength, char c, String string) {
		if (string.length() >= desiredLength)
			return string;
		int missing = desiredLength - string.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < missing; i++) {
			sb.append(c);
		}
		return sb.toString() + string;
	}

	public static boolean rangeContains(float value, Vector2f range) {
		return range.x < value && value < range.y;
	}

	public static float zigzag(float x, float period) {
		return x % 2 * period < period ? x % period : period - x % period;
	}

	public static float zigzagNormalized(float x, float period) {
		return zigzag(x, period) / period;
	}

	public static Vector2f rotate(Vector2f v, float deg) {
		float rad = (float) Math.toRadians(deg);
		float cos = (float) Math.cos(rad);
		float sin = (float) Math.sin(rad);
		float xNew = v.x * cos - v.y * sin;
		float yNew = v.x * sin + v.y * cos;
		v.set(xNew, yNew);
		
		return v;
	}

}
