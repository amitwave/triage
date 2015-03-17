package com.wave.itemgroup.dao;


public interface ItemGroupDao {

    public ItemGroupData getItemGroupData(Long id);
    public void saveItemGroupData(ItemGroupData itemData);
}
