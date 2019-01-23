package com.shujia.socket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestOnjectOutpputStream {
    public static void main(String[] args) throws Exception {

        /**
         * 将对象写道磁盘
         *
         * 字节流转对象流
         *
         */
        FileOutputStream fileOutputStream = new FileOutputStream("java/data/object.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Student student = new Student("123456", "张三", "25", "男", "一班");

        objectOutputStream.writeObject(student);
        objectOutputStream.write(23);
        objectOutputStream.writeUTF("数加");

        objectOutputStream.flush();

        objectOutputStream.close();
        fileOutputStream.close();


        /**
         * 读取文件中的对象
         *
         */

        FileInputStream fileInputStream = new FileInputStream("java/data/object.txt");

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


        /**
         * 对象流
         * 读取对象得按照写入对象的顺序读取
         *
         */

        Student s = (Student)objectInputStream.readObject();
        System.out.println(s);

        int read = objectInputStream.read();

        System.out.println(read);
        String str = objectInputStream.readUTF();
        System.out.println(str);





    }

}
