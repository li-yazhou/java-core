package javabase.jdk8.designpattern.observer;

import javabase.jdk8.designpattern.observer.impl.Guardian;
import javabase.jdk8.designpattern.observer.impl.NYTimes;
import org.junit.Test;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/7/31 22:10
 */
public class FeedTest {

    public static void main(String[] args) {
        Feed feed = new Feed();

        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());

        feed.notifyObservers("The queen said her favourite book is Java 8 in Action.");
    }

    @Test
    public void lambda() {
        Feed f = new Feed();
        f.registerObserver(
                (String tweet) -> {
                    if (tweet != null && tweet.contains("money")) {
                        System.out.println("Breaking news in NY, " + tweet);
                    }
                }
        );

        f.registerObserver(
                (String tweet) -> {
                    if (tweet != null && tweet.contains("queen")) {
                        System.out.println("Yet another news in London! " + tweet);
                    }
                }
        );

        f.notifyObservers("The queen said her favourite book is Java 8 in Action.");
    }
}
