package disruptor.demo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liyazhou1
 * @date 2019/11/18
 */
public class MyDataEventMain {

    public static void main(String[] args) {

        // 1. 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 2. 创建数据单元的工厂类
        MyDataEventFactory factory = new MyDataEventFactory();

        // 3. 创建buffersize, 也就是RingBuffer的大小，必须是2的N次方
        int ringBufferSize = 1024 * 1024;

        // 4. 创建Disruptor
        Disruptor<MyDataEvent> disruptor = new Disruptor<>(factory, ringBufferSize, executorService);

        // 5. 连接消费事件方法（消费者）
        disruptor.handleEventsWith(new MyDataEventHandler());

        // 6. 启动
        disruptor.start();

        // 7. 生产者发布事件
        RingBuffer<MyDataEvent> ringBuffer = disruptor.getRingBuffer();
        MyDataEventProducer producer = new MyDataEventProducer(ringBuffer);

        // 创建一个容量为 128 字节的ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

        for (long data = 1; data <= 1000; data ++) {
            // 在下标为0的位置存储值
            byteBuffer.putLong(0, data);
            producer.publishData(byteBuffer);
        }

        // 关闭，方法会阻塞，直到所有的事件都得到处理
        disruptor.shutdown();

        // 必须手动关闭， disruptor在shutdown时不会关闭
        executorService.shutdown();

    }
}
