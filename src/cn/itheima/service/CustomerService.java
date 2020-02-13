package cn.itheima.service;

import cn.itheima.VO.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
