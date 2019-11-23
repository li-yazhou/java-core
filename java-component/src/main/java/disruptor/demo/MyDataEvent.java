package disruptor.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 1. 定义一个数据单元Event
 * Event是从生产者到消费者过程中所处理的数据单元
 *
 * @author liyazhou1
 * @date 2019/11/18
 */
@Setter @Getter
@ToString
public class MyDataEvent {

    private Long value;


}
