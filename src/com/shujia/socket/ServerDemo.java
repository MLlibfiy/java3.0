package com.shujia.socket;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

    /**
     * 1、扽客户端连接
     * 2、建立连接
     * 3、数据传输
     * 4、关闭连接
     */
    public static void main(String[] args) throws Exception {
        /**
         * 绑定一个端口号
         *创建服务端socket对象
         */
        ServerSocket serverSocket = new ServerSocket(8888);

        /**
         * 等到客户端连接
         * 当客户端连接之后代码才会往下执行
         *
         */

        System.out.println("服务端启动成功....");
        Socket accept = serverSocket.accept();
        System.out.println("连接之后....");

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


    }
}
