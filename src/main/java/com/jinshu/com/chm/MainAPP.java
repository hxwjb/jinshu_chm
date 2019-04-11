package com.jinshu.com.chm;


import com.jinshu.com.chm.event.event;
import com.jinshu.com.chm.load.loadScript;
import com.jinshu.com.chm.object.iteminfo;
import com.jinshu.com.chm.object.person;

import org.apache.log4j.Logger;
import  org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;

public class MainAPP {


    private static Logger logger = Logger.getLogger(MainAPP.class.getClass());


    private ArrayList<iteminfo> iteminfos;
    private ArrayList<person> persons;
    private ArrayList<event> events;

    private static MainAPP instance = new MainAPP();

    public static MainAPP getInstance()
    {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径

        PropertyConfigurator.configure("conf/log4j.properties");


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
