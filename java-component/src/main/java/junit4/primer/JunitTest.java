package junit4.primer;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author liyazhou1
 * @date 2018/7/31
 */
public class JunitTest {

    @Test
    public void print() {
        System.out.println("junit test");
    }
    
    @Test(expected = NullPointerException.class)
    public void expected() {
        Object obj = null;
        System.out.println("obj = " + obj);  // OK
        System.out.println("obj.toString() = " + obj.toString());  // Exception
    }

    @Test(timeout = 1000 * 2)
    public void timeout() {
        for(;;) {
            System.out.println("true = " + true);
        }
    }


    @Test(expected = NullPointerException.class, timeout = 1000)
    public void attrs() {
        Object obj = null;
        System.out.println("obj = " + obj);  // OK
        System.out.println("obj.toString() = " + obj.toString());  // Exception
    }


    @Ignore("don't test")
    @Test
    public void ignoreTest() {
        System.out.println("ignore test");
    }


    @Before
    public void before() {
        System.out.println("before ");
    }

    @After
    public void after() {
        System.out.println("after ");
    }

    @Test
    public void test() {
        System.out.println("test ");
    }
}
