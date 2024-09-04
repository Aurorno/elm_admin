package com.nuesoft.view.impl;

import com.nuesoft.dao.BusinessDao;
import com.nuesoft.dao.impl.BusinessDaoImpl;
import com.nuesoft.po.Business;
import com.nuesoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {

    //注入数据访问层对象
    BusinessDao businessDao = new BusinessDaoImpl();
    //键盘接收对象
    private Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() {
        List<Business> businessList = businessDao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for(Business b : businessList) {
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"
                    +b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"
                    +b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }

    @Override
    public void listBusiness() {
        String businessName = "";
        String businessAddress = "";

        String inputStr = "";
        System.out.println("是否需要输入商家名称关键词(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入商家名称关键词：");
            businessName = input.next();
        }

        System.out.println("是否需要输入商家地址关键词(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入商家地址关键词：");
            businessAddress = input.next();
        }

        List<Business> list = businessDao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for(Business b : list) {
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }

    @Override
    public void addBusiness() {
        System.out.println("请输入商家名称：");
        String businessName = input.next();
        System.out.println("请输入商家地址：");
        String businessAddress = input.next();
        System.out.println("请输入商品简介：");
        String businessExplain = input.next();
        Business business = new Business(null,"123",businessName,businessAddress,businessExplain,00.00,0.00);
        int businessId = businessDao.addBusiness(business);
        if(businessId > 0) {
            System.out.println("新建商家成功！商家编号为："+businessId);
        }else {
            System.out.println("新建商家失败！");
        }
    }

    @Override
    public void updateBusiness(int businessId) {
        //先将商家信息查询出来显示，然后用户才能更新
        Business business = businessDao.getBusinessById(businessId);
        System.out.println(business);

        String inputStr = "";
        System.out.println("是否修改商家名称(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的商家名称：");
            business.setBusinessName(input.next());
        }

        System.out.println("是否修改商家地址(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的商家地址：");
            business.setBusinessAddress(input.next());
        }

        System.out.println("是否修改商家介绍(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的商家介绍：");
            business.setBusinessExplain(input.next());
        }

        System.out.println("是否修改起送费(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的起送费：");
            business.setStarPrice(input.nextDouble());
        }

        System.out.println("是否修改配送费(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的配送费：");
            business.setDeliveryPrice(input.nextDouble());
        }

        int result = businessDao.updateBusiness(business);
        if(result>0) {
            System.out.println("\n修改商家信息成功！\n");
        }else {
            System.out.println("\n修改商家信息失败！\n");
        }
    }

    @Override
    public void deleteBusiness() {
        System.out.println("请输入商家编号：");
        int businessId = input.nextInt();

        System.out.println("确认要删除吗(y/n)：");
        if(input.next().equals("y")) {
            int result = businessDao.deleteBusiness(businessId);
            if(result==1) {
                System.out.println("删除商家成功！");
            }else {
                System.out.println("删除商家失败！");
            }
        }
    }

    @Override
    public void showBusiness(int businessId) {
        Business business = businessDao.getBusinessById(businessId);
        System.out.println(business);
    }

    @Override
    public Business login() {
        System.out.println("请输入商家编号：");
        int businessId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();
        return businessDao.login(businessId, password);
    }

    @Override
    public void updatePassword(int businessId) {
        Business business = businessDao.getBusinessById(businessId);

        System.out.println("\n请输入旧密码：");
        String oldPass = input.next();
        System.out.println("\n请输入新密码：");
        String password = input.next();
        System.out.println("\n请再次输入新密码：");
        String beginPassword = input.next();

        if(!business.getPassword().equals(oldPass)) {
            System.out.println("\n旧密码输入错误！");
        }else if(!password.equals(beginPassword)) {
            System.out.println("\n两次输入密码不一致！");
        }else {
            int result = businessDao.updatePassword(businessId, password);
            if(result>0) {
                System.out.println("\n修改密码成功！");
            }else {
                System.out.println("\n修改密码失败！");
            }
        }
    }
}
