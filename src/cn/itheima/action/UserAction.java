package cn.itheima.action;

import cn.itheima.domain.User;
import cn.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
        ActionContext.getContext().getSession().put("loginUser",user);
        //3 重定向到首页
        return "toHome";
    }

    @Override
    public User getModel() {
        return user;
    }
}
