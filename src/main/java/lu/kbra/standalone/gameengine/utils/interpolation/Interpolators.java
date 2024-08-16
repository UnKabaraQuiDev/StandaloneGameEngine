package lu.kbra.standalone.gameengine.utils.interpolation;

import org.joml.Math;

public enum Interpolators implements Interpolator {

	LINEAR {
		@Override
		public float evaluate(float x) {
			return Math.clamp(0, 1, x);
		}
		@Override
		public float inverse(float y) {
			return Math.clamp(0, 1, y);
		}
	},

	QUAD_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x * x;
		}
		@Override
		public float inverse(float y) {
			return (float) (Math.sqrt(y));
		}
	},

	QUAD_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return 1 - (1 - x) * (1 - x);
		}

		@Override
		public float inverse(float y) {
			return (float) (1 - Math.sqrt(1 - y));
		}
	},

	QUAD_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x < 0.5 ? 2 * x * x : 1 - 2 * (1 - x) * (1 - x);
		}
		/*@Override
		public float inverse(float y) {
			return y < 0.5 ? Math.sqrt(y/2) : (2-2*Math.sqrt(2-2*y))/2;
		}*/
	},

	CUBIC_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x * x * x;
		}
		@Override
		public float inverse(float y) {
			return (float) java.lang.Math.cbrt(y);
		}
	},

	CUBIC_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return 1 - (1 - x) * (1 - x) * (1 - x);
		}
		/*@Override
		public float inverse(float y) {
			return 1-java.lang.Math.cbrt(1-x);
		}*/
	},

	CUBIC_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x < 0.5 ? 4 * x * x * x : 1 - 4 * (1 - x) * (1 - x) * (1 - x);
		}
		/*@Override
		public float inverse(float y) {
			return y < 0.5 ? java.lang.Math.cbrt(y/4) : 1-java.lang.Math.cbrt((1-y)/4);
		}*/
	},

	SINE_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return (float) (-0.5 * (Math.cos(Math.PI * x) - 1));
		}
	},
	SINE_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return (float) (Math.sin((x * Math.PI) / 2));
		}
	},
	SINE_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return (float) (1 - Math.cos((x * Math.PI) / 2));
		}
	},

	QUART_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x * x * x * x;
		}
	},

	QUART_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return 1 - (1 - x) * (1 - x) * (1 - x) * (1 - x);
		}
	},

	QUART_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x < 0.5 ? 8 * x * x * x * x : 1 - 8 * (1 - x) * (1 - x) * (1 - x) * (1 - x);
		}
	},

	QUINT_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x * x * x * x * x;
		}
	},

	QUINT_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return 1 - (1 - x) * (1 - x) * (1 - x) * (1 - x) * (1 - x);
		}
	},

	QUINT_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return x < 0.5 ? 16 * x * x * x * x * x : 1 - 16 * (1 - x) * (1 - x) * (1 - x) * (1 - x) * (1 - x);
		}
	},

	EXPO_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return (float) java.lang.Math.pow(2, 10 * (x - 1));
		}
	},

	EXPO_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return 1 - (float) java.lang.Math.pow(2, -10 * x);
		}
	},

	EXPO_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			if (x < 0.5) {
				return (float) (0.5 * java.lang.Math.pow(2, 10 * (2 * x - 1)));
			} else {
				return (float) (-0.5 * java.lang.Math.pow(2, -10 * (2 * x - 1)) + 1);
			}
		}
	},

	CIRC_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return 1 - Math.sqrt(1 - x * x);
		}
	},

	CIRC_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return Math.sqrt(1 - (x - 1) * (x - 1));
		}
	},

	CIRC_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			if (x < 0.5) {
				return (float) (0.5 * (1 - Math.sqrt(1 - 4 * x * x)));
			} else {
				return (float) (0.5 * (Math.sqrt(1 - (2 * x - 2) * (2 * x - 2)) + 1));
			}
		}
	},

	BOUNCE_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			return 1 - BOUNCE_OUT.evaluate(1 - x);
		}
	},

	BOUNCE_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			if (x < 1 / 2.75) {
				return 7.5625f * x * x;
			} else if (x < 2 / 2.75) {
				x -= 1.5f / 2.75f;
				return 7.5625f * x * x + 0.75f;
			} else if (x < 2.5 / 2.75) {
				x -= 2.25f / 2.75f;
				return 7.5625f * x * x + 0.9375f;
			} else {
				x -= 2.625f / 2.75f;
				return 7.5625f * x * x + 0.984375f;
			}
		}
	},

	BOUNCE_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			if (x < 0.5f) {
				return 0.5f * BOUNCE_IN.evaluate(x * 2);
			} else {
				return 0.5f * BOUNCE_OUT.evaluate(x * 2 - 1) + 0.5f;
			}
		}
	},

	BACK_IN {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			float s = 1.70158f;
			return x * x * ((s + 1) * x - s);
		}
	},

	BACK_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			float s = 1.70158f;
			x -= 1;
			return x * x * ((s + 1) * x + s) + 1;
		}
	},

	BACK_IN_OUT {
		@Override
		public float evaluate(float x) {
			x = Math.clamp(0, 1, x);
			float s = 1.70158f;
			x *= 2;
			if (x < 1) {
				return 0.5f * (x * x * (((s *= 1.525f) + 1) * x - s));
			} else {
				return 0.5f * ((x -= 2) * x * (((s *= 1.525f) + 1) * x + s) + 2);
			}
		}
	};

	public static float inverse(float closest, Interpolator interpolator, float interval, float _default) {

		float x = interpolator.inverse(closest);
		if (x != -1 && Float.isFinite(x)) {
			return x;
		}

		float closestFound = Float.MAX_VALUE;
		float closestFoundX = -1;

		for (float j = 1; j >= 0; j -= interval) {
			float y = interpolator.evaluate(j);
			if (Math.abs(closest - y) < closestFound) {
				closestFound = Math.abs(closest - y);
				closestFoundX = j;
			}
		}
		return closestFoundX;
	}

}
