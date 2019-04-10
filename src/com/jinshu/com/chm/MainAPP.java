package com.jinshu.com.chm;


import com.jinshu.com.chm.object.item;
import com.jinshu.com.chm.object.person;

public class MainAPP {


    public static void main(String[] args) {
        System.out.println("Hello World!");
        person test1 = new person();
        item item1 = new item();
        item1.setName("测试人物");

        System.out.println(item1.getName());
    }





}
