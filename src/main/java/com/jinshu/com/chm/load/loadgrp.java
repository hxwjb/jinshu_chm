package com.jinshu.com.chm.load;

import com.jinshu.com.chm.object.person;
import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;

public class loadgrp {

    private static Logger logger = Logger.getLogger(loadgrp.class.getClass());


    /**
     * @Description: 组装临时lua文件
     * @Param:
     * @return:
     * @Author: Huawenbin
     * @Date: 2019/4/12
     */
    static private boolean connectfile()
    {
        String tepfilename = "tmp.lua";
        String itemPath = GlobleConfig.dataPath + "\\config.lua";
        File file = new File(itemPath);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return true;
    }

    static  public boolean loadpersongrp()
    {
        String filePath = GlobleConfig.scriptPath+"\\jyconst.lua";
        String encoding = "GBK";
        File file = new File(filePath);
        if (file.isFile() && file.exists())
        { // 判断文件是否存在
            InputStreamReader read = null;// 考虑到编码格式
            try {
                read = new InputStreamReader(
                        new FileInputStream(file), encoding);

                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;


                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    if (lineTxt.contains("Person_S"))
                    {
                       logger.info(lineTxt);
                    }

                }
                bufferedReader.close();
                read.close();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            logger.error("找不到指定的文件:"+filePath);
            return false;
        }


        // 设置类成员属性
        HashMap propertyMap;
        propertyMap = new HashMap();

        try {
            propertyMap.put("id", Class.forName("java.lang.Integer"));
            propertyMap.put("name", Class.forName("java.lang.String"));
            propertyMap.put("address", Class.forName("java.lang.String"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        // 生成动态 Bean
        person bean = new person(propertyMap);

        // 给 Bean 设置值
        bean.setValue("id", new Integer(123));

        bean.setValue("name", "454");

        bean.setValue("address", "789");

        // 从 Bean 中获取值，当然了获得值的类型是 Object

        System.out.println("  >> id      = " + bean.getValue("id"));

        System.out.println("  >> name    = " + bean.getValue("name"));

        System.out.println("  >> address = " + bean.getValue("address"));

        // 获得bean的实体
        Object object = bean.getObject();

        // 通过反射查看所有方法名
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());

            if (methods[i].getName().equalsIgnoreCase("setId"))
            {

            }
        }

        return true;
    }
}
