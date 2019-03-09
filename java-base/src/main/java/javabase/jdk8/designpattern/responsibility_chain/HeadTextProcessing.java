package javabase.jdk8.designpattern.responsibility_chain;

/**
 * <p>Description: </p>
 *
 * @author lyz
 * @date 2018/8/2 23:25
 */
public class HeadTextProcessing extends ProcessingObject<String> {

    @Override
    public String handleWork(String input) {
        return "[" +  input;
    }
}
