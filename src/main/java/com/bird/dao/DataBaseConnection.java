package com.bird.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    static String url = "jdbc:mysql://localhost:3305/bird_record?&useSSL=false&serverTimezone=UTC";//定义数据连接字符串
    static String username = "root";//定义数据库连接用户名
    static String password = "123456";//定义数据库连接用密码
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载MySql8数据库驱动程序
        } catch (ClassNotFoundException e) {
            e.printStackTrace();                                                                                                
        }
    }

    public static Connection getConnection() {// 建立数据库连接
        Connection conn = null;                 
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
