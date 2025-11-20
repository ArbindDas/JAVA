package AdvanceJava.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.javatpoint.com");
        System.out.println(inetAddress);
    }
}
