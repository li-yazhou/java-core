package springbasic.journeyofspring.a_start.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 17:22
 */
public class DiApp {

    public static void main(String[] args){
        String path = "springbasic/journeyofspring/a_start/di/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        Girl girl = context.getBean("girl", Girl.class);
        girl.display();
        System.out.println("--------------");
    }
}
