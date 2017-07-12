package javacore.book.fkjava.ch15_io;

import org.junit.Test;

import java.io.File;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-12 22:00
 */
public class IoTest {

    @Test
    public void fileTest(){
        File file = new File(".");
        System.out.println(file.getName());
    }

}
