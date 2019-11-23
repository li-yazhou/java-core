package disruptor.demo;

import com.lmax.disruptor.EventFactory;


/**
 * 2. 创建工厂类实例化Event
 *
 * EventFactory工厂，用于实例化Event类
 *
 * @author liyazhou1
 * @date 2019/11/18
 */
public class MyDataEventFactory  implements EventFactory<MyDataEvent> {

    @Override
    public MyDataEvent newInstance() {
        return new MyDataEvent();
    }
}
