package _utils;

import java.util.List;

/**
 * Created by liyazhou on 2017/5/26.
 */
public class Prints {

    public static <T> void printList(List<T> list){
        for (T element : list){
            System.out.println(element);
        }
    }
}
