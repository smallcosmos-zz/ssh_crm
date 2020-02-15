package cn.itheima.service;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void save(Customer customer);
}
