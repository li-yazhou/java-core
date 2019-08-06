package javase.thread_concurrent.future;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/4/7
 */
public class FutureData implements IData<String> {

    private IData<String> iData;
    private boolean success = false;


    @Override
    public synchronized String get() {
        while(!success) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("ex = " + ex);
            }
        }
        return iData.get();
    }


    public synchronized void set(IData<String> iData) {
        if (success) {
            return;
        }
        this.iData = iData;
        success = true;
        notifyAll();
    }
}
