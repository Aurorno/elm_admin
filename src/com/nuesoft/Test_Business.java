package com.nuesoft;

import com.nuesoft.dao.BusinessDao;
import com.nuesoft.dao.impl.BusinessDaoImpl;
import com.nuesoft.po.Business;

public class Test_Business {

    public static void main(String[] args) {

        BusinessDao businessDao = new BusinessDaoImpl();

        //测试查询商户列表信息
        /*BusinessDao businessDao = new BusinessDaoImpl();
        List<Business> businessList = businessDao.listBusiness("米", "沈阳");
        for (Business b:businessList){
            System.out.println(b);
        }*/

        //测试根据id查询指定商户信息
        /*Business business = businessDao.getBusinessById(10001);
        System.out.println(business);*/

        //测试商户登录
        /*Business business = businessDao.login(10001, "123");
        if (business==null){
            System.out.println("登录失败,用户名或密码错误!");
        }else {
            System.out.println("登录成功!");
        }*/

        //测试添加商户信息
        /*Business business = new Business(10008,null,"云边小卖部","西安市高新区","云烟",14.00,0.00);
        int busId = businessDao.addBusiness(business);
        System.out.println(busId);*/

        //测试删除商户信息
        int rows = businessDao.deleteBusiness(10008);
        if (rows!=1){
            System.out.println("删除失败!");
        }else {
            System.out.println("删除成功!");
        }
    }
}
