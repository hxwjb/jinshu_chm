package com.jinshu.com.chm;


import com.jinshu.com.chm.event.event;
import com.jinshu.com.chm.load.loadScript;
import com.jinshu.com.chm.object.iteminfo;
import com.jinshu.com.chm.object.person;

import java.util.ArrayList;

public class MainAPP {

    private ArrayList<iteminfo> iteminfos;
    private ArrayList<person> persons;
    private ArrayList<event> events;

    private static MainAPP instance = new MainAPP();

    public static MainAPP getInstance()
    {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        person test1 = new person();
        iteminfo item1 = new iteminfo();
        item1.setName("测试人物");

        System.out.println(item1.getName());
        loadScript.loadFile();



    }


    public ArrayList<iteminfo> getIteminfos() {
        return iteminfos;
    }

    public void setIteminfos(ArrayList<iteminfo> iteminfos) {
        this.iteminfos = iteminfos;
    }

    public ArrayList<person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<person> persons) {
        this.persons = persons;
    }

    public ArrayList<event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<event> events) {
        this.events = events;
    }
}
