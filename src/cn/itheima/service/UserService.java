package cn.itheima.service;

import cn.itheima.domain.User;

public interface UserService {
    User getByUser_codeAndUser_pwd(User u);
}
