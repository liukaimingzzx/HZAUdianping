package com.hzau.dp.dao;

import com.hzau.dp.entity.Food;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface FoodDao {
    List<Food> listBySid(Integer storeId);
    List<Integer> findAll();
    int thumbUp(Integer foodId);
    Food queryFoodById(Integer foodId);
}
