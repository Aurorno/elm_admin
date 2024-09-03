package com.nuesoft.dao;

import com.nuesoft.po.Business;

import java.util.List;

public interface BusinessDao {
    /**
     * 获取全部商户
     * @param businessName
     * @param businessAddress
     * @return
     */
    public List<Business> listBusiness(String businessName,String businessAddress);

    /**
     *修改商户信息
     * @param businessName
     * @return
     */
    public int saveBusiness(String businessName);

    /**
     * 根据id删除商户
     * @param businessId
     * @return
     */
    public int removeBusiness(int businessId);

    /**
     * 获取商户密码
     * @param businessId
     * @param password
     * @return
     */
    public Business getBusinessByIdByPass(Integer businessId,String password);

    /**
     * 根据id获取商户信息
     * @param businessId
     * @return
     */
    public Business getBusinessById(Integer businessId);

    /**
     * 添加商户
     * @param business
     * @return
     */
    public int updateBusiness(Business business);

    /**
     * 修改密码
     * @param businessId
     * @param password
     * @return
     */
    public int updateBusinessByPassword(Integer businessId,String password);

}
