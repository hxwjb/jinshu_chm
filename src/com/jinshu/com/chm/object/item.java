package com.jinshu.com.chm.object;

import java.util.ArrayList;

public class item {

    private String name;
    private int type;
    private ArrayList<String> explain;
    private ArrayList<String> explainText;
    private ArrayList<String>  active;
    private ArrayList<String>  acticeText;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<String> getExplain() {
        return explain;
    }

    public void setExplain(ArrayList<String> explain) {
        this.explain = explain;
    }

    public ArrayList<String> getExplainText() {
        return explainText;
    }

    public void setExplainText(ArrayList<String> explainText) {
        this.explainText = explainText;
    }

    public ArrayList<String> getActive() {
        return active;
    }

    public void setActive(ArrayList<String> active) {
        this.active = active;
    }

    public ArrayList<String> getActiceText() {
        return acticeText;
    }

    public void setActiceText(ArrayList<String> acticeText) {
        this.acticeText = acticeText;
    }
}
