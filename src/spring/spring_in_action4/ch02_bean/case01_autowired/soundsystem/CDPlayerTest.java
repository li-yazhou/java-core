package spring.spring_in_action4.ch02_bean.case01_autowired.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-06 15:48
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
    // @Rule
    // public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired  // @Autowired，使用在字段上，为字段赋值
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
        cd.play();
    }

    @Autowired
    private MediaPlayer player;

    @Test
    public void play(){
        player.play();
    }
}
