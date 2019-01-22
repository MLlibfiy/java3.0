package com.shujia.socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) throws Exception{

        /**
         * 访问一个服务
         *  ip,端口
         *
         * 和服务端建立连接，如果连接建立成功会创建socket对象
         */

        Socket socket = new Socket("localhost", 8888);
        System.out.println("连接建立成功....");


        /**
         * 发生数据给服务端
         * 客户端（输出流）----->服务端（输入流）
         *
         */

        //通过socket对象获取输出流i


        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "utf-8");
        writer.write("数加科技");
        writer.flush();


        //接收服端发送过来的数据
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] chars = new char[1024];
        int length = inputStreamReader.read(chars);
        String result = new String(chars, 0, length);
        System.out.println(result);



        //关闭管道
        //outputStream.close();不能使用这个
        socket.shutdownOutput();
        socket.shutdownInput();


    }
}
