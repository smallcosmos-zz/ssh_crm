package cn.itheima.service;

import cn.itheima.domain.User;

public interface UserService {
    //登录
    User getByUser_codeAndUser_pwd(User u);
    //注册
    void saveUser(User user);
}
