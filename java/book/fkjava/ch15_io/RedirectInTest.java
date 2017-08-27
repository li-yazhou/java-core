package book.fkjava.ch15_io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 14:51
 */
public class RedirectInTest {
    @Test
    public void scannerTest() throws FileNotFoundException {
        String srcPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\RedirectInTest.java";
        FileReader fileReader = new FileReader(srcPath);
        Scanner sc = new Scanner(fileReader);
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
