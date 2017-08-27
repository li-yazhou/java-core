package book.fkjava.ch15_io;

import org.junit.Test;

import java.io.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 14:28
 */
public class StringNodeTest {
    @Test
    public void stringReaderTest(){
        String srcPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\StringNodeTest.java";
        try (
                StringReader stringReader = new StringReader(srcPath);
                // FileReader fileReader = new FileReader(srcPath);
                PrintStream printStream = new PrintStream(System.out);
        ) {
                char[] cbuff = new char[16];
                int len = 0;
                while ((len = stringReader.read(cbuff)) > 0){
                    printStream.println(new String(cbuff, 0, len));
                }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
