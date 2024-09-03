package com.nuesoft.dao;

import com.nuesoft.po.Business;

import java.util.List;

/**
 * 商户数据访问接口层
 */
public interface BusinessDao {

    /**
     * 获取全部商户
     * @param businessName
     * @param businessAddress
     * @return
     */
    public List<Business> listBusiness(String businessName,String businessAddress);

    /**
     * 添加商户信息
     * @param businessName
     * @return
     */
    public int saveBusiness(String businessName);

    /**
     * 根据id删除商户
     * @param businessId
     * @return
     */
    public int deleteBusiness(int businessId);

    /**
     * 商户登录
     * @param businessId
     * @param password
     * @return
     */
    public Business login(Integer businessId,String password);

    /**
     * 根据id获取商户信息
     * @param businessId
     * @return
     */
    public Business getBusinessById(Integer businessId);

    /**
     * 修改商户
     * @param business
     * @return
     */
    public int addBusiness(Business business);

    /**
     * 修改密码
     * @param businessId
     * @param password
     * @return
     */
    public int updateBusinessByPassword(Integer businessId,String password);

}
