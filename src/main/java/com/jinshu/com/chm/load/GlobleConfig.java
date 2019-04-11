package com.jinshu.com.chm.load;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobleConfig {

    private static Logger logger = Logger.getLogger(GlobleConfig.class.getClass());
        // 配置文件定义的数据
        public static String scriptPath;// 远程服务端端口


        static {
            Properties props = new Properties();
            try {
                InputStream ioin = new FileInputStream("./conf/prop.properties");

                props.load(ioin);
                scriptPath = props.getProperty("scriptPath");
                logger.info(scriptPath);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
