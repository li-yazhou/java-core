package javase.thread.future;


/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/4/7
 */
public class Client {

    public static void main(String[] args) {

        IDataService service = new IDataService();
        IData<String> future = service.get();

        System.out.println("before");

        String result = future.get();
        System.out.println("result = " + result);

        System.out.println("after");

    }
}
