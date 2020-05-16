package metrics;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @desc   Counter，度量数字值，可以用过inc/dec/clear等方法修改其度量值
 * @author liyazhou
 * @date   2020/5/16
 */
public class CounterDemo {

    private final Counter counter = Metrics.newCounter(CounterDemo.class, "counter-demo");

    private final List<String> list = new ArrayList<>();


    public void add(String str) {
        counter.inc();
        list.add(str);
    }

    public String take() {
        counter.dec();
        return list.remove(0);
    }

    public static void main(String[] args) throws InterruptedException {

        CounterDemo cnt = new CounterDemo();

        ConsoleReporter.enable(3, TimeUnit.SECONDS);

        int times = 1000;
        while (times > 0) {
            cnt.add(LocalDateTime.now().toString());

            Thread.sleep(1000);
            String val = cnt.take();
            System.out.println("val = " + val);

            Thread.sleep(1000);
            cnt.add(LocalDateTime.now().toString());

            times --;
        }

    }

}
