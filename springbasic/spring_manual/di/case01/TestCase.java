package springbasic.spring_manual.di.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 15:41
 */
public class TestCase {

    public static void main(String[] args){
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
        ApplicationContext context =
                new ClassPathXmlApplicationContext("springbasic/spring_manual/di/case01/services.xml");
        UserService userService = context.getBean("userService", UserService.class);
        String line = userService.getUsernameList();
        System.out.println(line);
    }
}












