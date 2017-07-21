package book.fkjava.ch14_annotation.demo2;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 20:06
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String value();
}
