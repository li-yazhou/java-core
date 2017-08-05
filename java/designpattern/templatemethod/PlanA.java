package designpattern.templatemethod;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-05 8:57
 */
public class PlanA extends Template{

    @Override
    public void step01() {
        System.out.println("step 01");
    }

    @Override
    public void step02() {
        System.out.println("step 02");
    }

    @Test
    public void test(){
        Template plan = new PlanA();
        plan.templateMethod();
    }
}
