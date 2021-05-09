package com.hzau.dp.dao;

import com.hzau.dp.entity.Store;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StoreDao {
    List<Store> listByCid(Integer canteenId);
    Store queryStoreById(Integer storeId);
    Store query2(Integer storeId);

}



