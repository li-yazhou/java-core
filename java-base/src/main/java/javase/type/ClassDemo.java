package javase.type;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/6/4
 */
public class ClassDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class<? extends Number> downType = Integer.class;
        Number num = downType.newInstance();  // OK
        System.out.println("num = " + num);

        Class<? super Double> upType = Number.class;
        // Double dou = upType.newInstance(); // ERR

        // Class<? super List<String>> upType = Collection.class;


    }



}
