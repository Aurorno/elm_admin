package com.nuesoft.Util;

import java.sql.*;

/**
 * 数据库连接工具类
 */
public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/elm_admin?characterEncoding=utf-8";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    //获取Connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭资源
    public static void close(ResultSet rs, PreparedStatement pst, Connection con) {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(pst!=null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pst = null;
        }
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = null;
        }
    }

}
