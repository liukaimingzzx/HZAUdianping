package com.hzau.dp.controller;

import com.hzau.dp.entity.Food;
import com.hzau.dp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@ResponseBody
public class FoodController {
    Map<String,Object> modelMap = new HashMap<>();
    @Autowired
    FoodService foodService;

    @RequestMapping(value = "/list/foodlist")
    public Map<String,Object> listFood(@RequestBody Map<String, Integer> data){
        modelMap.clear();
        Integer a = data.get("storeid");
        List<Food> list = foodService.listBySid(a);
        modelMap.put("foodInfo",list);
        return modelMap;
    }

    @RequestMapping(value = "/food/thumbup")
    public Map<String,Object> thumb(@RequestBody Map<String, Integer> data){
        modelMap.clear();
        Integer b = data.get("foodid");
        foodService.thumbUp(b);
        Food controller = new Food();
        int num = foodService.queryFoodById(data.get("foodid")).getFoodCount();
        List<Food> list1 = foodService.listBySid(foodService.queryFoodById(data.get("foodid")).getStoreId());
        modelMap.put("foodInfo",list1);
        return modelMap;
    }

    @RequestMapping(value = "/food/randomlist")
    public Map<String,Object> randomlist(){
        modelMap.clear();
        List<Integer> b = foodService.findAll();
        List<Food> list1 = new LinkedList<>();
        for(int c = 0 ; c<4 ; c++){
            Random random = new Random();
            list1.add(foodService.queryFoodById(random.nextInt(b.size()-1)+1));
        }
        modelMap.put("foodInfo",list1);
        return modelMap;
    }
}
