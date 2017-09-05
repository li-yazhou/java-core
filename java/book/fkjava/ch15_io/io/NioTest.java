package book.fkjava.ch15_io.io;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-13 17:00
 */
public class NioTest {

    @Test
    public void bufferTest(){
        // 创建Buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println(String.format("buff.capacity() = %s", buff.capacity()));
        System.out.println(String.format("buff.limit() = %s", buff.limit()));
        System.out.println(String.format("buff.position() = %s", buff.position()));
        System.out.println();

        // 写入数据，向buffer中放入元素
        buff.put('a');
        buff.put('b');
        System.out.println(String.format("buff.limit() = %s", buff.limit()));
        System.out.println(String.format("buff.position() = %s", buff.position()));
        System.out.println();

        // 调用 flip()，输入结束，准备输出
        buff.flip();
        System.out.println("execute flip");
        System.out.println(String.format("buff.limit() = %s", buff.limit()));
        System.out.println(String.format("buff.position() = %s", buff.position()));
        System.out.println();

        // get
        // System.out.println(String.format("buff中position指向的元素，%s", buff.get()));
        System.out.println(String.format("buff中的第一个元素，%s", buff.get(0)));
        System.out.println(String.format("buff中的第二个元素，%s", buff.get(1)));
        // System.out.println(String.format("buff中的第二个元素，%s", buff.get(2))); // java.lang.IndexOutOfBoundsException
        System.out.println(String.format("buff.limit() = %s", buff.limit()));
        System.out.println(String.format("buff.position() = %s", buff.position()));
        System.out.println(String.format("buff中position指向的元素，%s", buff.get()));
        System.out.println(String.format("buff.limit() = %s", buff.limit()));
        System.out.println(String.format("buff.position() = %s", buff.position()));
        System.out.println();


        // clear
        buff.clear();
        System.out.println(String.format("buff.limit() = %s", buff.limit()));
        System.out.println(String.format("buff.position() = %s", buff.position()));
        System.out.println(String.format("buff中的第二个元素，%s", buff.get(1)));
        System.out.println(String.format("buff.limit() = %s", buff.limit()));
        System.out.println(String.format("buff.position() = %s", buff.position()));
        System.out.println();
    }


    @Test
    public void channelTest() throws IOException{
        String path = "D:\\workspace\\algorithm_java\\src\\javacore\\book\\fkjava\\ch15_io\\NioTest.java";
        File file = new File(path);
        // 输入通道
        FileChannel inChannel = new FileInputStream(file).getChannel();
        FileChannel outChannel = new FileOutputStream("outChannel.txt").getChannel();

        // MappedByteBuffer mbbuff
        ByteBuffer bbuff = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        outChannel.write(bbuff);

        // bbuff.flip();
        // bbuff.clear();  // 将pos指向0地址，再次读取数据
        // System.out.println(bbuff);  // java.nio.DirectByteBufferR[pos=0 lim=3433 cap=3433]

        // bbuff.rewind();
        bbuff.clear();
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer cbuff = decoder.decode(bbuff);
        System.out.println(cbuff);

        inChannel.close();
        outChannel.close();
    }


    @Test
    public void randomFileChannelTest() throws IOException{
        File file = new File("random access file.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel randomChannel = randomAccessFile.getChannel();
        ByteBuffer bbuff = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        // String initial = "initial content..\n";
        // ByteBuffer bbuff = randomChannel.map(FileChannel.MapMode.READ_WRITE, 0, initial.length());
        // bbuff.put(initial.getBytes());
        randomChannel.position(file.length());
        System.out.println(file.length());
        randomChannel.write(bbuff);
    }


    @Test
    public void readFileTest() throws IOException{
        String path = "D:\\workspace\\algorithm_java\\src\\javacore\\book\\fkjava\\ch15_io\\NioTest.java";
        try(
                FileInputStream fis = new FileInputStream(path);
                FileChannel inChannel = fis.getChannel()
        ){
            ByteBuffer bbuff = ByteBuffer.allocate(1);
            // int counter = 0;
            while (inChannel.read(bbuff) != -1){
                // System.out.println(counter ++);
                bbuff.flip();
                Charset charset = Charset.forName("UTF-8");
                CharBuffer cbuff = charset.decode(bbuff);
                // CharsetDecoder decoder = charset.newDecoder();
                // CharBuffer cbuff = decoder.decode(bbuff);
                System.out.println(cbuff);
                bbuff.clear();
            }
        }
    }



}
