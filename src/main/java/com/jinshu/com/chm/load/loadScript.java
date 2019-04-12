package com.jinshu.com.chm.load;

import com.jinshu.com.chm.MainAPP;
import com.jinshu.com.chm.object.iteminfo;
import org.apache.log4j.Logger;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.*;
import java.util.ArrayList;

public class loadScript {
    private static Logger logger = Logger.getLogger(loadScript.class.getClass());
    static private String scriptPath;

    static public boolean loadFile() {
        scriptPath = GlobleConfig.scriptPath;

        loaditemfile();

        return true;
    }



    /**
     * @Description: 加载物品lua
     * @Param:
     * @return: boolean
     * @Author: Huawenbin
     * @Date: 2019/4/12
     */
    static private boolean loaditemfile() {
        ArrayList<iteminfo> iteminfos = MainAPP.getInstance().getIteminfos();
        String itemPath = scriptPath + "\\ItemInfo.lua";
        itemPath = scriptPath + "\\jyconst.lua";
        //logger.info("load item file:"+itemPath);


        Globals globals = JsePlatform.standardGlobals();

        try {
            LuaValue luachuck = globals.load(new InputStreamReader(new FileInputStream(new File(itemPath))), "chunkname").call();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //在Globals获取全局函数hi,并传递参数调用
        LuaValue func = globals.get(LuaValue.valueOf("SetGlobalConst"));
        //在luaj中LuaValue映射了lua中的基本数据类型,包括函数
        func.call();

        LuaValue hTable = globals.get(LuaValue.valueOf("VK_ESCAPE"));
        System.out.println("hTable:" + hTable.tostring());
//        //迭代table结构
//        LuaValue k = LuaValue.NIL;
//        while ( true ) {
//            Varargs n = hTable.next(k);
//            if ( (k = n.arg1()).isnil() ) {
//                break;
//            }
//            LuaValue v = n.arg(1);
//            System.out.println("v:"+v.tostring());
//            LuaValue m = n.arg(2);
//            //把lua 结构转换成java结构
//            LuaTable tb = (LuaTable)CoerceLuaToJava.coerce(m, LuaTable.class);
//            System.out.println("m:"+tb.typename());
//            LuaValue j = LuaValue.NIL;
//            while ( true ) {
//                Varargs n1 = tb.next(j);
//                if ( (j = n1.arg1()).isnil() ) {
//                    break;
//                }
//                LuaValue v1 = n1.arg(1);
//                System.out.println("v1:"+v1.tostring());
//                LuaValue m1 = n1.arg(2);
//
//                System.out.println("m1:"+m1.tostring());
//
//            }
//        }

        return true;
    }

    static private boolean loadperson() {
        MainAPP instence = MainAPP.getInstance();

        String personPath = scriptPath + "kdef.lua";

        logger.info("load item file:" + personPath);

        return true;
    }

    static private boolean loadevent() {
        MainAPP instence = MainAPP.getInstance();

        String eventPath = scriptPath + "MyOEvent.lua";

        logger.info("load item file:" + eventPath);

        return true;
    }
}
