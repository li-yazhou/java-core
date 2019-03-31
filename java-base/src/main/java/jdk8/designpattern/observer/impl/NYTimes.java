package jdk8.designpattern.observer.impl;

import jdk8.designpattern.observer.Observer;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 22:07
 */
public class NYTimes implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY, " + tweet);
        }
    }
}
