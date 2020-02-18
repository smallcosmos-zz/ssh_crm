package cn.itheima.web.interceptor;

import cn.itheima.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //获取session
        User user = (User) ActionContext.getContext().getSession().get("loginUser");
        //判断loginUser是否为空
        if(user != null){
            //不为空==》放行
            return actionInvocation.invoke();
        }else{
            //不为空==》重定向到登录页面
            return "toLogin";
        }
    }
}
