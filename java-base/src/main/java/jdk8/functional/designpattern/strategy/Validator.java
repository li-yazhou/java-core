package jdk8.functional.designpattern.strategy;

import java.util.Objects;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:16
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        /* 注入具体的策略对象 */
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        Objects.requireNonNull(s);
        return strategy.execute(s);
    }

}
