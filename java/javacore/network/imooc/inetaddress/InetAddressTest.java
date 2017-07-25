package javacore.network.imooc.inetaddress;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-25 19:33
 */
public class InetAddressTest {

    @Test
    /**
     * 获取本机的 InetAdderss 对象
     */
    public void localHost(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名：" + inetAddress.getHostName());
            System.out.println("IP地址：" + inetAddress.getHostAddress());
            byte[] address = inetAddress.getAddress();
            System.out.println("address" + Arrays.toString(address));
            System.out.println("inetAddress：" + inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 根据IP地址获取InetAddress对象
     */
    public void getAddressByName() throws UnknownHostException {
        InetAddress inetAddress1 = InetAddress.getByName("DESKTOP-5LH4MOU");
        InetAddress inetAddress2 = InetAddress.getByName("219.216.77.224");
        System.out.println(inetAddress1);
        System.out.println(inetAddress2);
        System.out.println(inetAddress2.getHostName());
    }

}




















