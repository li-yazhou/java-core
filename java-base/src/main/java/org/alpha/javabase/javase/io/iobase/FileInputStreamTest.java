package org.alpha.javabase.javase.io.iobase;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-26 21:52
 */
public class FileInputStreamTest {

    @Test
    public void fileInputStreamTest() throws IOException {
        String path = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\FileInputStreamTest.java";
        FileInputStream fis = new FileInputStream(path);  // import java.io.FileNotFoundException;
        byte[] bbuff = new byte[64];
        // byte[] bbuff = new byte[1024];
        int len = 0;
        while ((len = fis.read(bbuff)) > 0) { // IOException
            PrintUtils.println(new String(bbuff, 0, len));
        }
        fis.close();
    }

}
