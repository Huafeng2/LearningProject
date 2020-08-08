package com.mingrisoft.dbservice;            //指定类所在的包

import java.sql.*;                        //导入数据库操作的类
import java.util.*;
import java.io.*;

public class DBConnection {

    private String FileName;            //配置文件名
    private int DBType;                    //数据库类型
    private Connection conn;            //连接对象
    private String MySqlDriver;            //MYSQL Server驱动程序
    private String MySqlURL;            //MYSQL Server连接字符串
    private String username;            //MYSQL Server连接字符串
    private String password;            //MYSQL Server连接字符串


    public DBConnection() {
        conn = null;
    }

    public Connection getConn() {

        DBType = new Function().StrToInt(getPara("DBType"));

        switch (DBType) {
            case 1:
                return (getConnToMySql());
            default:
                return null;
        }
    }


    public String getPara(String ParaName) {
        FileName = "/DBConfig.properties";
        Properties prop = new Properties();
        try {
            InputStream is = getClass().getResourceAsStream(FileName);
            prop.load(is);
            if (is != null) is.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return prop.getProperty(ParaName);
    }


    public Connection getConnToMySql() {
        try {
            MySqlURL = getPara("MySQLURL");
            MySqlDriver = getPara("MySQLDriver");
            username = getPara("Username");
            password = getPara("Password");
            Class.forName(MySqlDriver);
            conn = DriverManager.getConnection(MySqlURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return conn;
    }

}
