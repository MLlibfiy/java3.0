package com.shujia.student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        //读取科目表
        ArrayList<Cource> cources = ReadUtil.read("java/data/Cource.txt", Cource.class);
        //读取学生表
        ArrayList<Student> students = ReadUtil.read("java/data/students.txt", Student.class);
        //读取分数表
        ArrayList<Score> scores = ReadUtil.read("java/data/score.txt", Score.class);

        /**
         * 计算学生总分
         * 结果：学号，姓名，年龄，性别，班级，总分
         *总分倒序
         */

        //1、根据分数表计算学生总分

        HashMap<String, Integer> sumScoreMap = new HashMap<>();

        for (Score score : scores) {
            Integer integer = sumScoreMap.get(score.getStudent_id());
            //如果integer等于null，说明这个学生还是第一次计算
            if (integer == null) {
                sumScoreMap.put(score.getStudent_id(), score.getScore());
            } else {
                //如果integer不等于null，说明map里面已经有了一部分结果
                sumScoreMap.put(score.getStudent_id(), score.getScore() + integer);
            }
        }

        FileWriter fileWriter = new FileWriter("java/data/sumScore.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        ArrayList<String> sumScoreInfoList = new ArrayList<>();

        //总分表关联学生信息表

        for (Student student : students) {
            Integer sumScore = sumScoreMap.get(student.getId());
            String sumScoreInfo = student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getGender() + "\t" + student.getClazz() + "\t" + sumScore;
            sumScoreInfoList.add(sumScoreInfo);
        }

        //总分倒序排序
        Collections.sort(sumScoreInfoList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int sumScore1 = Integer.parseInt(s1.split("\t")[5]);
                int sumScore2 = Integer.parseInt(s2.split("\t")[5]);

                return  sumScore2 - sumScore1;
            }
        });

        //将结果保存到文件
        for (String s : sumScoreInfoList) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
