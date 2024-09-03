package com.nuesoft.dao.impl;

import com.nuesoft.Util.DBUtil;
import com.nuesoft.dao.BusinessDao;
import com.nuesoft.po.Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商户数据访问实现层
 */
public class BusinessDaoImpl  implements BusinessDao{

    private Connection con = null;          //连接对象
    private PreparedStatement pst = null;   //执行sql语句对象
    private ResultSet rs = null;            //结果集处理对象

    /**
     * 根据商户名称和商户地址查询商户列表信息
     * @param businessName
     * @param businessAddress
     * @return
     */
    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1 ");
        if(businessName!=null&&!businessName.equals("")) {
            sql.append(" and businessName like '%"+businessName+"%' ");
        }
        if(businessAddress!=null&&!businessAddress.equals("")) {
            sql.append(" and businessAddress like '%"+businessAddress+"%' ");
        }
        try {
            con = DBUtil.getConnection();                   //获取连接
            pst = con.prepareStatement(sql.toString());     //创建pstmt对象
            rs = pst.executeQuery();                        //执行查询
            while(rs.next()) {  //封装数据
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }

    /**
     * 添加用户
     * @param businessName
     * @return
     */
    @Override
    public int saveBusiness(String businessName) {
        //1.获取连接
        //2.准备SQL
        //3.执行SQL
        //4.处理结果
        //5.释放资源
        return 0;
    }

    @Override
    public int deleteBusiness(int businessId) {
        int result = 0;
        String delFootSql = "delete from food where businessId = ?";
        String delBusinessSql = "delete from business where businessId = ?";
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false); //开启一个事务
            pst = con.prepareStatement(delFootSql);
            pst.setInt(1, businessId);
            pst.executeUpdate();
            pst = con.prepareStatement(delBusinessSql);
            pst.setInt(1, businessId);
            result = pst.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            result = 0;
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }

    @Override
    public Business login(Integer businessId, String password) {
        Business business = null;
        String sql = "select * from business where businessId=? and password=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, businessId);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return business;
    }

    /**
     * 根据id查询指定商户信息
     * @param businessId
     * @return
     */
    @Override
    public Business getBusinessById(Integer businessId) {
        Business business = null;
        String sql = "select * from business where businessId = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, businessId);
            rs = pst.executeQuery();
            while(rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return business;
    }

    /**
     * 添加用户
     * @param business
     * @return
     */
    @Override
    public int addBusiness(Business business) {
        int businessId = 0;
        String sql = "insert into business(password,businessName,businessAddress,businessExplain,starPrice,deliveryPrice) " +
                "values('123',?,?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS); //设置返回自增长列值
            pst.setString(1, business.getBusinessName());
            pst.setString(2, business.getBusinessAddress());
            pst.setString(3, business.getBusinessExplain());
            pst.setDouble(4, business.getStarPrice());
            pst.setDouble(5, business.getDeliveryPrice());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                businessId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return businessId;
    }

    @Override
    public int updateBusinessByPassword(Integer businessId, String password) {
        //1.获取连接
        //2.准备SQL
        //3.执行SQL
        //4.处理结果
        //5.释放资源
        return 0;
    }
}
