package metrics;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Gauge;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @desc   Gauge，记录瞬时值
 * @author liyazhou
 * @date   2020/5/16
 */
public class GaugeDemo {

    public static void main(String[] args) throws InterruptedException {

        final List<String> list = new ArrayList<>();

        ConsoleReporter.enable(2, TimeUnit.SECONDS);

        Gauge<Integer> gauge = Metrics.newGauge(GaugeDemo.class, "gauge-demo", new Gauge<Integer>(){

            @Override
            public Integer value() {
                return list.size();
            }
        });

        long times = 200;
        while (times > 0) {
            list.add(LocalDateTime.now().toString());
            Thread.sleep(1000);
            times --;
        }

    }

}
