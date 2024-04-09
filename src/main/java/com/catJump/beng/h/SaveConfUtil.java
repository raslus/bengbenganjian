package com.catJump.beng.h;


import java.io.*;

public class SaveConfUtil {
    // 实现将配置保存到本机
    public static void saveFile(Jxh jxh){
        // 获取当前项目的根目录
        String path = jxh.getName();;
        File rootDir = new File("./"+path);
        if(!rootDir.exists()){
            rootDir.mkdirs();
        }
        // 定义新的文件路径和名称
        File newFile = new File(rootDir, jxh.getName()+".txt");

        // 使用try-with-resources语句来自动关闭BufferedWriter
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            // 写入文本内容
            writer.write(jxh.toString());
            System.out.println("文本内容已成功保存到 " + newFile.getAbsolutePath());
            writer.close();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+"/"+jxh.getName()+".ser"));
            oos.writeObject(jxh);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("无法写入文件。");
        }finally {

        }
    }

//    public static void main(String[] args) {
//        Jxh jxh = new Jxh.HBuilder().addKey(new Jxh.Key("key","value")).name("aa").expressName("aa").build();
//        saveFile(jxh);
//    }

}
