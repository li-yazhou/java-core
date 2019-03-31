package javase.io;

import java.io.*;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/17
 */
public class CopyByteFileDemo {


    public static void copy_4() throws IOException {
        FileInputStream fis = new FileInputStream("0.mp3");
        FileOutputStream fos = new FileOutputStream("4.mp3");

        int ch = 0;

        while((ch =fis.read())!=-1){
            fos.write(ch);
        }

        fos.close();
        fis.close();
    }


    public static void copy_3() throws IOException {
        FileInputStream fis = new FileInputStream("0.mp3");
        FileOutputStream fos = new FileOutputStream("3.mp3");

        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fos.write(buf);
        fos.close();
        fis.close();
    }


    public static void copy_2() throws IOException {

        FileInputStream fis = new FileInputStream("0.mp3");
        BufferedInputStream bufis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("2.mp3");
        BufferedOutputStream bufos = new BufferedOutputStream(fos);

        int ch = 0;

        while((ch=bufis.read())!=-1){
            bufos.write(ch);
        }

        bufos.close();
        bufis.close();
    }


    public static void copy_1() throws IOException {

        FileInputStream fis = new FileInputStream("0.mp3");
        FileOutputStream fos = new FileOutputStream("1.mp3");

        byte[] buf = new byte[1024];

        int len = 0;

        while((len=fis.read(buf))!=-1){
            fos.write(buf,0,len);
        }

        fos.close();
        fis.close();
    }

}
