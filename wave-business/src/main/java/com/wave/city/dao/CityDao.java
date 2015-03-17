package com.wave.city.dao;


public interface CityDao {

    public CityData getCityData(Long id);
    public void saveCityData(CityData itemData);
}
