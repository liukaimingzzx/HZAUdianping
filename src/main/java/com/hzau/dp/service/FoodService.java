package com.hzau.dp.service;

import com.hzau.dp.entity.Food;

import java.util.List;

public interface FoodService {
        List<Food> listBySid(Integer storeId);
        List<Integer> findAll();
        int thumbUp(Integer foodId);
        Food queryFoodById(Integer foodId);

}

