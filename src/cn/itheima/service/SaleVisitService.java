package cn.itheima.service;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
    //保存客户拜访记录
    void saveSaleVisit(SaleVisit saleVisit);
    //分页查询客户拜访记录
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    SaleVisit getById(String visit_id);
}
