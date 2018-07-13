package org.alpha.javabase.javase.source;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-23 18:53
 */
public class ArrayListCode {


    /*
        toString()
           [[aa, bb], [cc, dd]]

        查看源码
            ArrayList -> AbstractList -> abstractCollection.toString[ stringBuilder.toString() ]

                public String toString() {
                    Iterator<E> it = iterator();
                    if (! it.hasNext())
                        return "[]";

                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    for (;;) {
                        E e = it.next();
                        sb.append(e == this ? "(this Collection)" : e);
                        if (! it.hasNext())
                            return sb.append(']').toString();
                        sb.append(',').append(' ');
                    }
                }

        2018-7-13
    */
    @Test
    public void testToString() {
        List<ArrayList<String>> arrayLists = new ArrayList<>();
        ArrayList<String> array1 = new ArrayList<>();
        array1.add("aa");
        array1.add("bb");

        ArrayList<String> array2 = new ArrayList<>();
        array2.add("cc");
        array2.add("dd");

        arrayLists.add(array1);
        arrayLists.add(array2);

        System.out.println("array1 = " + array1);
        System.out.println("array2 = " + array2);
        System.out.println("arrayLists = " + arrayLists);

        /*
            array1 = [aa, bb]
            array2 = [cc, dd]
            arrayLists = [[aa, bb], [cc, dd]]
         */
    }


    /*
        equals()

     */
}
