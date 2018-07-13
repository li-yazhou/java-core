package org.alpha.javabase.javabook.fkjava.ch15_io.nio7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 16:30
 */
public class FilesTest {

    public static void main(String... args) throws IOException {
        String srcPathStr = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\nio7\\FilesTest.java";
        String distPathStr = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\out\\files.copy.txt";
        Path srcPath = Paths.get(srcPathStr);
        Files.copy(srcPath, new FileOutputStream(distPathStr));

        List<String> lines = Files.readAllLines(srcPath);
        System.out.println(lines);

        long size = Files.size(srcPath);  // 字节数，Returns the size of a file (in bytes)
        System.out.println(srcPath + " 的大小为 " + size);

        String distPathStr2 = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\out\\files.copy2.txt";
        Path distPath2 = Paths.get(distPathStr2);
        List<String> content = new ArrayList<>();
        content.add("line1.");
        content.add("line2..");
        content.add("line3...");
        content.add("line4....");
        content.add("line5.....");
        Files.write(distPath2, content, Charset.forName("UTF-8"));

        Path cPath = Paths.get("c:");
        FileStore fileStore = Files.getFileStore(cPath);
        long capacity = fileStore.getTotalSpace() / 1024 / 1024 / 1024;
        System.out.println(cPath + " 的大小为 " + capacity);
        long usableSpace = fileStore.getUsableSpace() / 1024 / 1024 / 1024;
        System.out.println(cPath + " 的大小为 " + usableSpace);
    }
}
