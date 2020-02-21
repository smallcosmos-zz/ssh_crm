package cn.itheima.web.action;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.Customer;
import cn.itheima.domain.SaleVisit;
import cn.itheima.domain.User;
import cn.itheima.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
    private SaleVisit saleVisit = new SaleVisit();
    private SaleVisitService svs;
    private Integer currentPage;
    private Integer pageSize;

    public String add() throws Exception {
//        //获取当前用户id
//        User user = (User) ActionContext.getContext().getSession().get("loginUser");
//        saleVisit.setUser(user);
        //调用service执行保存拜访记录
        if (saleVisit.getVisit_id().equals("")) {
           saleVisit.setVisit_id(null);
        }

        svs.saveSaleVisit(saleVisit);
        //重定向到list页面
        return "toList";
    }

    public String list() throws Exception {
        //创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
        if (saleVisit.getUser() != null && saleVisit.getUser().getUser_id() != null) {
            dc.add(Restrictions.eq("user.user_id", saleVisit.getUser().getUser_id()));
        }
        if (saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
            dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
        }
        //调用service方法获得分页对象
        PageBean pb = svs.getPageBean(dc, currentPage, pageSize);
        //将PageBean返给request域
        ActionContext.getContext().put("pageBean", pb);
        //转发到list页面
        return "list";
    }

    public String toEdit() throws Exception {
        SaleVisit sv = svs.getById(saleVisit.getVisit_id());
        ActionContext.getContext().put("saleVisit", sv);
        return "edit";
    }

    @Override
    public SaleVisit getModel() {
        return saleVisit;
    }

    public void setSvs(SaleVisitService svs) {

        this.svs = svs;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
