package fkjava.ch14_annotation;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-12 20:35
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Property {
    String column() default "";
    String type() default  "string";
}
