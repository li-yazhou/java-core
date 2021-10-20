package _dev;

import java.io.File;
import java.nio.file.Paths;

import javax.annotation.Nonnull;

/**
 * @author liyazhou03 <liyazhou03@kuaishou.com>
 * Created on 2021-10-20
 */
public class _20211020_GeektimeCourse {

    private static void extractHtmlAndPdf() {
        File root = new File("/Users/liyazhou/CS/Geektime/_Core");
        if (root.isFile()) {
            return;
        }
        int count = 0;
        for (File course : listFiles(root)) {
//            if (course.getName().equals("_Core")) {
//                continue;
//            }
            String dir = course.getAbsolutePath();
            System.out.println("dir = " + dir);
            if (!course.isDirectory()) {
                continue;
            }
            count ++;
            for (File unit : listFiles(course)) {
                if (!unit.isDirectory()) {
                    continue;
                }
                File[] chapters = listFiles(unit);
                for (File ch : chapters) {
                    if (ch.isFile() &&
                            (ch.getName().endsWith("html")
                                    || ch.getName().endsWith("pdf")
                                    || ch.getName().endsWith("mp3")
                                    || ch.getName().endsWith("m4a"))) {
                        File dist = Paths.get(dir, ch.getName()).toFile();
                        ch.renameTo(dist);
                    }
                }
            }
            if (count > 100) {
                return;
            }
        }
    }

    private static File[] listFiles(@Nonnull File file) {
        File[] children = file.listFiles();
        if (children == null) {
            return new File[0];
        }
        return children;
    }

    public static void main(String[] args) {
        extractHtmlAndPdf();
    }
}
