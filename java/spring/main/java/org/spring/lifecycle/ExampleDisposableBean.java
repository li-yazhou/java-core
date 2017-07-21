package org.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-17 20:24
 */
public class ExampleDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        // do something
    }
}
