package javase.thread.callback;

/**
 * @author liyazhou1
 * @date 2020/2/28
 */
public class Client {


    public static void main(String[] args) {

        AsynService asynService = new AsynService();

        for (int i = 0; i < 10; i ++) {
            String message = "这是" + i + "条消息";
            asynService.send(message, new CallBack() {
                @Override
                public void onCompletion(Long timestamp, String result) {
                    String log = timestamp + "\t" + result;
                    System.out.println("log = " + log);
                }
            });
        }
    }

}
