package springbean.org.spring.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 20:24
 */
public class ExampleInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // do something
    }
}
