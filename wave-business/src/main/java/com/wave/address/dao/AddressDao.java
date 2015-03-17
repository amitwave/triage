package com.wave.address.dao;


import com.wave.address.AddressData;
import com.wave.city.dao.CityData;

public interface AddressDao {

    public AddressData getAddressData(Long id);
    public void saveAddressData(AddressData itemData);
}
