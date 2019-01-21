package com.shujia.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader2 {

    public static void main(String[] args) throws IOException {


        FileReader fileReader = new FileReader("E:\\第三期\\bigdata\\java\\src\\com\\shujia\\json\\scores.json");
        char[] chars = new char[1024];
        //length  读到的字符数量
        int length = fileReader.read(chars);

        String json = new String(chars, 0, length);

        System.out.println(json);
        //创建Gson解析对象
        Gson gson = new Gson();

        //将json字符串解析成自定义对象
        //注意：json字符串里面的属性名称要和自定义类的属性名称一一对应
        ArrayList<Score> scores = gson.fromJson(json, new TypeToken<List<Score>>(){}.getType());

        for (Score score : scores) {
            System.out.println(score);
        }


        String toJson = gson.toJson(scores);

        System.out.println(toJson);


    }
}
