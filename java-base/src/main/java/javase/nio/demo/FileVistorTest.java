package javase.nio.demo;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 16:49
 */
public class FileVistorTest {
    public static void main(String... args) throws IOException {
        Path path = Paths.get("D:\\workspace\\algorithm_java");
        // int fileCounter = 0;
        // int dirCounter = 0;
        // int total = 0;
        Files.walkFileTree(path,
                new SimpleFileVisitor<Path>(){
                    @Override
                    public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs){
                        System.out.println("正在访问 " + filePath + " 文件");
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult preVisitDirectory(Path dirPath, BasicFileAttributes attrs){
                        System.out.println("正在访问 " + dirPath + " 目录");
                        return FileVisitResult.CONTINUE;
                    }
                }
        );
    }
}
