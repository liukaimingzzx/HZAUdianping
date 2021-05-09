package com.hzau.dp.service.implement;

import com.hzau.dp.dao.CanteenDao;
import com.hzau.dp.entity.Canteen;
import com.hzau.dp.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenImpl implements CanteenService {
    @Autowired
    CanteenDao canteenDao;

    @Override
    public List<Canteen> findAll() {
        return canteenDao.findAll();
    }
}
