package cn.itheima.web.action;

import cn.itheima.VO.PageBean;
import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    private Integer currentPage;
    private Integer pageSize;
    private CustomerService cs;
    private File photo;
    private String photoFileName;
    private String photoContentType;
    //区分是查询客户行业还是客户来源
    private String type;


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
    public String toEdit() throws Exception {
        //调用service根据id等查询customer对象
        Customer c = cs.getById(customer.getCust_id());
        //将查出来的对象放入request域
        System.out.println(c);
        ActionContext.getContext().put("customer",c);

        //将页面转发到编辑页面
        return "edit";
    }

    public String add() throws Exception {
        if(photo != null){
            System.out.printf("文件名称："+photoFileName);
            System.out.printf("文件类型："+photoContentType);
            photo.renameTo(new File("E:/upload/"+photoFileName));
        }

        cs.saveOrUpdate(customer);
        return "toList";
    }

    public String getIndustryTotal() throws Exception {
        List<Object[]> list = cs.getIndustryTotal(type);
        ActionContext.getContext().put("list",list);
        return "industryTotal";
    }

    @Override
    public Customer getModel() {
        return customer;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
