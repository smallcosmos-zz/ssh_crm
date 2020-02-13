package cn.itheima.action;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    private Integer currentPage;
    private Integer pageSize;
    private CustomerService cs;

    public void setCs(CustomerService cs) {
        this.cs = cs;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String list() throws Exception {
        //创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if(StringUtils.isNotBlank(customer.getCust_name())){
            dc.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }
        //调用service方法获得分页对象
        PageBean pb = cs.getPageBean(dc,currentPage,pageSize);
        //将PageBean返给request域
        ActionContext.getContext().put("pageBean",pb);
        //转发到list页面
        return "list";
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
