package org.alpha.javabase.javaenhance.part04_thread.demo02_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-20 14:16
 */
public class AtomicIntegerTest {
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
