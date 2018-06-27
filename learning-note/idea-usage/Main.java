import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String ... args){
        System.out.println(args[0]);
        System.out.println("Intellij Idea.");

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        int len = 100;
        for (int i = 0; i < len; i++) {
            System.out.println(i);
        }

        List<String> list = new ArrayList<>();
        list.add("lyz");
        list.add("wcs");
        list.add("ldf");
        int size = list.size();
        System.out.println(size);

    }

    @Test
    public void foo(){
        System.out.println("junit");
    }

}
