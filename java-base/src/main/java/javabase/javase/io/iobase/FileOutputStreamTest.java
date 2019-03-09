package javabase.javase.io.iobase;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-26 22:07
 */
public class FileOutputStreamTest {
    @Test
    public void fileOutputStreamTest() {
        String srcPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\FileOutputStreamTest.java";
        String distPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\out\\newFile.txt";

        try(
                FileInputStream fileInputStream = new FileInputStream(srcPath);
                FileOutputStream fileOutputStream = new FileOutputStream(distPath)
        ){
            byte[] bbuff = new byte[64];
            int len = 0;
            while ((len = fileInputStream.read(bbuff)) > 0){
                fileOutputStream.write(bbuff, 0, len);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
