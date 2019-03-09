package javabase.javase.io.iobase;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-26 21:43
 */
public class FilenameFilterTest {

    private class MyFilenameFilter implements FilenameFilter{
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".java") || new File(name).isDirectory();
        }
    }


    @Test
    public void listWithFilter(){
        File file = new File(".");
        String[] nameList = file.list(new MyFilenameFilter());
        PrintUtils.println(Arrays.toString(nameList));

    }
}
