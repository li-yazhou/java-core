package springbasic.spring_in_action4.ch02_bean.case01_autowired.soundsystem;

import org.springframework.stereotype.Component;

/**
 * description:
 *      自动装配 bean
 * @author liyazhou
 * @since 2017-07-06 15:40
 */

// @Component，bean默认的ID是sgtPepers，也即是类名小写后的字符串
@Component("sgtPepers")  // 为组件扫描的Bean命名， @Named("beanName")也可以为bean命名
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Compact disc is playing....");
        System.out.println("Playing " + title + " by " + artist);
    }
}
