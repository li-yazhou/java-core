package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/27 18:10
 */
public final class RangeList {

    public static List<Integer> range(int end) {
        return range(0, end);
    }


    public static List<Integer> range(int start, int end) {
        if (start >= end) {
            return Collections.emptyList();
        }
        List<Integer> range = new ArrayList<>();
        for (int i = start; i < end; i ++) {
            range.add(i);
        }
        return range;
    }


    public static List<Integer> range(int start, int end, int step) {
        return Collections.emptyList();
    }
}
