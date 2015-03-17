package com.wave.country;

import com.wave.country.dao.CountryData;

public interface CountryService {

    public CountryData getCountryData(Long id);
    public void saveCountryData(CountryData itemData);
}
