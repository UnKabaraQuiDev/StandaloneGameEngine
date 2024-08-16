package lu.kbra.standalone.gameengine.utils.interpolation;

public interface ValueInterpolator<T> {

	T evaluate(T one, T two, float progress);

}
