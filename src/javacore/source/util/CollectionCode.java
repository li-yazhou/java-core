package javacore.source.util;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-23 20:22
 *
 * ArrayList    LinkedList
 * HashSet      LinkedHashSet   TreeSet
 * HashMap      LinkedHashMap   TreeMap
 *
 */
public class CollectionCode {
    private Comparator<Integer> cmp= Collections.reverseOrder();
    private Comparator<String> cmp2= Collections.reverseOrder();
    private Comparator cmp3= Collections.reverseOrder();
    private Comparator cmp4= Collections.reverseOrder();
    @Test
    public void test(){
        System.out.println(cmp);
        System.out.println(cmp2);
        System.out.println(cmp2.equals(cmp));
        System.out.println(cmp3 == cmp4);
    }


    @Test
    public void test02(){
        Map<String, String> map = System.getenv();
        for (Map.Entry<String ,String> entry : map.entrySet())
            System.out.println(entry.getKey() + " :: " + entry.getValue());
    }
}
