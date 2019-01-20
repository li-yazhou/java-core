package org.alpha.javabase.javase.io.iobase;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-26 21:27
 */
public class FileTest {

    @Test
    public void fileClassUsage(){
        File file = new File(".");  // project目录下

        String filename = file.getName();
        // System.out.println("filename = " + filename);
        PrintUtils.println("filename = " + filename);

        String parent = file.getParent();
        PrintUtils.println("parent = " + parent);

        String absolutePath = file.getAbsolutePath();
        PrintUtils.println("absolutePath = " + absolutePath);

        File absoluteFile = file.getAbsoluteFile();
        PrintUtils.println("absoluteFile.getName() = " + absoluteFile.getName());

        File[] childrenFiles = file.listFiles();
        String[] childrenFileNames = file.list();
        PrintUtils.println(Arrays.toString(childrenFileNames));

        PrintUtils.println("----------------------");

        File[] rootFiles = File.listRoots();
        for (File rootFile : rootFiles){
            PrintUtils.println(rootFile.getName());
        }

    }
}
