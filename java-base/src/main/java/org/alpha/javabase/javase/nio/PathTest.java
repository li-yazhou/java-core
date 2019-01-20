package org.alpha.javabase.javase.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 16:19
 */
public class PathTest {
    public static void main(String... args){
        Path path = Paths.get(".");
        System.out.println(path + " 里包含的路径数量 " + path.getNameCount() + "\n");

        Path rootPath = path.getRoot();
        System.out.println(path + " 的根路径 " + rootPath + "\n");

        Path absolutePath = path.toAbsolutePath();
        System.out.println(path + " 的绝对路径是 " + absolutePath + "\n");

        Path rootPathOfAbsolutePath = absolutePath.getRoot();
        System.out.println(absolutePath + " 的根路径是 " + rootPathOfAbsolutePath + "\n");

        System.out.println(absolutePath + " 里包含的路径数量 " + rootPathOfAbsolutePath.getNameCount() + "\n");

        Path path1 = Paths.get("c:", "用户", "liyazhou");
        System.out.println(path1 + "\n");



    }
}
