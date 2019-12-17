package apachecommons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * <p>Description: <p/>
 *
 * @author: liyazhou1
 * @date: 2018/7/10
 */
public class StringUtilsTest {


    @Test
    public void split() {
        String text = "key : value";
        String[] strs = StringUtils.splitByWholeSeparatorPreserveAllTokens(text, " : ");
        System.out.println("Arrays.toString(strs) = " + Arrays.toString(strs));
    }

    private void println(String content){
        System.out.println(content);
    }

    private void print(String content) {
        System.out.print(content);
    }

    private void println(String separator, int count) {
        for (int i = 0; i < count; i ++) {
            System.out.print(separator);
        }
        System.out.println();
    }

    @Test
    public void isNotBlank() {
        String[] strs = {
                "",
                "  ",
                "\t",
                "\n",
                null,
                "lyz",
                "zhouzhou",
        };
        for (String str : strs) {
            String isBlank = "StringUtils.isBlank(" + str + ") = " + StringUtils.isBlank(str);
            String isNotBlank = "StringUtils.isNotBlank(" + str + ") = " + StringUtils.isNotBlank(str);
            println(isBlank);
            println(isNotBlank);
            println("-------------");
        }
    }


    @Test
    public void leftAndRight() {
        String str = "zhongguo";
        int loop = 10;
        for (int i = 0; i < loop; i ++) {
            println("str = " + str);
            println("left[len = "+ i +"] = " + StringUtils.left(str, i));
            println("right[len= "+ i +"] = " + StringUtils.right(str, i));
            println("-", 20);
        }
    }
}
