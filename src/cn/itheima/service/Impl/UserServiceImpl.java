package cn.itheima.service.Impl;

import cn.itheima.dao.UserDao;
import cn.itheima.domain.User;
import cn.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getByUser_codeAndUser_pwd(User u) {
        //根据user_code查询用户
        User exitU = userDao.getByUser_codeAndUser_pwd(u.getUser_code());
        //判断用户是否存在
        if(exitU == null){
            throw new RuntimeException("用户名错误！");
        }
        if(!exitU.getUser_password().equals(u.getUser_password())){
            throw new RuntimeException("密码错误！");
        }
        //判断密码是否正确
        return exitU;
    }
}
