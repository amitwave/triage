package com.wave.name.dao;


import com.wave.name.NameData;

public interface NameDao {

    public NameData getNameData(Long id);
    public void saveNameData(NameData itemData);
}
