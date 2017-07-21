package org.spring.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 9:53
 */
//@Scope // 作用域默认是 singleton
@Scope("prototype")
@Component  // beanName 默认是类名首字母小写，其他字母不变的beanName
// @Component("bean")
public class BeanAnnotation {

    public void say(String arg){
        System.out.println("BeanAnnotation: " + arg);
    }

    public void myHashCode(){
        System.out.println("BeanAnnotation: " + this.hashCode());
    }
}
























