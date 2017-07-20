package ac.foroffer.top02;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 10:47
 */
public class Top20 {


    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * 面试题11 数值的整数次方
     */
    public double test11_power(int base, int exponent){
        if (exponent == 0) return 1;
        boolean isNegative = exponent < 0;
        if (exponent < 0) exponent = - exponent;
        double result = 1;
        for (int i = 0; i < exponent; i ++) result *= base;
        if (isNegative) result = 1/result;
        return result;
    }



    public double powerWithPositiveExponent(double base, int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = powerWithPositiveExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) result *= base;
        return result;
    }

    @Test
    public void test11_powerTest(){
        for (int i = -5; i < 5; i ++){
            System.out.printf("power(2, %d) = %.6f , answer = %.6f\n", i, test11_power(2, i), Math.pow(2, i));
        }
    }


    /*----------------------------------------------------------------------------------------------------------------*/



    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
}
