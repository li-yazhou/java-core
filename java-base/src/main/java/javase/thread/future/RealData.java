package javase.thread.future;

import java.util.StringJoiner;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/4/7
 */
public class RealData implements IData<String> {

    private String data;

    RealData(String rawstr) {
        StringJoiner sj = new StringJoiner("_");
        for (int i = 0; i < 10; i ++) {
            sj.add(i + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("ex = " + ex);
            }
        }
        data = sj.add(rawstr).toString();
    }

    @Override
    public String get() {
        return data;
    }
}
