package spring.journeyofspring.b_bean.instantiate_manners;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 19:18
 */
public class InstantiateApp {

    @Test
    public void test(){
        String path = "spring/journeyofspring/b_bean/instantiate_manners/instantiate_manners.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        PersonService personService1 = context.getBean("personService1", PersonService.class);
        PersonService personService2 = context.getBean("personService2", PersonService.class);
        PersonService personService3 = context.getBean("personService3", PersonService.class);

        personService1.service();
        personService2.service();
        personService3.service();
    }
}
