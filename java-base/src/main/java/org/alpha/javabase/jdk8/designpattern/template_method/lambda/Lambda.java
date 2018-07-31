package org.alpha.javabase.jdk8.designpattern.template_method.lambda;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 21:52
 */
public class Lambda {

    public static void main(String[] args) {
        String result1 = new Builder().build(
                "1234",
                 input -> input + input
        );
        System.out.println("result1 = " + result1);

        System.out.println();

        String result2 = new Builder().build(
                "1234",
                input -> input + input + input + input
        );
        System.out.println("result2 = " + result2);
     }

}
