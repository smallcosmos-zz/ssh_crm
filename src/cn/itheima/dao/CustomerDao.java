package cn.itheima.dao;

import cn.itheima.domain.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer>{
    List<Object[]> getIndustryTotal(String type);
}
