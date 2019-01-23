package com.shujia.socket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

       /* Student s = (Student)objectInputStream.readObject();
        System.out.println(s);*/

        /**
         * 接收线程对象并启动线程
         *
         */
        TaskThread taskThread = (TaskThread) objectInputStream.readObject();
        new Thread(taskThread).start();
        accept.shutdownInput();


    }
}
