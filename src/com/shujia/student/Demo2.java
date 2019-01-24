package com.shujia.student;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args) throws Exception {

        ArrayList<Student> read = ReadUtil.read("java/data/students.txt", Student.class);

        for (Student score : read) {
            System.out.println(score);
        }

    }
}
