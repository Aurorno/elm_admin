package com.nuesoft.dao.impl;

import com.nuesoft.dao.BusinessDao;
import com.nuesoft.po.Business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * 商户数据访问层
 */
public class BusinessDaoImpl  implements BusinessDao{

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        return null;
    }

    @Override
    public int saveBusiness(String businessName) {
        return 0;
    }

    @Override
    public int removeBusiness(int businessId) {
        return 0;
    }

    @Override
    public Business getBusinessByIdByPass(Integer businessId, String password) {
        return null;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        return null;
    }

    @Override
    public int updateBusiness(Business business) {
        return 0;
    }

    @Override
    public int updateBusinessByPassword(Integer businessId, String password) {
        return 0;
    }
}
