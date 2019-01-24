package com.shujia.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = readStudent();
        HashMap<String, Student> sMap = new HashMap<>();
        for (Student student : students) {
            sMap.put(student.getId(), student);
        }

        ArrayList<Score> scores = readScore();

        for (Score score : scores) {
            String student_id = score.getStudent_id();
            Student student = sMap.get(student_id);
            System.out.println(
                    student.getId() + "\t" +
                            student.getName() + "\t" +
                            student.getAge() + "\t" +
                            student.getGender() + "\t" +
                            student.getClazz() + "\t" +
                            score.getCource_id() + "\t" +
                            score.getScore()
            );

        }


    }

    /**
     * 读取学生表
     */
    public static ArrayList<Student> readStudent() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("java/data/students.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strs = line.split(",");
                String id = strs[0];
                String name = strs[1];
                Integer age = Integer.parseInt(strs[2]);
                String gender = strs[3];
                String clazz = strs[4];
                Student student = new Student(id, name, age, gender, clazz);
                students.add(student);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;

    }

    public static ArrayList<Score> readScore() {
        ArrayList<Score> scores = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("java/data/score.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                String s_id = split[0];
                String c_id = split[1];
                Integer s = Integer.parseInt(split[2]);
                Score score = new Score(s_id, c_id, s);
                scores.add(score);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scores;
    }
}
