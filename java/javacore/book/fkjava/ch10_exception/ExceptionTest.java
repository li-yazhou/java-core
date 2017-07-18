package javacore.book.fkjava.ch10_exception;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-12 19:17
 */
public class ExceptionTest {

    public static void main(String[] args) throws MyCheckedException{
        // throw new RuntimeException("runtime exception..");
        throw new MyCheckedException("checked exception.. ");
    }
}

class MyCheckedException extends Exception{

    public MyCheckedException(){}
    public MyCheckedException(String info){
        super(info);
    }
}
