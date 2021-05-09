package com.hzau.dp.service;

import com.hzau.dp.entity.User;


public interface UserService{
    User queryUserByName(Integer userName);
    User insertUser(User user);
    User judgeUser(Integer userName,String password);
    User updateUser(User user);

}
   
