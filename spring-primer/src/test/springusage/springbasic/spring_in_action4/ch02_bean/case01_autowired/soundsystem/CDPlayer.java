package springbasic.spring_in_action4.ch02_bean.case01_autowired.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-06 16:11
 */

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;  // 协作完成任务的对象

    @Autowired // @Autowired，使用在构造方法上，注入协作工作的对象
    // 注入依赖的对象
    // 如果有且只有一个匹配的依赖，则将该bean装配进来；
    // 如果没有匹配的bean，则会抛出异常
    // 如果有多个匹配的依赖对象，则需要指定具体的依赖，否则会抛出异常
    // @Autowired(required = false)，没有匹配的依赖，则不装配，不会抛出异常，此时待装配bean为null
    public CDPlayer(CompactDisc _cd){
        cd = _cd;
    }

    @Override
    public void play() {
        System.out.println("CDPlayer is playing...");
        cd.play();
    }
}
