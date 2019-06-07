package javase.generic;

import java.util.Arrays;
import java.util.List;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/6/7
 */
public class GenericDemo {

    private List<? extends Number> getNumberList() {
        return Arrays.asList(new Integer(0));
    }

    private <T> void putAndGetWildcardList(List<? super T> list, T element) {
        list.add(element);
    }
}

