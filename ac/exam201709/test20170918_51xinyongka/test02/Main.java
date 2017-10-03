package exam201709.test20170918_51xinyongka.test02;

import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-18 20:21
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while(sc.hasNext()){
            if (sc.nextLine().contains("u51"))
                counter ++;
        }
        System.out.println(counter);
    }
}
