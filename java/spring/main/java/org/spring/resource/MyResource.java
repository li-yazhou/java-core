package org.spring.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-18 8:40
 */
public class MyResource implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void resource() throws IOException {
        // classpath:
        // Resource resource = this.applicationContext.getResource("config.txt");
        // file:
        // Resource resource = this.applicationContext.getResource("file:D:\\workspace\\algorithm_java\\spring\\main\\resources\\config.txt");
        // url:
        // Resource resource = this.applicationContext.getResource("url:https://stackoverflow.com");
        // (None)，依赖 ApplicationContext
        Resource resource = this.applicationContext.getResource("config.txt");
        System.out.println(resource.getFilename());
        System.out.println(resource.contentLength());
    }




























}
