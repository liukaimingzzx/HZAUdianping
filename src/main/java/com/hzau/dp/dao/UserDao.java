package com.hzau.dp.dao;

import com.hzau.dp.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    Integer insertUser(User user);
    User judgeUser(Integer userName,String password);
    User queryUserByName(Integer userName);
    int updateUser(User user);


}
