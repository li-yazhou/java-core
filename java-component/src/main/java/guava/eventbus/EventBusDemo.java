package guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @author liyazhou1
 * @date 2019/11/16
 */
public class EventBusDemo {


    // STEP-01 定义EventBus对象
    private static EventBus eventBus = new EventBus();


    @Test
    public void simpleListen() {

        // STEP-02 注册监听器
        eventBus.register(new SimpleListener());

        Random random = new Random();
        for (;;) {
            String numstr = random.nextInt(1000) + "";
            // STEP-03  监听者中的订阅方法将可以接收到当前EventBus推出去的消息
            eventBus.post(numstr);
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void childListen() {

        eventBus.register(new ChildListener());

        Random random = new Random();
        for (;;) {
            String numstr = random.nextInt(1000) + "";
            eventBus.post(numstr);
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


@Slf4j
class SimpleListener {

    // STEP-04 订阅方法监听（接收）EvenBus对象的推送的消息并处理
    @Subscribe
    public void simpleListen(String content) {
        log.info("simpleListen :: " + content);
    }
}


/**
 * 若当前的Listener被注册，它父类中的订阅方法也会处于监听状态
 */
@Slf4j
class ChildListener extends SimpleListener {

    // STEP-04 订阅方法监听（接收）EvenBus对象的推送的消息并处理
    @Subscribe
    public void childListen(String content) {
        log.info("childListen :: " + content);
    }
}