package com.catJump.beng.h;

import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;
import java.util.*;

public class Jxh implements Serializable {
    private List<Key> keys;
    private List<Object> images;
    private String name;
    private String expressName;
    private  String context;

    private Jxh(HBuilder builder){
        this.keys = builder.keys;
        this.images = builder.images;
        this.name = builder.name;
        this.expressName = builder.expressName;
        this.context = builder.context;
    }

    public static class Key implements Serializable{
        private String name ; //key-name
        private String value;

        public Key(String name,String value){
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class HBuilder{
        private List<Key> keys; //
        private List<Object> images = new ArrayList<>();
        private String name;
        private String expressName;
        private  String context;

        public HBuilder name(String name){
            this.name = name;
            return this;
        }
        public HBuilder expressName(String name2){
            this.expressName = name2;
            return this;
        }
        public HBuilder context(String context){
            this.context = context;
            return this;
        }
        public HBuilder addKey(Key key){
            if(ObjectUtil.isEmpty(this.keys)){
                this.keys = new ArrayList<>();
                this.keys.add(key);
            }else{
                this.keys.add(key);
            }
            return this;
        }
        public HBuilder addImg(String key){
            if(this.images.isEmpty()){
                this.images = new ArrayList<>();
            }else{
                this.images.add(key);
            }
            return this;
        }
        public Jxh build(){
            return new Jxh(this);
        }

    }

    public String getName() {
        return name;
    }
    public String getExpressName(){
        return expressName;
    }
    public String getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "{" +
                "keys=" + keys +
                ", images=" + images +
                ", name='" + name + '\'' +
                ", expressName='" + expressName + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
