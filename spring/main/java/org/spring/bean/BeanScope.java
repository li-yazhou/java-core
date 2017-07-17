package org.spring.bean;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 19:45
 */
public class BeanScope {
    public void say(){
        System.out.println("BeanScope say: " + System.identityHashCode(this) + ", " + this.hashCode());
    }
}
