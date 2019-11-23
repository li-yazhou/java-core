package disruptor.demo;

import com.lmax.disruptor.EventHandler;

/**
 * 3. 消费端
 * EventHandler作为消费者，也可以理解为事件处理器
 *
 * @author liyazhou1
 * @date 2019/11/18
 */
public class MyDataEventHandler implements EventHandler<MyDataEvent> {

    @Override
    public void onEvent(MyDataEvent myDataEvent, long l, boolean b) throws Exception {
        System.out.println("myDataEvent = " + myDataEvent);
    }
}
