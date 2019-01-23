package com.shujia.socket;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo2 {
    public static void main(String[] args) throws Exception{






        //建立连接
        Socket localhost = new Socket("localhost", 7777);

        //获取字节输出流-------节点流
        OutputStream outputStream = localhost.getOutputStream();

        //节点流---->处理流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        /* Student student = new Student("123456", "张三", "25", "男", "一班");

        objectOutputStream.writeObject(student);*/

        TaskThread taskThread = new TaskThread();

        /**
         * 将线程对象发送给服务端
         *
         */
        objectOutputStream.writeObject(taskThread);


        objectOutputStream.flush();

        localhost.shutdownOutput();


    }
}
