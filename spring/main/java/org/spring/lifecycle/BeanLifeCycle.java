package org.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 20:19
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean {

    public void defaultInit(){
        System.out.println("Bean defaultInit.");
    }

    public void defaultDestroy(){
        System.out.println("Bean defaultDestroy.");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean afterPropertiesSet.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroy.");
    }

    public void start(){
        System.out.println("Bean start.");
    }

    public void stop(){
        System.out.println("Bean stop.");
    }

    /*
        Bean afterPropertiesSet.
        Bean start.
        Bean destroy.
        Bean stop.
    */
}
