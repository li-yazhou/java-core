package metrics;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Meter;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @desc   Meter，度量某时间段内请求数的统计值，统计TPS时使用
 * @author liyazhou
 * @date   2020/5/16
 */
public class MeterDemo {

    private static Meter meter = Metrics.newMeter(MeterDemo.class, "Meter", "requests", TimeUnit.SECONDS);


    public static void main(String[] args) throws InterruptedException {

        ConsoleReporter.enable(5, TimeUnit.SECONDS);

        int times = 1000;

        Random random = new Random();

        while (times > 0) {

            for (int c = random.nextInt(10); c > 0; c --) {
                // 调用一次 mark 方法就认为接收到一次请求
                meter.mark();
            }

            times --;

            Thread.sleep(1000);
        }

    }

}
