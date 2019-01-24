package com.shujia.student;

import java.util.ArrayList;

public class Demo3 {
    public static void main(String[] args) {
        Test<Integer> stringTest = new Test<Integer>();
        Integer test = stringTest.test(12);
        stringTest.test1(12);
        System.out.println(test);


    }


}

//泛型类
class Test<B> {
    /**
     * 泛型方法
     * 方法调用得分时候确定类型
     * 泛型：在编译的时候起作用
     */

    public <T> T test(T str) {
        return str;
    }

    public B test1(B str) {
        return str;
    }
}
