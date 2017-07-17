package springbasic.journeyofspring.a_start.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 17:22
 */
public class DiApp {
    @Test
    public void test(){
        String path = "springbasic/journeyofspring/a_start/di/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        Girl girl = context.getBean("girl", Girl.class);
        girl.display();
    }
}
