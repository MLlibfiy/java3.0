package com.shujia.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo1 {
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(9999);

        /**
         * 等到客户端连接
         * 当客户端连接之后代码才会往下执行
         *
         */

        System.out.println("服务端启动成功....");

        while (true){
            Socket accept = serverSocket.accept();
            //没来一个新的请求，创建一个线程处理
            ServerThread serverThread = new ServerThread(accept);
            //启动线程
            new Thread(serverThread).start();

        }

    }
}

class ServerThread implements Runnable{

    private Socket accept;

    public ServerThread(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {


        InetAddress inetAddress = accept.getInetAddress();
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("接收到"+hostAddress+"的请求");

        try {
            //获取服务端输入流
            InputStream inputStream = accept.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");

            char[] chars = new char[1024];
            int length = inputStreamReader.read(chars);

            String str = new String(chars,0,length);

            System.out.println(str);



            //回一个消息给客户端
            OutputStream outputStream = accept.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write("数据已收到");
            outputStreamWriter.flush();


            //关闭管道
            accept.shutdownInput();
            accept.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
