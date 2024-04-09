package com.catJump.tools;

import com.catJump.beng.h.Jxh;

public class PublicTools {
    //todo 实现转换器 将【/cast 【xxx】 a】转换成 java判断逻辑; 只想到用动态编译创建宏执行类
    public static void translator(String context) {
        try {
            String[] castList = context.split("\\r\\n");//分割单个判断
            for (int i = 0; i < castList.length; i++) {
                String[] cast = castList[i].split(" ");
                if(!cast[0].startsWith("/cast")){
                    throw new Exception("请以/cast开头设计任务");
                }
                if(!cast[1].startsWith("[") || !cast[1].endsWith("]")){
                    throw new Exception("判断条件请以[]包裹");
                }
            }

        } catch (Exception e) {

        }
    }

    /**
     * 处理判断条件
     * 1.【()】括号不做处理
     * 2.【与或】需要转换为java格式
     * 3.【!】不做处理
     * 4.条件对象处理
     * @param condition
     */
    public static void dealCondition(String condition){

    }

}