package algorithm.ac.foroffer.top50;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 20:41
 * 面试题 46：圆圈中最后剩下的数字
 *
 * 题目：
 *      0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 *      求出这个圆圈里剩下的最后一个数字。
 *
 * 考查点：
 *      1. 约瑟夫环问题
 *
 * 思路：
 *      1. 圆形链表
 *
 *
 */
public class Test45 {

    public int lastRemainElement(int n, int m){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) list.add(i);

        int idx = 0;
        for (int i = 0; i < n-1; i ++){
            // for (int j = 0; j < m-1; j ++) idx ++;
            idx = idx + (m-1);
            idx = idx % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }

    @Test
    public void test(){
        System.out.println(lastRemainElement(5, 3));
    }


}
