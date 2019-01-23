package com.shujia.socket.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UpLoadServer {
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务端已启动.....");

        while (true){
            Socket socket = serverSocket.accept();
            UpLoadThread upLoadThread = new UpLoadThread(socket);
            new Thread(upLoadThread).start();
        }
    }
}

class UpLoadThread implements Runnable{

    private Socket socket;

    public UpLoadThread() {
    }

    public UpLoadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            String fileName = objectInputStream.readUTF();



            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);


            //边读边写


            FileOutputStream fileOutputStream = new FileOutputStream("D:\\data\\server\\"+fileName);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024 * 1024];

            int read ;
            while ((read = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes,0,read);
                bufferedOutputStream.flush();
            }

            bufferedOutputStream.close();
            fileOutputStream.close();
            socket.shutdownInput();

            System.out.println("文件接收成功");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

