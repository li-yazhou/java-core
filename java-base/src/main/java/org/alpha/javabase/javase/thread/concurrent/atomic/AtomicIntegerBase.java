package org.alpha.javabase.javase.thread.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/13
 */
public class AtomicIntegerBase {

    private static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String... args){
        System.out.println("ai.getAndIncrement() = " + ai.getAndIncrement());
        System.out.println("ai.get() = " + ai.get());
        System.out.println("ai.getAndDecrement() = " + ai.getAndDecrement());
        System.out.println("ai.get() = " + ai.get());
        System.out.println("ai.getAndSet(10) = " + ai.getAndSet(10));
        System.out.println("ai.get() = " + ai.get());
    }
}
