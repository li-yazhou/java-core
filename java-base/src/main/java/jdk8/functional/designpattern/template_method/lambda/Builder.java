package jdk8.functional.designpattern.template_method.lambda;

import java.util.function.Function;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:45
 */
public class Builder {

    private Function<String, String> childNodeBuilder;

    public Builder(Function<String, String> childNodeBuilder) {
        this.childNodeBuilder = childNodeBuilder;
    }

    public String build(String id) {
        System.out.println("root node  = " + id);

        String childNodeName = childNodeBuilder.apply(id);

        System.out.println(childNodeName);

        return id + "_" + childNodeName;
    }
}
