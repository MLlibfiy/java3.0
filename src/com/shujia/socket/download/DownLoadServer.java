package com.shujia.socket.download;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DownLoadServer {
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5555);


        System.out.println("服务端已启动.......");


       while (true){
           Socket accept = serverSocket.accept();
           DownLoadThread downLoadThread = new DownLoadThread(accept);
           new Thread(downLoadThread).start();
       }


    }
}

class DownLoadThread implements Runnable{

    private Socket accept;

    public DownLoadThread(Socket accept) {
        this.accept = accept;
    }

    public DownLoadThread() {
    }

    @Override
    public void run() {
       try {
           File file = new File("D:\\data\\server");
           File[] files = file.listFiles();

           OutputStream outputStream = accept.getOutputStream();
           ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
           objectOutputStream.writeObject(files);
           objectOutputStream.flush();


           InputStream inputStream = accept.getInputStream();
           ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
           File file1 = (File) objectInputStream.readObject();


           //读取需要下载的文件
           FileInputStream fileInputStream = new FileInputStream(file1);
           BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);


           BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

           byte[] bytes = new byte[1024 * 1024];
           int length ;
           while ((length= bufferedInputStream.read(bytes))!=-1){
               bufferedOutputStream.write(bytes,0,length);
               bufferedOutputStream.flush();
           }
           bufferedInputStream.close();
           fileInputStream.close();

           accept.shutdownOutput();
           accept.shutdownInput();

           System.out.println("下载成功");


       }catch (Exception e){
           e.printStackTrace();
       }
    }
}

