package lu.kbra.standalone.gameengine.impl.nexttask;

@FunctionalInterface
public interface NextTaskFunction<I, B> {

	B run(I state);

}
