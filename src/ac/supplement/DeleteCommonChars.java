package ac.supplement;

import org.junit.Test;

/**
 * description:阿里面试真题
 *
 * @author liyazhou
 * @since 2017-07-08 10:46
 */
public class DeleteCommonChars {

    /**
     * 在第一个字符数组中，删除在第二个字符数组中出现的字符
     * 要求：空间复杂度为 1，时间复杂度越小越好
     * @param chars1 第一个字符数组
     * @param chars2 第二个字符数组
     */
     public void deleteCommonchars(char[] chars1, char[] chars2){
        int count = 0;
        for (int i = 0; i < chars1.length; i ++){
            if (!contains(chars2, chars1[i])) continue;
            count++;
            for (int j = i+1; j < chars1.length; j ++)
                chars1[j-1] = chars1[j];
            i --;
        }
        for (int k = 0; k < count; k ++)
            chars1[chars1.length-1-k] = '\0';
    }


    private boolean contains(char[] chars, char ch){
        for (int i = 0; i < chars.length; i ++){
            if (chars[i] == ch) return true;
        }
        return false;
    }


    @Test
    public void test(){
        char[] chars1 = "hello world".toCharArray();
        System.out.println(chars1.length);
        char[] chars2 = "er".toCharArray();
        deleteCommonchars(chars1, chars2);
        System.out.println(chars1);
        System.out.println(chars1.length);
    }
}
