package org.alpha.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/27 17:54
 */
public final class Range implements Iterable<Integer>{

    private int start = 0;
    private int end;
    private int step;

    private List<Integer> range;

    public Range(int end) {
        this(0, end, 1);
    }

    public Range(int start, int end) {
        this(start, end, 1);
    }

    public Range(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }


    @Override
    public Iterator<Integer> iterator() {
        if (start >= end) {
            List<Integer> list = Collections.emptyList();
            return list.iterator();
        }

        range = new ArrayList<>();
        for (int i = start; i < end; i ++) {
            range.add(i);
        }

        return range.iterator();
    }
}
