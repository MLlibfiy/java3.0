package com.shujia.refiect;

public class Student {

    private String id;
    private String name;
    private Integer age;

    public void a(){
        System.out.println("a1");
    }

    public void a(Integer a){
        System.out.println("a2"+a);
    }

    public void b(Integer b){
        System.out.println("b"+b);
    }

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
