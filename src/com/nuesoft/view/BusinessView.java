package com.nuesoft.view;

import com.nuesoft.po.Business;

public interface BusinessView {

    //全部商户列表信息
    void listBusinessAll();

    //条件商户列表信息
    void listBusiness();

    //添加商户信息
    void addBusiness();

    //修改商户信息
    void updateBusiness(int businessId);

    //删除商户信息
    void deleteBusiness();

    //根据商户id查询商户信息
    void showBusiness(int businessId);

    //商户登录
    Business login();

    //更新商户密码
    void updatePassword(int businessId);
}
