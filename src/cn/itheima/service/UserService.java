package cn.itheima.service;

import cn.itheima.domain.User;

import java.util.List;

public interface UserService {
    //登录
    User getByUser_codeAndUser_pwd(User u);
    //注册
    void saveUser(User user);
    //查询所有用户
    List<User> getAll();
}
