package com.wave.locality.dao;


public interface LocalityDao {

    public LocalityData getLocalityData(Long id);
    public void saveLocalityData(LocalityData itemData);
}
