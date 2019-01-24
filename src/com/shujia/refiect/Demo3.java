package com.shujia.refiect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo3 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        /**
         * 泛型只在编译时起作用
         *
         */
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student());

        System.out.println(students);

        Class aClass = students.getClass();


        /**
         * 通过反射绕过泛型对类型的限制
         *
         */

        Method add = aClass.getMethod("add", Object.class);


        /**
         * 执行方法
         */
        add.invoke(students,"数加");

        add.invoke(students,12);

        System.out.println(students);
    }

}
