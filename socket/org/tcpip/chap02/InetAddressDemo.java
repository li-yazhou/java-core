package org.tcpip.chap02;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-01 20:00
 */

import java.net.*;
import java.util.Enumeration;

/**
 * InetAddresss,
 * NetworkInterface
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try{
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            if (interfaceList == null){
                System.out.println("--No interfaces found--");
            } else {
                while (interfaceList.hasMoreElements()){
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface " + iface.getName() + ":");
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();
                    if (!addrList.hasMoreElements())
                        System.out.println("\t(No addresses for this interface)");

                    while (addrList.hasMoreElements()){
                        InetAddress address = addrList.nextElement();
                        System.out.print("\tAddress " +
                                ((address instanceof Inet4Address ? "(v4)" : (address instanceof Inet6Address ? "(v6)" : "(?)")))
                        );
                        System.out.println(": " + address.getHostAddress());
                    }
                }
            }
        } catch (SocketException except){
            System.out.println("Error getting network interfaces : " + except.getMessage());
            System.out.println("Error getting network interfaces : " + except.getMessage());
        }


        // Get names(s)/address(es) of hosts given on command line
        for (String host : args){
            try {
                System.out.println(host + ":");
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for (InetAddress address : addressList){
                    System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
                }
            } catch (UnknownHostException e){
                System.out.println("\tUnable to find address for " + host);
            }
        }
    }

}

























