package jvm.jvm_in_action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyazhou1
 * @date 2020/4/12
 */
public class _001_Jmap {


    public static void main(String[] args) throws InterruptedException {

        List<String> cache = new ArrayList<>();
        long count = 0;
        while (true) {
            cache.add(count + "");
            count ++;
            Thread.sleep(100);
        }

    }
}
