package com.hzau.dp.dao;

import com.hzau.dp.entity.Canteen;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CanteenDao {
    List<Canteen> findAll();
}
