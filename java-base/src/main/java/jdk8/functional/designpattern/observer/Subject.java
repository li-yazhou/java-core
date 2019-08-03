package jdk8.functional.designpattern.observer;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 22:04
 */
public interface Subject {

    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}
