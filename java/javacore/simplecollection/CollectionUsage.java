package javacore.simplecollection;

import org.junit.Test;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 10:46
 */
public class CollectionUsage {

    // ========================== java.util.Map ==========================
    @Test
    public void testMap(){
        Map map = null;
        HashMap hashMap = null;
        Hashtable hashtable = null;
        LinkedHashMap linkedHashMap = null;
        TreeMap treeMap = null;

        hashMap = new HashMap();
        hashMap.put(null, "2");
        hashMap.put(null, "22");
        System.out.println(hashMap.size());
    }


    // ========================== java.util.Collection ==========================

    public void testSet(){
        Set set = null;
        HashSet hashSet = null;
        LinkedHashSet linkedHashSet = null;
        TreeSet treeSet = null;
    }

    @Test
    public void testList(){
        List list0 = null;
        ArrayList arrayList = null;
        LinkedList linkedList = null;
        Vector vector = null;

        LinkedList<Integer> list = new LinkedList<>();
        list.offer(1);
        list.offer(2);
        System.out.println(list.peek());
        list.push(3);
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
    }

    public void testQueue(){
        Queue queue = null;
        PriorityQueue priorityQueue = null;
        ArrayDeque arrayDeque = null;
        LinkedList linkedList = null;
    }

}
