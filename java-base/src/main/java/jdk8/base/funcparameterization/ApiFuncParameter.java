package jdk8.base.funcparameterization;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/8/3
 */
public class ApiFuncParameter {


    @Test
    public void listSort() {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);

        // Collections 集合工具类提供的sort方法
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("list = " + list);

        // JDK8 为List接口提供的sort方法
        list.sort(Integer::compareTo);
        System.out.println("list = " + list);
    }


    @Test
    public void runnable() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i ++) {
                    System.out.println("i1 = " + i);
                }
            }
        });
        thread.start();

        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i ++) {
                System.out.println("i2 = " + i);
            }
        });
        t.start();
    }
}
