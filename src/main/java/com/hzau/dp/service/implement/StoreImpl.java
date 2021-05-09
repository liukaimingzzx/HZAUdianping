package com.hzau.dp.service.implement;

import com.hzau.dp.dao.StoreDao;
import com.hzau.dp.entity.Store;
import com.hzau.dp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreImpl implements StoreService {
    @Autowired
    StoreDao storeDao;


    @Override
    public Store queryStoreById(Integer storeId) {
        return storeDao.queryStoreById(storeId);
    }

    @Override
    public List<Store> listByCid(Integer canteenId) {
        return storeDao.listByCid(canteenId);

    }

    @Override
    public Store query2(Integer storeId) {
        return storeDao.query2(storeId);
    }
}
