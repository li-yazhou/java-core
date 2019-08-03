package jdk8.functional.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 22:05
 */
public class Feed implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observerList.forEach(o -> o.notify(tweet));
    }
}
