package org.alpha.javabase.javase.io;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;



/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-11 12:35
 */
public class ScannerSystemRuntimeTest {
    // @Test
    public void testScanner(){
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            int val = sc.nextInt();
            System.out.println(val);
        }
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }


    public void keyboardInTest() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){  // Ctrl + D，结束输入
            System.out.println("input line is : " + line);
        }
    }

    public static void main(String[] args) throws Exception{
        ScannerSystemRuntimeTest testObj = new ScannerSystemRuntimeTest();
        // testObj.testScanner();
        testObj.keyboardInTest();
    }


    @Test
    public void systemUsage() throws Exception{
        String prop = System.getProperty("os.name");
        System.out.println("os.name = " + prop);
        Properties props = System.getProperties();
        props.store(new FileOutputStream("props.txt"), "System.properties");


        for (Object key : props.keySet()){
            System.out.println(key + " :: " + props.get(key));
        }
    }


    @Test
    public void runtimeUsage() throws Exception{
        Runtime runtime = Runtime.getRuntime();
        System.out.println("处理器数量： " + runtime.availableProcessors());
        System.out.println("空闲内存大小：" + runtime.freeMemory()/8/1024/1024 + " G");
        System.out.println("总内存大小：" + runtime.totalMemory()/8/1024/1024 + " G");
        System.out.println("可用的最大内存大小：" + runtime.maxMemory()/8/1024/1024 + " G");

        // runtime.exec("notepad.exe");
    }



}
