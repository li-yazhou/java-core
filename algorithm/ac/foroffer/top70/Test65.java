package ac.foroffer.top70;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 20:53
 *
 * 面试题65：滑动窗口的最大值
 *
 * 题目：
 *      给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *      例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小 3，
 *      那么移动存在 6 个滑动窗口，它们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 *
 * 考查点：
 *      1. 双端队列的应用
 *
 * 思路：
 *
 *
 * Deque的12种方法总结如下：
 * 	                   First Element (Head)	                      Last Element (Tail)
 *              Throws exception	Special value	        Throws exception	Special value
 *  Insert	      addFirst(e)	     offerFirst(e)	            addLast(e)	     offerLast(e)
 *  Remove	      removeFirst()      pollFirst()     	        removeLast()	 pollLast()
 *  Examine	      getFirst()	     peekFirst()	            getLast()	     peekLast()
 *
 */
public class Test65 {

    public List<Integer> maxInWindow(int[] array){
        Deque<Integer> deque = new LinkedList<>();

        return null;
    }

}
