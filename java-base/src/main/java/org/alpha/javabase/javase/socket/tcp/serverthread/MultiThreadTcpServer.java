package org.alpha.javabase.javase.socket.tcp.serverthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-25 21:39
 */
public class MultiThreadTcpServer {

    public static void main(String[] args){

        // 创建服务器端socket
        try {
            ServerSocket serverSocket = new ServerSocket(1438);
            System.out.println("启动服务器....");
            int counter = 0;
            while(true){
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                counter ++;
                System.out.println("登录客户端的数量是：" + counter);

                if (counter == 3) break;
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
