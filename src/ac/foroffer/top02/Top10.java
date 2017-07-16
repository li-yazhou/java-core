package ac.foroffer.top02;

import org.junit.Test;

import java.util.LinkedList;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-16 9:42
 */


/**
 * 面试题02 单例模式
 */
class Singleton01{
    private final static Singleton01 INSTANCE = new Singleton01();
    private Singleton01(){}
    public static Singleton01 getInstance(){
        return INSTANCE;
    }

    public static void test(){
        Singleton01 instance01 = Singleton01.getInstance();
        Singleton01 instance02 = Singleton01.getInstance();
        System.out.println(instance01);
        System.out.println(instance02);
        if (instance01.equals(instance02))
            System.out.println("equals.");
    }
}
public class Top10 {


    /**
     * 面试题03 二维数组中的查找
     * @param arr
     * @param key
     * @return
     */
    public boolean test03_contains(int[][] arr, int key){
        // todo 判断条件不完整
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) return false;

        int len = arr.length;
        if (arr[len-1][len-1] < key || arr[0][0] > key) return false;

        for (int i = len-1; i > 0; i --){  // i denotes row or column
            if (arr[i][i] == key || arr[i-1][i-1] == key) return true;
            if (arr[i-1][i-1] > key) continue;
            // System.out.println("i = " + i);
            for (int j = i-1; j < len; j ++) {
                if (arr[j][i-1] == key) return true;
            }
            for (int k = 0; k <= i; k ++){
                if (arr[k][i] == key) return true;
            }
        }
        return false;
    }


    @Test
    public void test03_containsTest(){
        int[][] matrix = {
                {1 ,2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int[] keys = {-1, 1, 15, 7};
        for (int key : keys){
            System.out.println(String.format("contains  %d, %b", key, test03_contains(matrix, key)));
        }
    }


    /**
     *  if (arr == null || arr.length == 0) return false;
     *  int[][] arr;             arr == null
     *  int[][] arr = {};        arr.length == 0
     *  int[][] arr = {{}};      arr.length == 1 && arr[0].length == 0
     *  int[][] arr = {{}, {}};  (arr[0] == null || arr[0].length == 0) && (arr[1] == null && arr[1].length == 0)
     *  .....
     *  int[][] arr = {{}, null};  (arr[0] == null || arr[0].length == 0) && (arr[1] == null && arr[1].length == 0)
     * @param arr
     * @return
     */
    public boolean test03_arrayIsNullOrEmpty(int[][] arr){
        if (arr == null || arr.length == 0) return true;
        int len = arr.length;
        for (int i = 0; i < len; i ++){
            if (arr[i] != null && arr[0].length != 0) return false;
        }
        return true;
    }


    @Test
    public void test03_arrayTest(){
        int[][] arr1 = null;
        int[][] arr2 = {};
        int[][] arr3 = {{}};
        int[][] arr4 = {{}, {}};
        int[][] arr5 = {{}, {}, {}};
        int[][] arr6 = {{}, null, {}};
        // System.out.println(arr6.length);
        System.out.println(test03_arrayIsNullOrEmpty(arr1));
        System.out.println(test03_arrayIsNullOrEmpty(arr2));
        System.out.println(test03_arrayIsNullOrEmpty(arr3));
        System.out.println(test03_arrayIsNullOrEmpty(arr4));
        System.out.println(test03_arrayIsNullOrEmpty(arr5));
        System.out.println(test03_arrayIsNullOrEmpty(arr6));
    }


    /*----------------------------------------------------------------------------------------------------------------*/


    /**
     * 面试题04 替换空格
     */

    public int test04_replaceSpace(char[] chars, int usedLength){
        // '\u0000'
        int spaceNum = 0;
        for (int i = 0; i < usedLength; i ++){
            if (chars[i] == ' ') spaceNum ++;
        }
        int newLength = usedLength + spaceNum * 2;
        int idx = newLength - 1;
        for (int i = usedLength-1; i >=0; i --){
            if (chars[i] == ' '){
                chars[idx--] = '0';
                chars[idx--] = '2';
                chars[idx--] = '%';
            }
            else chars[idx--] = chars[i];
        }
        return newLength;
    }


    @Test
    public void test04_replaceSpaceTest(){
        String line = "We are  happy .";

        char[] chars = new char[50];
        char[] string = line.toCharArray();
        for (int i = 0; i < string.length; i++)
            chars[i] = string[i];
        int length = test04_replaceSpace(chars, string.length);
        System.out.println(new String(chars, 0, length));
    }


    public String test04_replaceSpace2(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == ' ') spaceNum ++;
        }

        int oldLength = str.length();
        int newLength = str.length() + spaceNum * 2;
        str.setLength(newLength);

        int idx = newLength - 1;
        for (int i = oldLength-1; i >=0; i --){
            if (str.charAt(i) == ' '){
                str.setCharAt(idx--, '0');
                str.setCharAt(idx--, '2');
                str.setCharAt(idx--, '%');
            }
            else str.setCharAt(idx--, str.charAt(i));
        }
        return str.toString();
    }

    @Test
    public void test04_repalceSpaceTest2(){
        StringBuffer sb = new StringBuffer("We are  happy .");
        System.out.println(test04_replaceSpace2(sb));
    }


    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * 面试题05 从尾到头打印链表
     */
    private class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int _val){ val = _val; }
    }

    public ListNode test05_createList(int... vals){
        ListNode head = new ListNode(vals[0]);
        ListNode currNode = head;
        ListNode next;
        for (int i = 1; i < vals.length; i ++){
            next = new ListNode(vals[i]);
            currNode.next = next;
            currNode = next;
        }
        return head;
    }

    public void test05_printList(ListNode head){
        LinkedList<ListNode> stack = new LinkedList<>();
        for (ListNode currNode = head; currNode != null; currNode = currNode.next)
            stack.push(currNode);
        while(!stack.isEmpty()){
            System.out.print(stack.pop().val + "\t");
        }
    }


    public void test05_printListRecursively(ListNode head){
        if (head.next != null) test05_printListRecursively(head.next);
        System.out.print(head.val + "\t");
    }


    @Test
    public void test05_printListTest(){
        ListNode head = test05_createList(1, 2, 3, 4, 5, 6);
        test05_printList(head);
        System.out.println();
        test05_printListRecursively(head);
    }


    /*----------------------------------------------------------------------------------------------------------------*/


    /**
     * 面试题06 重建二叉树
     */

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int _val) { val = _val; }
     }


    public TreeNode test06_constructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) return null;
        return test06_constructBinTree(pre, 0, pre.length, in, 0, pre.length);
    }

    // todo, 确定边界是关键点

    /**
     * @param preorder 前序遍历序列
     * @param ps 当前树的前序遍历序列的第一个元素的下标
     * @param pe 当前树的前序遍历序列的最后一个元素的下标+1
     * @param inorder 中序遍历序列
     * @param is 当前树的中序遍历序列的第一个元素的下标
     * @param ie 当前树的中序遍历序列的最后一个元素的下标+1
     * @return 二叉树的根结点
     *
     *
     * 思路：
     *  参数是前序遍历序列以及其起始、终止下标，中序遍历序列以及其起始、终止下标
     *  首先，判断起始和终止下标是否越界，如果越界，则返回null，这个null将作为只有一个孩子或者叶子结点的孩子
     *  根据前序遍历序列的第一个元素创建当前树的根结点
     *  查找根结点在中序遍历序列中的位置，也即是下标
     *  假如，中序遍历序列中不存在该根结点，抛出前序遍历和中序遍历序列不匹配的异常
     *  根据根结点在前序遍历和后续遍历中的下标，可以计算出根结点的左子树在前序和后序遍历序列中的下标范围，然后递归地创建左子树，并将返回值赋值给它的根结点
     *  根据根结点在前序遍历和后续遍历中的下标，可以计算出根结点的右子树在前序和后序遍历序列中的下标范围，然后递归地创建右子树，并将返回值赋值给它的根结点
     *  返回二叉树的根结点
     */
    private TreeNode test06_constructBinTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        // 递归终止条件，当开始位置大于结束位置时，则没有要处理的数据
        if (ps >= pe || is >= ie) return null;  // null 是只有一个孩子或者叶子结点的孩子

        // 从前序遍历序列中取出根结点
        int rootId = preorder[ps];
        TreeNode root = new TreeNode(rootId);

        // 根结点在中序遍历序列中的位置
        int idxOfRoot = -1;
        for (int i = is; i < ie; i++){
            if(inorder[i] == rootId){
                idxOfRoot = i;
                break;
            }
        }

        if (idxOfRoot == -1) {
            // System.out.println(String.format("ps, pe = %d, %d, preorder = %s", ps, pe, Arrays.toString(preorder)));
            // System.out.println(String.format("is, ie = %d, %d, inorder = %s", is, ie, Arrays.toString(inorder)));
            throw new RuntimeException("先序遍历序列和中序遍历序列不匹配.");
        }

        // 递归构建当前根结点的左子树，左子树的结点个数是 idxOfRoot-is
        // 先序遍历序列中，当前根结点的左子树的范围是 [ps+1, ps+(idxOfRoot-is)+1)，根据起始位置和偏移量计算范围
        // 中序遍历序列中，当前根结点的左子树的范围是 [is, idxOfRoot)
        TreeNode leftChildNode = test06_constructBinTree(preorder, ps+1, ps+idxOfRoot-is+1, inorder, is, idxOfRoot);
        root.left = leftChildNode;

        // 递归构建当前根结点的右子树，右子树的结点个数是 ie-idxOfRoot-1
        // 先序遍历序列中，当前结点的右子树的范围是 [pe-(ie-idxOfRoot-1), pe)，根据终止位置和偏移量计算范围
        // 中序遍历序列中，当前结点的右子树的范围是 [idxOfRoot+1, ie)
        TreeNode rightChildNode = test06_constructBinTree(preorder, pe-ie+idxOfRoot+1 , pe, inorder, idxOfRoot+1, ie);
        root.right = rightChildNode;

        return root;
    }



    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * 面试题07 用两个栈实现队列
     */
    private class MyQueue<T>{
        LinkedList<T> pushStack = new LinkedList<>();
        LinkedList<T> popStack = new LinkedList<>();

        public void offer(T ele){
            pushStack.push(ele);
        }

        public T poll(){
            T head = null;
            if (!popStack.isEmpty()) head = popStack.poll();
            else{
                while(!pushStack.isEmpty()) popStack.push(pushStack.pop());
                if (!popStack.isEmpty()) head = popStack.pop();
            }
            return head;
        }
    }

    @Test
    public void test07_doubleStackToQueue(){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(10);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }


    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * 面试题08 旋转数组的最小数字
     */



    /*----------------------------------------------------------------------------------------------------------------*/




    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/



}
