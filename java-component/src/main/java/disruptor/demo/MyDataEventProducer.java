package disruptor.demo;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * 4. 生产端
 * 生产者
 *
 * @author liyazhou1
 * @date 2019/11/18
 */
public class MyDataEventProducer {

    private final RingBuffer<MyDataEvent> ringBuffer;

    public MyDataEventProducer(RingBuffer<MyDataEvent> ringBuffer) {

        this.ringBuffer = ringBuffer;
    }


    /**
     * 发布事件，每调用一次就发布一次事件，它的参数会通过事件传递给消费者
     *
     * 发布事件是两个步骤
     * 1. 先要从RingBuffer获取下一个事件槽（可以理解为索引），
     * 2. 发送事件。需要注意的是：获取的事件槽，就要发布该事件槽对应的事件。不然会出现混乱的情况。所以发布事件的代码要放在finally中。
     *
     * @param byteBuffer 用ByteBuffer传参，是考虑到Disruptor是消息框架，
     *                   而ByteBuffer又是读取时信道（SocketChannel）最常用的缓冲区
     */
    public void publishData(ByteBuffer byteBuffer) {

        long sequence = ringBuffer.next();
        try {
            // 通过索引获取其对象
            MyDataEvent myDataEvent = ringBuffer.get(sequence);
            // 为数据单元赋值
            myDataEvent.setValue(byteBuffer.getLong(0));
        } finally {
            // 发布事件，其实就是发布索引
            // 发布方法必须放在finally中，避免出现阻塞情况
            ringBuffer.publish(sequence);

        }
    }


}
