package lu.kbra.standalone.gameengine.graph.shader.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import lu.kbra.standalone.gameengine.graph.shader.RenderShader;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface AssociatedShader {

	Class<? extends RenderShader> value();

}
