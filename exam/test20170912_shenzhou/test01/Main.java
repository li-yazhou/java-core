package test20170912_shenzhou.test01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-12 21:46
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] map = new int[256];
        for (int i = 0; i < input.length(); i ++){
            char ch = input.charAt(i);
            map[ch] ++;
        }

        int minTimes = input.length();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < map.length; i ++){
            int times = map[i];
            if (times == 0) continue;

            if (minTimes > times){
                minTimes = times;
                list.clear();
                list.add((char)i);
            }else if (minTimes == times){
                list.add((char)i);
            }
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i ++){
            if (list.contains(input.charAt(i))) continue;
            output.append(input.charAt(i));
        }

        System.out.println(output);
    }
}
