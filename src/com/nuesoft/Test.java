package com.nuesoft;

import com.nuesoft.Util.DBUtil;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection con = DBUtil.getConnection();
        if(con!=null){
            System.out.println("连接成功");
        }else{
            System.out.println("连接失败");
        }
    }
}
