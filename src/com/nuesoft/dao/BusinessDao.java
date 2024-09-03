package com.nuesoft.dao;

import com.nuesoft.po.Business;

import java.util.List;

/**
 * 商户数据访问接口层
 */
public interface BusinessDao {

    // 获取全部商户
    List<Business> listBusiness(String businessName,String businessAddress);

    //商户登录
    Business login(Integer businessId,String password);

    //根据id获取商户信息
    Business getBusinessById(Integer businessId);

    //添加商户
    int addBusiness(Business business);

    //修改密码
    int updatePassword(int businessId, String password);

    //修改商户信息
    int updateBusiness(Business business);

    //根据id删除商户
    int deleteBusiness(int businessId);

}
