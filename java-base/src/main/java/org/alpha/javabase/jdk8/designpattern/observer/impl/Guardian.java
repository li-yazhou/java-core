package org.alpha.javabase.jdk8.designpattern.observer.impl;

import org.alpha.javabase.jdk8.designpattern.observer.Observer;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 22:09
 */
public class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London! " + tweet);
        }
    }
}
