package com.shujia.student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class Top10StudentInfo {

    /**
     * 查询年级排名前十学生各科的分数 [学号,学生姓名，学生班级，科目名，分数]
     */
    public static void main(String[] args) throws Exception {
        //读取科目表
        ArrayList<Cource> cources = ReadUtil.read("java/data/Cource.txt", Cource.class);
        //读取学生表
        ArrayList<Student> students = ReadUtil.read("java/data/students.txt", Student.class);
        //读取分数表
        ArrayList<Score> scores = ReadUtil.read("java/data/score.txt", Score.class);


        HashMap<String, Integer> sumScoreMap = new HashMap<>();

        //计算学生总分
        for (Score score : scores) {
            Integer integer = sumScoreMap.get(score.getStudent_id());
            if (integer == null) {
                sumScoreMap.put(score.getStudent_id(), score.getScore() );
            } else {
                sumScoreMap.put(score.getStudent_id(), score.getScore() + integer);
            }
        }

        ArrayList<String> sumScoreList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sumScoreMap.entrySet()) {
            String stu_id = entry.getKey();
            Integer sumScore = entry.getValue();
            sumScoreList.add(stu_id+"\t"+sumScore);
        }

        //倒序排序，取前10个学生
        //总分倒序排序
        Collections.sort(sumScoreList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int sumScore1 = Integer.parseInt(s1.split("\t")[1]);
                int sumScore2 = Integer.parseInt(s2.split("\t")[1]);
                return  sumScore2 - sumScore1;
            }
        });

        //获取总分排名前10 的学生
        String[] strings1 = new String[10];
        String[] strings2 = sumScoreList.toArray(strings1);
        String[] top10 = Arrays.copyOf(strings2, 10);


        /**
         * 关联学生信息表，取出前十学生的基本信息
         *
         */
        HashMap<String, Student> studentHashMap = new HashMap<>();
        for (Student student : students) {
            studentHashMap.put(student.getId(),student);
        }
        HashMap<String, String> top10StudentInfo = new HashMap<>();//前十学生的基本信息
        for (String s : top10) {
            String stu_id = s.split("\t")[0];
            Student student = studentHashMap.get(stu_id);
            String stuInfo = student.getId()+"\t"+student.getName()+"\t"+student.getClazz();
            top10StudentInfo.put(stu_id,stuInfo);
        }


        //将科目表转成map,方便通过科目id获取科目信息
        HashMap<String, Cource> courceHashMap = new HashMap<>();
        for (Cource cource : cources) {
            courceHashMap.put(cource.getId(),cource);
        }


        ArrayList<String> top10InfoList = new ArrayList<>();


        //遍历分数边，过滤前十10学生，关联科目表，得到结果
        for (Score score : scores) {
            Set<String> topStuId = top10StudentInfo.keySet();
            if (topStuId.contains(score.getStudent_id())){
                String stuInfo = top10StudentInfo.get(score.getStudent_id());
                Cource cource = courceHashMap.get(score.getCource_id());
                String topStuScoreInfo = stuInfo+"\t"+cource.getName()+"\t"+score.getScore();
                top10InfoList.add(topStuScoreInfo);
            }
        }

        //保存到文件
        FileWriter fileWriter = new FileWriter("java/data/top10StudentInfo.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (String s : top10InfoList) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
