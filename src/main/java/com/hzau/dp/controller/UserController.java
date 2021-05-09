package com.hzau.dp.controller;

import com.hzau.dp.entity.User;
import com.hzau.dp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    Map<String, Object> modelMap = new HashMap<>();

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value="/register")
    public Map<String, Object> insertUser(@RequestBody Map<String, Object> data) {
        modelMap.clear();
        User user = new User();
        user.setNickname((String) data.get("nickname"));
        user.setPassword((String) data.get("password"));
        user.setUserName((Integer) data.get("username"));

        User flag = userService.queryUserByName(user.getUserName());
        if(flag == null){
            User controller = userService.insertUser(user);
            modelMap.put("errno", 0);
            modelMap.put("msg", "注册成功！");
        }else {
            modelMap.put("errno", -1);
            modelMap.put("msg", "用户名已被占用！");
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("/login")
    public Map<String,Object> signin(@RequestBody Map<String,Object> data){
        modelMap.clear();
        Integer userName = (Integer) data.get("username");
        String password = (String) data.get("password");
	    User controller = userService.judgeUser(userName,password);
	    if(controller !=null){
	        modelMap.put("errno",0);
	        modelMap.put("user",controller);
	    }else{
	        modelMap.put("errno",-1);
	        modelMap.put("msg","用户名或密码错误");
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map<String,Object> update(@RequestBody Map<String,Object> data){
        modelMap.clear();
        User user = new User();

        user.setNickname((String) data.get("nickname"));
        user.setPassword((String) data.get("password"));
        user.setUserName((Integer) data.get("username"));
        user.setHometown((String) data.get("hometown"));
        user.setAge((Integer) data.get("age"));
        user.setGender((Integer) data.get("gender"));
        user.setSignature((String) data.get("signature"));

        User con = userService.updateUser(user);
        System.out.println(con);
        if (con != null) {
            modelMap.put("errno", 0);
            modelMap.put("msg","更新成功！");
        } else {
            modelMap.put("errno", -1);
            modelMap.put("msg","更新失败！");
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/test",method= RequestMethod.GET)
    public String aaa(){
        return "999999";
    }

}



