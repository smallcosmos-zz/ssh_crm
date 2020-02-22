package cn.itheima.service;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void saveOrUpdate(Customer customer);

    Customer getById(Long cust_id);

    List<Object[]> getIndustryTotal(String type);
}
