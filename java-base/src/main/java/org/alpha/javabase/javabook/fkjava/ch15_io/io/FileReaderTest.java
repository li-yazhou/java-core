package org.alpha.javabase.javabook.fkjava.ch15_io.io;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-26 22:07
 */
public class FileReaderTest {

    @Test
    public void fileReaderTest() throws IOException {
        String path = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\FileInputStreamTest.java";
        FileReader fileReader = new FileReader(path);
        char[] cbuff = new char[16];
        // char[] cbuff = new char[1024];
        int len = 0;
        while ((len = fileReader.read(cbuff)) > 0){
            PrintUtils.println(new String(cbuff));
        }
        fileReader.close();
    }
}
