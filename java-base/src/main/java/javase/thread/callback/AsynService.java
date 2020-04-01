package javase.thread.callback;

/**
 * @author liyazhou1
 * @date 2020/2/28
 */
public class AsynService {



    public void send(String message, CallBack callBack) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callBack.onCompletion(System.currentTimeMillis(), "received message: " + message);

    }

}
