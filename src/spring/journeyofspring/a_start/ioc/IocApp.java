package spring.journeyofspring.a_start.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-05 16:22
 */
public class IocApp {

    public static void main(String[] args){
        // 如果 beans.xml 位于类路径下，即在src下，则 String path = "beans.xml";
        String path = "spring/journeyofspring/a_start/ioc/beans.xml";
        // 配置文件在类路径下，或者指定位置，初始化 spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        // 从 spring 容器中获取 boy 对象，<bean id="boy" class="cn.itcast.ioc.Boy" />
        Boy boy = (Boy) context.getBean("boy");

        // 调用对象的方法
        boy.display();

        // 不需要强制类型转换，获取对象的首选方法
        Boy boy2 = context.getBean("boy", Boy.class);
        boy2.display();
    }
}


















































