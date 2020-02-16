package cn.itheima.service.Impl;

import cn.itheima.VO.PageBean;
import cn.itheima.dao.LinkManDao;
import cn.itheima.domain.Customer;
import cn.itheima.domain.LinkMan;
import cn.itheima.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class LinkManServiceImpl implements LinkManService {

    private LinkManDao lmd;
    @Override
    public void save(LinkMan linkMan) {
        lmd.save(linkMan);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //查询总记录数
        Integer totalCount = lmd.getTotalCount(dc);
        //创建PageBean对象
        PageBean pb = new PageBean(currentPage,pageSize,totalCount);
        //查询数据集合
        List<LinkMan> list = lmd.getPageList(dc,pb.getStart(),pb.getPageSize());
        //封装数据集合到pagebean
        pb.setList(list);
        //返回pagebean
        return pb;
    }

    public void setLmd(LinkManDao lmd) {
        this.lmd = lmd;
    }
}
