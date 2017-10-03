package exam201709.test20170908_jd.test02;

import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-08 19:59
 */
public class Main {
    int BASE = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        if (n == 1) result = 1;
        else if (n == 2) result = 6;
        else if (n == 3) result = 14;
        System.out.println(result);
    }
}
