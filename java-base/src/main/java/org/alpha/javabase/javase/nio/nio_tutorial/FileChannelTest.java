package org.alpha.javabase.javase.nio.nio_tutorial;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-16 11:21
 */
public class FileChannelTest {

    @Test
    public void test() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("readAndWriteFile.txt", "rw");

        System.out.println("xxxxxxxxxx");
        FileChannel inChannel = accessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        int len = inChannel.read(byteBuffer);
        while (len != -1){
            System.out.println("Read " + len);
            // TODO: 2017/9/16
            byteBuffer.flip();
            while (byteBuffer.hasRemaining())
                System.out.print((char)byteBuffer.get());
            byteBuffer.clear();
            len = inChannel.read(byteBuffer);
        }
        accessFile.close();
    }
}
