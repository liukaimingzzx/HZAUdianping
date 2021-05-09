package com.hzau.dp.service.implement;

import com.hzau.dp.dao.UserDao;
import com.hzau.dp.entity.User;
import com.hzau.dp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User queryUserByName(Integer userName) {
        return userDao.queryUserByName(userName);
    }

    @Override
    public User insertUser(User user) {
        int flag = userDao.insertUser(user);
        if(flag>0){
            return userDao.queryUserByName(user.getUserName());
        }else{
            throw new RuntimeException("插入失败！");
        }

    }

    @Override
    public User judgeUser(Integer userName, String password) {
        return userDao.judgeUser(userName, password);
    }

    @Override
    public User updateUser(User user) {
        int newUser = userDao.updateUser(user);
        if(newUser>0){
            return userDao.queryUserByName(user.getUserName());
        }else{
            throw new RuntimeException("更新失败！");
        }
    }
}
