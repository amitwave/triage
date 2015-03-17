package com.wave.item;

import com.wave.country.dao.CountryData;
import com.wave.item.dao.ItemData;

public interface ItemService {

    public ItemData getItemData(Long id);
    public void saveItemData(ItemData itemData);
}
