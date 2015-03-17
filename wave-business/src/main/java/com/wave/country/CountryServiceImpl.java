package com.wave.country;


import com.wave.country.dao.CountryDao;
import com.wave.country.dao.CountryData;

public class CountryServiceImpl implements CountryService {

    private CountryDao cityDao;

    @Override
    public CountryData getCountryData(Long id) {
        return cityDao.getCountryData(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveCountryData(CountryData itemData) {
        cityDao.saveCountryData(itemData);
    }
}
