package javase.proxy.jdkproxy;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-13 8:18
 */
public class ClassLoaderTest {
    @Test
    public void classLoaderExtends(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);

        /*
            sun.misc.Launcher$AppClassLoader@6d06d69c
            sun.misc.Launcher$ExtClassLoader@5b2133b1
            null
         */
    }


    @Test
    public void bootstrapClassLoader(){
        ClassLoader loader = System.class.getClassLoader();
        System.out.println(loader);   // null
    }
}
