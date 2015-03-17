package com.wave.country.dao;


public interface CountryDao {

    public CountryData getCountryData(Long id);
    public void saveCountryData(CountryData itemData);
}
