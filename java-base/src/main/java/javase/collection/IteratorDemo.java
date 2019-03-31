package javase.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/17
 */

/*

    可以在使用迭代器遍历集合的同时删除集合中的元素；

    而不可以是foreach的方式遍历的同时删除集合中的元素，否则会发生异常；

 */
public class IteratorDemo {

    private Iterator<String> iter;

    private ListIterator<String> listIter;

    /* Vector.elements() */
    private Enumeration enumeration;


}
