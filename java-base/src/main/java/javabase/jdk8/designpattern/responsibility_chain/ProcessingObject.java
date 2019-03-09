package javabase.jdk8.designpattern.responsibility_chain;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/8/2 22:25
 */
public abstract class ProcessingObject<T> {

    private ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T retObj = handleWork(input);
        if (successor != null) {
            return successor.handle(retObj);
        }
        return retObj;
    }

    abstract public T handleWork(T input);
}
