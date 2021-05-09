package com.hzau.dp.service.implement;

import com.hzau.dp.dao.FoodDao;
import com.hzau.dp.entity.Food;
import com.hzau.dp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodImpl implements FoodService{

    @Autowired
    FoodDao foodDao;

    @Override
    public List<Food> listBySid(Integer storeId) {
        return foodDao.listBySid(storeId);

    }

    @Override
    public int thumbUp(Integer foodId) {
        return foodDao.thumbUp(foodId);
    }

    @Override
    public Food queryFoodById(Integer foodId) {
        return foodDao.queryFoodById(foodId);
    }

    @Override
    public List<Integer> findAll() {
        return foodDao.findAll();
    }
}
