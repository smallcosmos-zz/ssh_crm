package cn.itheima.service.Impl;

import cn.itheima.dao.UserDao;
import cn.itheima.domain.User;
import cn.itheima.service.UserService;
import cn.itheima.utils.MD5Utils;

import java.util.List;

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
        if(!exitU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
            throw new RuntimeException("密码错误！");
        }
        //判断密码是否正确
        return exitU;
    }

    @Override
    public void saveUser(User user) {
        //1 根据user_code查询用户
        User exitU = userDao.getByUser_codeAndUser_pwd(user.getUser_code());
        if(exitU != null){
            //用户已经存在，抛出异常
            throw new RuntimeException("该用户已存在");
        }
        //对用户密码进行MD5加密
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        //2 用户不存在执行保存
        userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
