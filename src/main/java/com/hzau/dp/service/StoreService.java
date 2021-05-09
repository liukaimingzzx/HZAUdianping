package com.hzau.dp.service;

import com.hzau.dp.entity.Store;

import java.util.List;

public interface StoreService {
    List<Store> listByCid(Integer canteenId);
    Store queryStoreById(Integer storeId);
    Store query2(Integer storeId);
}
