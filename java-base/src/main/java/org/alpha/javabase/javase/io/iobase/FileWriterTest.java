package org.alpha.javabase.javase.io.iobase;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 14:02
 */
public class FileWriterTest {

    @Test
    public void fileWriterTest(){
        String distPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\out\\20170827-diary.txt";
        try(
                FileWriter fileWriter = new FileWriter(distPath)
        ) {
                fileWriter.write("2017-8-27 14:05:35\t\t周日\t\t多云\r\n");
                String content = "\t今天是2017级新生开学的日子，平时宁静的校园异常地热闹。" +
                        "待建的田径场上停满了车辆，食堂就餐的人比往常多出一大截....\r\n" +
                        "\t可以看出新生和家长们是疲惫的，也是幸福的。" +
                        "他们带着希望而来，愿他日满载梦想而归。";
                fileWriter.write(content);
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
