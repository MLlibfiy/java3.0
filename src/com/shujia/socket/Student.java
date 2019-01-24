package com.shujia.socket;

import java.io.Serializable;

/**
 * Serializable  标记这个类的对象可以序列化
 *
 * 序列化 ： 将java里面的对象存到磁盘或者在网络中传输的过程，称为序列化
 * 反序列化：读取文件里面的对象或者读取网络中的对象称为反序列化
 */
public class Student implements Serializable {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String clazz;

    @Override
    public String toString() {
        return "com.shujia.refiect.Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String id, String name, String age, String gender, String clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
