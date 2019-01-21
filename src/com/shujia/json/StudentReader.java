package com.shujia.json;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.println;

public class StudentReader {
    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("java/data/students.txt");

        BufferedReader bufferedReader = new BufferedReader(reader);

        ArrayList<Student> students = new ArrayList<>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            String id = split[0];
            String name = split[1];
            String age = split[2];
            String gender = split[3];
            String clazz = split[4];
            Student student = new Student(id, name, age, gender, clazz);
            //放到集合中
            students.add(student);
        }


        FileWriter fileWriter = new FileWriter("java/data/student.json");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Gson gson = new Gson();


        for (Student student : students) {
            String json = gson.toJson(student);

            bufferedWriter.write(json);
            bufferedWriter.newLine();
        }


        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
}
