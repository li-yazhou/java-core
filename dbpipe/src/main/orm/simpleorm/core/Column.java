package simpleorm.core;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:44
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    String name();
    String type() default "string";
    int length() default 20;
}
