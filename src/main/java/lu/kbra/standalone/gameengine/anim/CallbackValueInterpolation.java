package lu.kbra.standalone.gameengine.anim;

import org.joml.Math;

import lu.kbra.standalone.gameengine.utils.MathUtils;
import lu.kbra.standalone.gameengine.utils.interpolation.Interpolator;

public abstract class CallbackValueInterpolation<T, D> {

	public T object;
	public D start, end;
	public float progress = 0f;
	public Interpolator interpolator;

	public CallbackValueInterpolation(T object, D start, D end, Interpolator interpolator) {
		this.object = object;
		this.start = start;
		this.end = end;
		this.interpolator = interpolator;
	}

	public synchronized CallbackValueInterpolation<T, D> set(float x) {
		synchronized (this) {
			progress = x;
		}
		return this;
	}

	public synchronized CallbackValueInterpolation<T, D> add(float x) {
		progress += x;
		return this;
	}

	public CallbackValueInterpolation<T, D> exec() {
		this.callback(object, this.evaluate(interpolator.evaluate(progress)));
		return this;
	}

	public abstract D evaluate(float progress);

	public abstract void callback(T object, D value);

	public synchronized CallbackValueInterpolation<T, D> clamp() {
		progress = Math.clamp(0, 1, progress);
		return this;
	}

	public synchronized CallbackValueInterpolation<T, D> mod() {
		return mod(1);
	}

	public synchronized CallbackValueInterpolation<T, D> mod(float period) {
		progress %= period;
		return this;
	}

	public synchronized CallbackValueInterpolation<T, D> zigzag() {
		return zigzag(1);
	}

	public synchronized CallbackValueInterpolation<T, D> zigzag(float period) {
		progress = MathUtils.zigzag(progress, period);
		return this;
	}

	public void setStart(D start) {
		this.start = start;
	}

	public D getStart() {
		return start;
	}

	public D getEnd() {
		return end;
	}

	public void setEnd(D end) {
		this.end = end;
	}

	public Interpolator getInterpolator() {
		return interpolator;
	}

	public void setInterpolator(Interpolator interpolator) {
		this.interpolator = interpolator;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public float get() {
		return progress;
	}

}
