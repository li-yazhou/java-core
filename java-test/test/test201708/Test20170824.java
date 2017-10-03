package test.test201708;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-24 16:21
 */
public class Test20170824 {
    private Map map = new HashMap();
    private HashMap hashMap = new HashMap();
    private TreeMap treeMap = new TreeMap();

    @Test
    public void test(){
        map.putIfAbsent(1, 1);
        hashMap.putIfAbsent(1,1);  // 覆写Map的putIfAbsent方法，因为它可以存放key为null的键值对
        treeMap.putIfAbsent(1,1);  // 没有覆写Map的putIfAbsent方法
    }
}
