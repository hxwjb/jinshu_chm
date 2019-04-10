package com.jinshu.com.chm.load;

import com.jinshu.com.chm.MainAPP;
import com.jinshu.com.chm.object.iteminfo;

import java.util.ArrayList;

public class loadScript {

    static public boolean loadFile()
    {

        loaditemfile("aaa");

        return true;
    }


    static private boolean loaditemfile(String path)
    {
        ArrayList<iteminfo> iteminfos = MainAPP.getInstance().getIteminfos();



        return true;
    }

    static private boolean loadperson(String path)
    {
        MainAPP instence = MainAPP.getInstance();
        return  true;
    }

    static private  boolean loadevent(String path)
    {
        MainAPP instence = MainAPP.getInstance();
        return true;
    }
}
