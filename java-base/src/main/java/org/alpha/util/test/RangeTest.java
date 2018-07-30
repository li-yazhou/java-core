package org.alpha.util.test;

import org.alpha.util.Range;
import org.junit.Test;

import java.util.Iterator;

/**
 * <p>Description: <p/>
 *
 * @author liyazhou1
 * @date 2018/7/27 18:08
 */
public class RangeTest {

    @Test
    public void range() {
        Range range = new Range(10);
        for (Iterator<Integer> iter = range.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
    }
}
