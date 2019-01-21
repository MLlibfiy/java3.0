package com.shujia.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

public class XmlReader {
    public static void main(String[] args) throws Exception {

        String path = "E:\\第三期\\bigdata\\java\\src\\com\\shujia\\xml\\scores.xml";

        File file = new File(path);

        SAXReader reader = new SAXReader();

        //构建文档对象
        Document read = reader.read(file);

        //回去取根节点
        Element rootElement = read.getRootElement();

        //获取节点文本内容
        String text = rootElement.getText();

        //获取子节点
        Iterator iterator = rootElement.elementIterator();

        while (iterator.hasNext()) {
            Element next = (Element)iterator.next();

            //获取节点属性
            Iterator iterator1 = next.attributeIterator();
            while (iterator1.hasNext()){
                Attribute next1 = (Attribute)iterator1.next();
                System.out.println(next1.getName()+"\t"+next1.getValue());
            }

            //获取子节点
            Iterator iterator2 = next.elementIterator();
            while (iterator2.hasNext()){
                Element next1 = (Element)iterator2.next();
                //获取节点名称
                String name = next1.getName();
                //获取节点文本内容
                String value = next1.getText();

                System.out.println(name+"\t"+value);


            }


            System.out.println("==============================");

        }


    }
}
