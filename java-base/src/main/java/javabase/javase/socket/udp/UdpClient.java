package javabase.javase.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-25 22:14
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        /**
         * 向服务器端发送数据
         */
        // 1. 定义服务器的地址、端口号、数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 3333;
        byte[] data = "用户名：root；密码：root".getBytes();
        // 2. 创建数据报，包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

        // 3. 创建DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(packet);


        /**
         * 接收服务器端发过来的数据
         */
        // 定义数据报
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        // 接收服务器发送的数据
        datagramSocket.receive(receivePacket);

        // 读取接收到的数据
        String line = new String(receiveData, 0, receiveData.length);
        System.out.println("我是客户端，服务器端发送的数据是：" + line);

        // 关闭资源
        datagramSocket.close();
    }























}
