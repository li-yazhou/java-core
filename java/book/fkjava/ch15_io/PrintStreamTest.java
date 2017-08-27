package book.fkjava.ch15_io;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 14:18
 */
public class PrintStreamTest {
    @Test
    public void printStreamTest(){
        String distPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\out\\printStream.txt";
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(distPath);
                PrintStream printStream = new PrintStream(fileOutputStream);  // 重定向
        ){
                printStream.println("System.out 返回的也是 PrintStream 类型的对象");
                printStream.println(new PrintStreamTest());
                SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
                printStream.println(format.format(new Date()));
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
