package cn.itheima.dao;

import cn.itheima.domain.User;

public interface UserDao extends BaseDao<User>{
    User getByUser_codeAndUser_pwd(String user_code);
}
