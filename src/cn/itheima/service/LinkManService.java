package cn.itheima.service;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {
    void saveOrUpdate(LinkMan linkMan);
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    LinkMan getById(Long lkm_id);
}
