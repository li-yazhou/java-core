package org.alpha.javabase.jdk8.designpattern.strategy.impl;

import org.alpha.javabase.jdk8.designpattern.strategy.ValidationStrategy;

import java.util.Objects;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:14
 */
public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        Objects.requireNonNull(s);
        return s.matches("\\d+");
    }
}
