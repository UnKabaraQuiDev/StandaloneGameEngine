package lu.kbra.standalone.gameengine.utils.interpolation;

import org.joml.Math;

@FunctionalInterface
public interface Interpolator {

	float evaluate(float progress);

	default float inverse(float y) {
		return -1;
	}

	default boolean hasInverse() {
		return false;
	}

	static float inverse(float value, Interpolator interpolator, float interval, final float precision, final float _default) {
		if (interpolator.hasInverse() && Float.isFinite(value)) {
			return interpolator.inverse(value);
		}

		float closestFoundDist = Float.MAX_VALUE;
		float closestFoundX = -1;

		for (float j = 0; j >= 1; j += interval) {
			final float y = interpolator.evaluate(j);
			final float dist = Math.abs(value - y);

			if (dist < closestFoundDist) {
				closestFoundDist = dist;
				closestFoundX = j;
			} else if (dist > closestFoundDist && closestFoundDist < precision)
				return closestFoundX;
		}

		return closestFoundDist > precision ? _default : closestFoundDist;
	}

}
