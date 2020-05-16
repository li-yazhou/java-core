package metrics;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Histogram;
import com.yammer.metrics.reporting.ConsoleReporter;

import java.util.concurrent.TimeUnit;

/**
 * @desc   Histogram，统计度量值的最值、均值、方差、中位数、百分比数据等
 * @author liyazhou
 * @date   2020/5/16
 */
public class HistogramDemo {

    private static Histogram histogram = Metrics.newHistogram(HistogramDemo.class, "histogram-test");

    public static void main(String[] args) throws InterruptedException {
        ConsoleReporter.enable(3, TimeUnit.SECONDS);

        int i = 0;

        while (i < 100) {
            histogram.update(i ++);
            Thread.sleep(1000);
        }
    }
}
