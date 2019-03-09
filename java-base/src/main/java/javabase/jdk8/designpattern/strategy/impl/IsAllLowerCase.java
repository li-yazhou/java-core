package javabase.jdk8.designpattern.strategy.impl;

import javabase.jdk8.designpattern.strategy.ValidationStrategy;

import java.util.Objects;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:11
 */
public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        Objects.requireNonNull(s);
        return s.matches("[a-z]+");
    }

}
