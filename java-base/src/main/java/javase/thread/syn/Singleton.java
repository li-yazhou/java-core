package javase.thread.syn;

/**
 * Created by ji.
 */
public class Singleton {

    private Singleton instance;

    private Object lock = new Object();

    private Singleton() {
    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
