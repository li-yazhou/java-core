package book.fkjava.ch15_io.nio4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-27 14:59
 */
public class BufferTest {

    public static void main(String... args){
        String srcPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\nio\\BufferTest.java";
        String distPath = "D:\\workspace\\algorithm_java\\java\\book\\fkjava\\ch15_io\\out\\BufferTest.txt";
        // File file = new File(path);
        try (
                FileInputStream fileInputStream = new FileInputStream(srcPath);
                FileChannel inChannel = fileInputStream.getChannel();

                FileOutputStream fileOutputStream = new FileOutputStream(distPath);
                FileChannel outChannel = fileOutputStream.getChannel()
        ) {
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileInputStream.available());
            outChannel.write(buffer);
            buffer.clear();

            Charset charset = Charset.forName("GBK");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
