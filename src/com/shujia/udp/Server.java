package com.shujia.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception{

        //创建接收数据的对象，绑定一个端口
        DatagramSocket datagramSocket = new DatagramSocket(2000);

        byte[] bytes = new byte[1024*64];

        //创建一个空的数据报包
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);


        System.out.println("等待接收数据");

        //等待接收数据
        datagramSocket.receive(datagramPacket);

        String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

        System.out.println(s);


    }
}
