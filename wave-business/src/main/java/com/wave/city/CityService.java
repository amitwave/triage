package com.wave.city;


import com.wave.city.dao.CityData;

public interface CityService {

    public CityData getCityData(Long id);
    public void saveCityData(CityData itemData);
}
