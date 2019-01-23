package com.shujia.socket.download;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class DownLoadClient {
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("localhost", 5555);

        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        //获取文件列表
        File[] files = (File[])objectInputStream.readObject();

        System.out.println("请选择需要下载的文件：");

        for (int i = 0; i < files.length; i++) {
            System.out.println(i+" : "+files[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        //需要下载的文件对象
        File file = files[index];

        //将需要下载额文件对象发送给服务端
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(file);
        objectOutputStream.flush();


        FileOutputStream fileOutputStream = new FileOutputStream("D:\\data\\client\\" + file.getName());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        //下载文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        byte[] bytes = new byte[1024 * 1024];
        int length ;
        while ((length= bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,length);
            bufferedOutputStream.flush();
        }

        bufferedOutputStream.close();
        fileOutputStream.close();

        socket.shutdownInput();

    }
}
