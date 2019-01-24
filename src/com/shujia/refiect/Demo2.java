package com.shujia.refiect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //获取类对象
        Class aClass = Class.forName("com.shujia.refiect.Student");

        //获取类的无参构造函数，万物皆对象
        Constructor<Object> constructor = aClass.getConstructor();

        //通过反射创建对象，通过构造函数创建
        Object o = constructor.newInstance();

        System.out.println(o);

        //通过反射创建对象，通过类对象创建类的对象
        //调用类的无参构造函数创建对象
        Object o1 = aClass.newInstance();

        System.out.println(o1);



        //获取类对象的有参构造函数
        //指定参数类型获取有参构造函数
        Constructor constructor1 = aClass.getConstructor(String.class, String.class);
        Object zs = constructor1.newInstance("001", "张三");

        System.out.println(zs);



        //获取所有的构造函数
        Constructor[] constructors = aClass.getConstructors();


        System.out.println("类名："+aClass.getName());


        //获取类的所有属性
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName()); //属性的名称
            System.out.println(field.getType());//属性的类型

        }


        //获取类的所有方法
        Method[] declaredMethods = aClass.getMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);

        }

        //获取类方法名为a,方法参数为Integer的方法对象
        Method method = aClass.getMethod("a", Integer.class);

        //new Student().a(10);


        //执行方法

        /**
         * java里面执行一个方法需要依赖一个对象，通过反射执行方法的时候也不例外
         *
         */
        method.invoke(aClass.newInstance(),10);



    }
}
