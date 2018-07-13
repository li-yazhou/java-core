package org.alpha.javabase.javase.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description:
 *  服务器端
 *  基于TCP协议的Socket通信，实现用户登录
 * @author liyazhou
 * @since 2017-07-25 20:44
 */
public class TcpServer {
    public static void main(String... args){
        try {
            // 1. 创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(1024);

            // 2. 调用 accept 方法开始监听，等待客户端的连接请求
            System.out.println("开启服务器端，等待客户端的连接请求....");
            Socket socket = serverSocket.accept();

            // 3. 获取输入流，读取客户端发送的信息
            InputStream inputStream = socket.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = buffer.readLine()) != null)
                System.out.println("我是服务器端，客户端发来信息：" + line);

            socket.shutdownInput();  // 关闭输入流


            // 4. 获取输出流，向客户端发送信息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.write("欢迎你登录服务器。");
            pw.flush();
            pw.close();

            // socket.shutdownOutput();


            // 5. 关闭资源
            pw.close();
            outputStream.close();
            buffer.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}














