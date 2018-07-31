package org.alpha.javabase.jdk8.designpattern.template_method;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:31
 */
public abstract class AbstractBuilder implements IBuilder{

    @Override
    public String build(String id){
        System.out.println("build root node : " + id);

        String childNodeName = buildChildNode(id);
        System.out.println("childNodeName = " + childNodeName);

        System.out.println("build root finished : " + id);

        return id + "_" + childNodeName;
    }

    public abstract String buildChildNode(String id);

}
