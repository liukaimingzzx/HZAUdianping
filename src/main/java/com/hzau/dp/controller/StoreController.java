package com.hzau.dp.controller;

import com.hzau.dp.entity.Store;
import com.hzau.dp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class StoreController {
    Map<String,Object> modelMap = new HashMap<>();
    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/list/storelist")
    public Map<String,Object> listStore(@RequestBody Map<String, Integer> data){
        Integer a = data.get("canteenid");
        List<Store> list = storeService.listByCid(a);
        modelMap.put("storeInfo",list);
        return modelMap;
    }
    @RequestMapping(value = "/food/getstore")
    public Map<String,Object> listGet(@RequestBody Map<String, Integer> data){
        Integer a = data.get("storeid");
        Store b = storeService.query2(a);
        modelMap.put("storeInfo",b);
        return modelMap;
    }


}
