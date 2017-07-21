package book.fkjava.ch14_annotation;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-12 20:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Persistent {
    String table() default "";
}
