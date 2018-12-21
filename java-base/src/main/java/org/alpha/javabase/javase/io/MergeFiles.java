package org.alpha.javabase.javase.io;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/21
 */
public class MergeFiles {


    @Test
    public void testMergeFiles() throws IOException {

        File file_1 = new File("/Users/liyazhou1/self-repo/java-core/java-base/src/main/resources/io/1.txt");
        File file_2 = new File("/Users/liyazhou1/self-repo/java-core/java-base/src/main/resources/io/2.txt");
        File file_3 = new File("/Users/liyazhou1/self-repo/java-core/java-base/src/main/resources/io/3.txt");
        List<File> fileList = Arrays.asList(file_1, file_2, file_3);

        File distFile = new File("/Users/liyazhou1/self-repo/java-core/java-base/src/main/resources/io/1_2_3.txt");
        mergeFiles(fileList, distFile);

    }


    public void mergeFiles(List<File> fileList, File distFile) throws IOException {
        List<FileInputStream> inputStreams = new ArrayList<>();
        for (File file : fileList) {
            inputStreams.add(new FileInputStream(file));
        }

        Enumeration<FileInputStream> en = Collections.enumeration(inputStreams);

        SequenceInputStream sequenceInputStream = new SequenceInputStream(en);

        FileOutputStream fileOutputStream = new FileOutputStream(distFile);

        byte[] _1KB = new byte[1024];

        for (int len; (len = sequenceInputStream.read(_1KB)) != -1; ) {
            fileOutputStream.write(_1KB, 0, len);
        }

        sequenceInputStream.close();
        fileOutputStream.close();
    }

}
