package javase.socket;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-02 16:00
 */
public class UrlDemo {

    @Test
    public void test(){
        // String path = "http://www.baidu.com";
        String path = "http://blog.csdn.net/liyazhou0215/article/details/77431561";
        InputStream in = null;
        try {
            URL url = new URL(path);
            in = url.openStream();
            BufferedInputStream buff = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(buff);
            int ch;
            while ((ch = reader.read()) != -1)
                System.out.print((char)ch);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally{
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
