package disruptor.demo1;


import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;

/**
 *
 * EventFactory：用于生成一个事件提供消费者消费
 *
 * EventHandler：消费者处理器
 *
 * 事件和生产者：无内部接口，可以自己封装实体对象和RingBuffer
 *
 * RingBuffer：核心数据结构，可以理解为环形缓冲，disruptor高性能秘密
 *
 * WaitStrategy：消费者阻塞时候的等待策略：
 *          SleepingWaitStrategy,
 *          BlockingWaitStrategy,
 *          BusySpinWaitStrategy,
 *          YieldingWaitStrategy
 *
 * Disruptor：disruptor框架入口，进行相关配置
 *
 */
public class DisruptorDemo {


    // 事件和工厂
    static class LogEvent {
        String content;
        public void setContent(String content) {
            this.content = content;
        }
    }

    static class LogEventFactory implements EventFactory<LogEvent> {
        @Override
        public LogEvent newInstance() {
            return new LogEvent();
        }
    }


    // 消费者
    static class LogEventHandler implements EventHandler<LogEvent> {
        @Override
        public void onEvent(LogEvent event, long sequence, boolean endOfBatch) throws Exception {
            System.out.println(Thread.currentThread().getName() + ",seq=" + sequence + ",event=" + event.content);
        }
    }


    // 生产者
    static class LogEventProducer {
        private final RingBuffer<LogEvent> ringBuffer;
        public LogEventProducer(RingBuffer<LogEvent> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }
        public void onData(String content) {
            long seq = ringBuffer.next();
            try {
                LogEvent logEvent = ringBuffer.get(seq);
                logEvent.setContent(content);
            } finally {
                ringBuffer.publish(seq);
            }
        }
    }

    public static void main(String[] args) {

        LogEventFactory eventFactory = new LogEventFactory();

        // 缓冲区大小
        int bufferSize = 16;

        // ProducerType有single和multi之分，分别对应不同的RingBuffer实现，性能不同
        // WaitStrategy对应消费者阻塞时的处理策略
        Disruptor<LogEvent> disruptor = new Disruptor<>(
                eventFactory,
                bufferSize,
                (ThreadFactory)Thread::new,
                ProducerType.MULTI,
                new BlockingWaitStrategy());

        // 挂载消费者，可以有多个消费者，并可以通过Group自由链接组合关系
        disruptor.handleEventsWith(new LogEventHandler());
        disruptor.start();

        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();
        LogEventProducer producer = new LogEventProducer(ringBuffer);
        for (int i = 0; i < 20; i++) {
            producer.onData("this is a log event i=" + i);
        }
    }

}
