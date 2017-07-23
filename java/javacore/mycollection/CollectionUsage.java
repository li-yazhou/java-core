package javacore.mycollection;

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
        LinkedHashMap linkedHashMap = null;
        TreeMap treeMap = null;

        hashMap = new HashMap();
        hashMap.put(null, "2");
        hashMap.put(null, "22");
        System.out.println(hashMap.size());
    }


    // ========================== java.util.Collection ==========================

    public void testList(){
        List list = null;
        ArrayList arrayList = null;
        LinkedList linkedList = null;
    }

    public void testSet(){
        Set set = null;
        HashSet hashSet = null;
        LinkedHashSet linkedHashSet = null;
        TreeMap treeMap = null;
    }

    public void testQueue(){
        Queue queue = null;
        PriorityQueue priorityQueue = null;
        ArrayDeque arrayDeque = null;
        LinkedList linkedList = null;
    }

}
