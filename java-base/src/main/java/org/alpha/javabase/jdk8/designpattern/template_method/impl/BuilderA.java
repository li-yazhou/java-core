package org.alpha.javabase.jdk8.designpattern.template_method.impl;

import org.alpha.javabase.jdk8.designpattern.template_method.AbstractBuilder;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:36
 */
public class BuilderA extends AbstractBuilder {

    @Override
    public String buildChildNode(String id) {
        return id + id;
    }
}
