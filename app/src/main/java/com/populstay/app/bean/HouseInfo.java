package com.populstay.app.bean;

/**
 * 房源信息实体类
 * Created by Jerry
 */

public class HouseInfo {

    private String id;
    private String mIvHouseCover;
    private String mTvHouseName;
    private String mTvHouseAddress;
    private String mTvHousePrice;
    private String mTvHouseCount;

    public HouseInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIvHouseCover() {
        return mIvHouseCover;
    }

    public void setIvHouseCover(String ivHouseCover) {
        mIvHouseCover = ivHouseCover;
    }

    public String getTvHouseName() {
        return mTvHouseName;
    }

    public void setTvHouseName(String tvHouseName) {
        mTvHouseName = tvHouseName;
    }

    public String getTvHouseAddress() {
        return mTvHouseAddress;
    }

    public void setTvHouseAddress(String tvHouseAddress) {
        mTvHouseAddress = tvHouseAddress;
    }

    public String getTvHousePrice() {
        return mTvHousePrice;
    }

    public void setTvHousePrice(String tvHousePrice) {
        mTvHousePrice = tvHousePrice;
    }

    public String getTvHouseCount() {
        return mTvHouseCount;
    }

    public void setTvHouseCount(String tvHouseCount) {
        mTvHouseCount = tvHouseCount;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id='" + id + '\'' +
                ", mIvHouseCover='" + mIvHouseCover + '\'' +
                ", mTvHouseName='" + mTvHouseName + '\'' +
                ", mTvHouseAddress='" + mTvHouseAddress + '\'' +
                ", mTvHousePrice='" + mTvHousePrice + '\'' +
                ", mTvHouseCount='" + mTvHouseCount + '\'' +
                '}';
    }
}
