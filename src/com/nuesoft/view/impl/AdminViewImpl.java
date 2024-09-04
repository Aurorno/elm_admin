package com.nuesoft.view.impl;

import com.nuesoft.dao.AdminDao;
import com.nuesoft.dao.impl.AdminDaoImpl;
import com.nuesoft.po.Admin;
import com.nuesoft.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {

    private Scanner input = new Scanner(System.in);
    @Override
    public Admin login() {
        System.out.println("请输入管理员名称：");
        String adminName = input.next();
        System.out.println("请输入密码：");
        String password = input.next();

        AdminDao dao = new AdminDaoImpl();
        return dao.getAdminByNameByPass(adminName, password);
    }
}
