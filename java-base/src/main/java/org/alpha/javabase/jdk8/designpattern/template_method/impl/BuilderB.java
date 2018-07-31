package org.alpha.javabase.jdk8.designpattern.template_method.impl;

import org.alpha.javabase.jdk8.designpattern.template_method.AbstractBuilder;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:37
 */
public class BuilderB extends AbstractBuilder {

    @Override
    public String buildChildNode(String id) {
        return id + id + id + id;
    }
}
