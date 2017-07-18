package book.fkjava16.ch02_object_memory;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 11:20
 */
public class Test02 {

    public static void main(String[] args){
        int a = 2;
        int b = 5 + a;
        int c;
        if (b > 2) c = 10;
        // System.out.println(c);
    }
}
