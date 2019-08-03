package jdk8.functional.designpattern.strategy;

import jdk8.functional.designpattern.strategy.impl.IsAllLowerCase;
import jdk8.functional.designpattern.strategy.impl.IsNumeric;
import org.junit.Test;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:19
 */
public class ValidatorTest {

    public static void main(String[] args) {
        
        Validator numericValidator = new Validator(new IsNumeric());
        System.out.println("numericValidator.validate(\"1234\") = " + numericValidator.validate("1234"));
        System.out.println("numericValidator.validate(\"aaaa\") = " + numericValidator.validate("aaaa"));

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        System.out.println("lowerCaseValidator.validate(\"bbbb\") = " + lowerCaseValidator.validate("bbbb"));
        System.out.println("lowerCaseValidator.validate(\"BBBB\") = " + lowerCaseValidator.validate("BBBB"));
    }


    @Test
    public void lambda() {
        Validator numericValidator = new Validator(
                (String s) -> s.matches("\\d+")
        );
        System.out.println("numericValidator.validate(\"1234\") = " + numericValidator.validate("1234"));
        System.out.println("numericValidator.validate(\"aaaa\") = " + numericValidator.validate("aaaa"));

        Validator lowerCaseValidator = new Validator(
                (String s) -> s.matches("[a-z]+")
        );
        System.out.println("lowerCaseValidator.validate(\"bbbb\") = " + lowerCaseValidator.validate("bbbb"));
        System.out.println("lowerCaseValidator.validate(\"BBBB\") = " + lowerCaseValidator.validate("BBBB"));

    }

}
