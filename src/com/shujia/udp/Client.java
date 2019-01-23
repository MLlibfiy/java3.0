package com.shujia.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args)throws Exception {

        //创建发送数据报包的对象
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] bytes = "数加科技".getBytes();

        //创建数据报包
        DatagramPacket date = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("localhost"), 2000);

        /**
         *
         * 数据报包由路由器转发到目的地
         */

        datagramSocket.send(date);
        datagramSocket.close();
        System.out.println("发送成功");

    }
}
