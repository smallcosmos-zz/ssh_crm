package cn.itheima.service.Impl;

import cn.itheima.VO.PageBean;
import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao cd;

    public void setCd(CustomerDao cd) {
        this.cd = cd;
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //查询总记录数
        Integer totalCount = cd.getTotalCount(dc);
        //创建PageBean对象
        PageBean pb = new PageBean(currentPage,pageSize,totalCount);
        //查询数据集合
        List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
        //封装数据集合到pagebean
        pb.setList(list);
        //返回pagebean
        return pb;
    }

    @Override
    public List<Object[]> getIndustryTotal(String type){
        return cd.getIndustryTotal(type);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        cd.saveOrUpdate(customer);
    }

    @Override
    public Customer getById(Long cust_id) {
       return cd.getById(cust_id);
    }
}
