package com.tzg.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DruidDataSource dataSource;

    static {
        try{
            Properties prop = new Properties();
            //读取配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn =  dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        if (conn !=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}
