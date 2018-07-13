package org.alpha.javabase.javabook.fkjava.ch15_io.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

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

    @Test
    public void readTest() throws Exception{
        String filepath = "D:\\workspace\\algorithm_java\\src\\javacore\\book\\fkjava\\ch15_io\\IoTest.java";
        FileInputStream fis = new FileInputStream(filepath);
        int ONE_M = 1024;
        byte[] bbuff = new byte[ONE_M];
        int hasRead = -1;
        while ((hasRead = fis.read(bbuff)) > 0){
            System.out.println(new String(bbuff, 0, hasRead));
        }
    }




}
