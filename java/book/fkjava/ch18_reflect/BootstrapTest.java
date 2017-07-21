package book.fkjava.ch18_reflect;


import org.junit.Test;

import java.net.URL;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-14 13:51
 */
public class BootstrapTest {

    public static void main(String[] args){
        // 获取
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i ++)
            System.out.println(urls[i].toExternalForm());
    }

    @Test
    public void classLoaderTest(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        System.out.println("SystemClassLoader = " + systemClassLoader);
        System.out.println("ExtensionClassLoader = " + extensionClassLoader);
        System.out.println("bootstrapClassLoader = " + bootstrapClassLoader);
    }
}
