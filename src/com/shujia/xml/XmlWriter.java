package com.shujia.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class XmlWriter {

    /**
     * 生产xml文件
     * 1、构建一个空得分Doc对象
     *
     * @param args
     */

    public static void main(String[] args) throws IOException {

        //创建一个空的文档对象
        Document document = DocumentHelper.createDocument();

        //增加根节点，返回根节点对象
        Element books = document.addElement("books");

        //增加子节点
        Element book = books.addElement("book");
        //增加属性
        book.addAttribute("id", "001");
        Element name = book.addElement("name");
        name.setText("平凡的世界");

        Element author = book.addElement("author");
        author.setText("路遥");


        //保存到文件

        /**OutputFormat，输出格式        createPrettyPrint(),创建完美打印输出格式   */
        OutputFormat format = OutputFormat.createPrettyPrint();
        //创建文件输出流
        FileOutputStream fileout = new FileOutputStream("E:\\第三期\\bigdata\\java\\src\\com\\shujia\\xml\\books.xml");
        //包装厂字符流
        OutputStreamWriter writer= new OutputStreamWriter(fileout,"utf-8");

        //XMLWriter xmlwrite=new XMLWriter(new FileWriter("newbooks.xml"));
        XMLWriter xmlwrite=new XMLWriter(writer, format);

        xmlwrite.write(document);//将文档使用write方法写进文件
        xmlwrite.close();//关闭


    }
}
