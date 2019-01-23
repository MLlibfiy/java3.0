package com.shujia.socket.upload;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class UpLoadClient {
    public static void main(String[] args) throws Exception {


        Socket socket = new Socket("localhost", 6666);


        System.out.println("连接建立成功......");

        /**
         * 读取磁盘上的文件
         *
         */

        File file = new File("D:\\data\\client");
        File[] files = file.listFiles();

        System.out.println("请选择需要上传的文件：");

        for (int i = 0; i < files.length; i++) {
            System.out.println(i + " : " + files[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        File file1 = files[index];


        /**
         * 发送文件名
         *
         */

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeUTF(file1.getName());
        objectOutputStream.flush();

        /**
         * 读取文件
         *
         */

        FileInputStream fileInputStream = new FileInputStream(file1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);


        //获取网络输出流

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        /**
         *边读边写
         */

        byte[] bytes = new byte[1024 * 1024];

        int read ;
        while ((read = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes,0,read);
            bufferedOutputStream.flush();

            //一秒发1M
            //Thread.sleep(1000);
        }

        bufferedInputStream.close();
        fileInputStream.close();
        socket.shutdownOutput();

        System.out.println("文件发送成功");

    }
}
