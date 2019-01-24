package com.shujia.student;

import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args) throws Exception {

        ArrayList<Score> read = ReadUtil.read("java/data/score.txt", Score.class);

        for (Score score : read) {
            System.out.println(score);
        }


    }
}
