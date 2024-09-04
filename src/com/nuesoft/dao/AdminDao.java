package com.nuesoft.dao;

import com.nuesoft.po.Admin;

public interface AdminDao {

    public Admin getAdminByNameByPass(String adminName, String password);
}
