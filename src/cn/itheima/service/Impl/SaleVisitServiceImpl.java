package cn.itheima.service.Impl;

import cn.itheima.VO.PageBean;
import cn.itheima.dao.SaleVisitDao;
import cn.itheima.domain.Customer;
import cn.itheima.domain.SaleVisit;
import cn.itheima.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class SaleVisitServiceImpl implements SaleVisitService {
    private SaleVisitDao svd;
    @Override
    public void saveSaleVisit(SaleVisit saleVisit) {
        svd.saveOrUpdate(saleVisit);
    }

    public void setSvd(SaleVisitDao svd) {
        this.svd = svd;
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //查询总记录数
        Integer totalCount = svd.getTotalCount(dc);
        //创建PageBean对象
        PageBean pb = new PageBean(currentPage,pageSize,totalCount);
        //查询数据集合
        List<SaleVisit> list = svd.getPageList(dc,pb.getStart(),pb.getPageSize());
        //封装数据集合到pagebean
        pb.setList(list);
        //返回pagebean
        return pb;
    }

    @Override
    public SaleVisit getById(String visit_id) {
        return svd.getById(visit_id);
    }
}
