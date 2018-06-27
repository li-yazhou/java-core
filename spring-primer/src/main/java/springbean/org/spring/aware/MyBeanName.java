package springbean.org.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 21:05
 */

public class MyBeanName implements BeanNameAware, ApplicationContextAware {
    private String myBeanName;

    /**
     * BeanNameAware的抽象方法，
     * Bean类实现了BeanNameAware接口，覆写了setBeanName(String beanName)方法
     * 当容器创建Bean对象时，容器会自动调用setName方法，使bean对象可以获取到自己在xml配置文件被指定的名称
     * @param beanName Bean 对象在容器中的名称
     */
    public void setBeanName(String beanName) throws BeansException{
        this.myBeanName = beanName;
        System.out.println("MyBeanName : " + beanName);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext : " + applicationContext.getBean(this.myBeanName).hashCode());
    }
}
