package com.hzau.dp.controller;

import com.hzau.dp.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class CanteenController {
    Map<String,Object> modelMap = new HashMap<>();

    @Autowired
    CanteenService canteenService;

    @RequestMapping(value = "/list/canteenlist")
    public Map<String,Object> listAll(){
        modelMap.clear();
        List list = canteenService.findAll();
        modelMap.put("canteenInfo",list);
        System.out.println(list);
        return modelMap;

    }

}
