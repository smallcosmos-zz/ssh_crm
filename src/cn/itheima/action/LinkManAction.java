package cn.itheima.action;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.Customer;
import cn.itheima.domain.LinkMan;
import cn.itheima.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan  = new LinkMan();
    private LinkManService lms;
    private Integer currentPage;
    private Integer pageSize;

    public String add() throws Exception {
        //调用service完成联系人添加
        lms.save(linkMan);
        //转发到list页面
        return "toList";
    }
    public String list() throws Exception {
        //创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
            if(StringUtils.isNotBlank(linkMan.getLkm_name())){
            dc.add(Restrictions.like("lkm_name","%"+linkMan.getLkm_name()+"%"));
        }
        //调用service方法获得分页对象
        PageBean pb = lms.getPageBean(dc,currentPage,pageSize);
        //将PageBean返给request域
        ActionContext.getContext().put("pageBean",pb);
        //转发到list页面
        return "list";
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    public void setLms(LinkManService lms) {
        this.lms = lms;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
