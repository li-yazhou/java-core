package org.alpha.commons.dbpipe.auxiliary;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String name();
}
