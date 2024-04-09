package com.catJump.beng.h;

import java.io.*;

public class ReadConfUtil {
    // 实现从文件夹读取配置信息的功能
    public static void readFile(String string){
        try {
            String path = string+".txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println("读取文件失败，请检查路径|"+e);
        }
    }

    /**
     * java 反序列化 获取对象
     * @param name
     */
    public static void readObjectFromDisk(String name){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("./"+name+"/"+name+".ser")
            );
            Jxh jxh = (Jxh) objectInputStream.readObject();
            System.out.println(jxh);
        }catch (Exception e){
            System.out.println("读取对象失败,请检查路径|"+e);
        }
    }

//    public static void main(String[] args) {
////        readFile("test");
//        readObjectFromDisk("aa");
//    }
}
