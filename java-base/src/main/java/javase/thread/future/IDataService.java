package javase.thread.future;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/4/7
 */
public class IDataService {

    public IData<String> get() {
        final FutureData futureData = new FutureData();
        new Thread(new Runnable(){
            @Override
            public void run() {
                IData<String> data = new RealData("lyz");
                futureData.set(data);
            }
        }).start();
        return futureData;
    }
}
