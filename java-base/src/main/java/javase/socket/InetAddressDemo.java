package javase.socket;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-02 14:09
 */
public class InetAddressDemo {

    @Test
    public void test(){
        try {
            InetAddress address = InetAddress.getByName("wwww.baidu.com");
            System.out.println(address);
            System.out.println("address.getHostAddress() = " + address.getHostAddress());
            System.out.println("address.getAddress() = " + new String(address.getAddress()));

            address = InetAddress.getByAddress(address.getAddress());
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public void InetAddressDemo(){}

    public InetAddressDemo(){}
}
