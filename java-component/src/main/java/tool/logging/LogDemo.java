package tool.logging;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyazhou1
 * @date 2020/1/16
 */
@Slf4j
public class LogDemo<T extends Number> {

    public static void main(String[] args) {

        String msg = "tip message";

//        try {
//            int a = 1;
//            int b = 0;
//            int c = a / b;
//        } catch (Exception ex) {
//            log.info("msg = [{}]");
//        }
//List<? extents Number ，Text>

        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        List<? super Number> numUpperList = objects;

        for (Object o : numUpperList) {
            System.out.println("o = " + o);
        }

//        List<Number> numbers = objects;
        List<Number> numbers = new ArrayList<>();
        Integer i = new Integer(1);
        numbers.add(i);


        List<Integer[]> list = new ArrayList<>();


    }
}
