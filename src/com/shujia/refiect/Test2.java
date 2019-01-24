package com.shujia.refiect;

public class Test2 {

    public static void main(String[] args) {
        test("张三", "李四");

    }

    /**
     * 可变参数
     * <p>
     * 传进来的参数被放到一个数组里面
     * names：数组
     * <p>
     * 如果还有其他参数，可变参数要放在最后
     */
    public static void test(String id, String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
