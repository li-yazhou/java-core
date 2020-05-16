package metrics;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @desc   Timer，统计某一块代码执行时间以及其分布情况，底层由Histogram和Meter实现
 * @author liyazhou
 * @date   2020/5/16
 */
public class TimerDemo {


    private static Timer timer = Metrics.newTimer(TimerDemo.class, "timer-test",
            TimeUnit.MILLISECONDS, TimeUnit.SECONDS);


    public static void main(String[] args) throws InterruptedException {
        ConsoleReporter.enable(3, TimeUnit.SECONDS);

        Random random = new Random();
        timer.time();
        System.out.println();

        while (true) {
            TimerContext context = timer.time();
            Thread.sleep(random.nextInt(1000));
            context.stop();;
        }
    }

}
