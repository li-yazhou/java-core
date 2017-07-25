package javacore.network.imooc.inetaddress;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-25 20:00
 */
public class URLTest {

    @Test
    public void UrlTest(){
        try {
            URL rootUrl = new URL("http://www.baidu.com");
            // ? 后面表示参数，#后面表示锚点
            URL url = new URL(rootUrl, "/index.html?username=tom#test");
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            // 如果为指定端口号，则使用默认的端口号，此时getPort方法返回值是-1
            System.out.println("端口：" + url.getPort());

            System.out.println("文件路径：" + url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("文件相对路径：" + url.getRef());  // 锚点
            System.out.println("查找字符串：" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void urlTest(){
        try {
            URL url = new URL("http://www.baidu.com");
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = null;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null){
                counter ++;
                System.out.println(line);
            }
            System.out.println("counter = " + counter);
            bufferedReader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}




















