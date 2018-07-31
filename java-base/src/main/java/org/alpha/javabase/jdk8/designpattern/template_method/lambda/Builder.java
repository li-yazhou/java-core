package org.alpha.javabase.jdk8.designpattern.template_method.lambda;

import java.util.function.Function;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:45
 */
public class Builder {

    public String build(String id, Function<String, String> function) {
        System.out.println("root node  = " + id);

        String childNodeName = function.apply(id);

        System.out.println(childNodeName);

        return id + "_" + childNodeName;
    }
}
