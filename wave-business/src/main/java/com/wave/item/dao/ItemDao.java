package com.wave.item.dao;


public interface ItemDao {

    public ItemData getItemData(Long id);
    public void saveItemData(ItemData itemData);
}
