package com.wave.city;


import com.wave.city.dao.CityDao;
import com.wave.city.dao.CityData;

public class CityServiceImpl implements CityService{

    private CityDao cityDao;

    @Override
    public CityData getCityData(Long id) {
        return cityDao.getCityData(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveCityData(CityData itemData) {
        cityDao.saveCityData(itemData);
    }
}
