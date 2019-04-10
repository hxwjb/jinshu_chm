package com.jinshu.com.chm.load;

import java.io.IOException;
import java.util.Properties;

public class GlobleConfig {


        // 配置文件定义的数据
        public static int SOCKET_PORT;// 远程服务端端口
        public static String BOOTSTRAP_SERVERS;// kafka服务器IP
        public static String TOPIC_NAME;// kafka主题名称

        static {
            Properties props = new Properties();
            try {
                props.load(ClassLoader.getSystemResourceAsStream("prop.properties"));
                SOCKET_PORT = Integer.parseInt(props.getProperty("socket_port"));
                BOOTSTRAP_SERVERS = props.getProperty("bootstrap_servers");
                TOPIC_NAME = props.getProperty("topic_name");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
