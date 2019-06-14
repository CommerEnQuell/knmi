package nl.commerquell.meteo.knmi.objectviews;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Indicates that this class is an object view, based on one or more entity classes,
 * of which one is the primary.
 */

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ObjectView {
	
	Class<?> primaryEntity();
	Class<?>[] otherEntities() default {};

}
