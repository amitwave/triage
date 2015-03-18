package com.wave.address.dao;


import com.wave.address.AddressData;

public interface AddressDao {

    public AddressData getAddressData(Long id);
    public void saveAddressData(AddressData itemData);
}
