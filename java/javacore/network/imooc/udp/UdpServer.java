package javacore.network.imooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-25 20:55
 */
public class UdpServer {
    private final static int _1M = 1024;

    public static void main(String[] args){
        try {
            // 1.创建服务器端 DatagramSocket，指定端口
            DatagramSocket datagramSocket = new DatagramSocket(3333);
            System.out.println("启动udp服务器....");
            // 2. 创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[_1M];
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
            // 3. 接收客户端发送的数据
            datagramSocket.receive(datagramPacket);

            // 4. 读取数据
            String info = new String(data, 0, datagramPacket.getLength());
            System.out.println("我是udp服务器端，客户端发来信息：" + info);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}





















