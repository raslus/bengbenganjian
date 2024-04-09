package com.catJump.beng;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class jx3HList {
    private jx3HList(){}
    private static class jx3HListInstance{
        private static final  jx3HList Instance = new jx3HList();
    }
    public static jx3HList getInstance(){
        return jx3HListInstance.Instance;
    }


    private List<JsonObject> hList = new ArrayList<>();

    public List<JsonObject> getHList() {
        return hList;
    }


    public void initHlist(){
        //todo 从本机文件夹读取列表
        //example
        JsonObject ex1 = new JsonObject();
        ex1.addProperty("a","asdfa");
        this.hList.add(ex1);
        System.out.println(hList);
    }
}