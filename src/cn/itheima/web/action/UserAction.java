package cn.itheima.web.action;

import cn.itheima.domain.User;
import cn.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private User user = new User();

    public String login() throws Exception {
        //1 调用userService查询用户
        User exitUser = userService.getByUser_codeAndUser_pwd(this.user);
        //2 将返回的user对象放入session域中
        ActionContext.getContext().getSession().put("loginUser",exitUser);
        //3 重定向到首页
        return "toHome";
    }

    public String regist() throws Exception {
       //1 调用service保存用户
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            ActionContext.getContext().put("error",e.getMessage());
            return "regist";
        }
        //重定向到登录页面
        return "toLogin";
    }

    public String list() throws Exception {
       //调用service查询所有用户
        List<User> list = userService.getAll();
       // 将返回结果转成json
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setIgnoreDefaultExcludes(false);
        //解决死循环
        jsonConfig.setExcludes(new String[]{"roles","saleVisits"});

         String json = JSONArray.fromObject(list, jsonConfig).toString();


        //将json字符串返回到浏览器
        ServletActionContext.getResponse().setContentType("application/json;charset=utf8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;//告诉struts不进行结果处理
    }

    @Override
    public User getModel() {
        return user;
    }
}
