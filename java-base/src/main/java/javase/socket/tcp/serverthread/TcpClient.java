package javase.socket.tcp.serverthread;

import java.io.*;
import java.net.Socket;

/**
 * description:
 * 客户端
 * @author liyazhou
 * @since 2017-07-25 20:45
 */
public class TcpClient {

    public static void main(String[] args){
        try {
            // 1. 创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("localhost", 1438);

            // 2. 获取输出流，向服务器端发送信息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);  // 将输入流包装为打印流
            pw.write("用户名：root；密码：root");
            pw.flush();
            socket.shutdownOutput();

            InputStream ips = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println("我是客户端，服务器端想我发来信息：" + line);
            }

            // 关闭资源
            br.close();
            ips.close();

            pw.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


























