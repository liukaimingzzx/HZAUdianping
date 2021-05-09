package com.hzau.dp.entity;

public class Store {
    private Integer storeId;
    private Integer canteenId;
    private String storeName;
    private Float storeScore;
    private Integer storeFloor;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Float getStoreScore() {
        return storeScore;
    }

    public void setStoreScore(Float storeScore) {
        this.storeScore = storeScore;
    }

    public Integer getStoreFloor() {
        return storeFloor;
    }

    public void setStoreFloor(Integer storeFloor) {
        this.storeFloor = storeFloor;
    }
}
