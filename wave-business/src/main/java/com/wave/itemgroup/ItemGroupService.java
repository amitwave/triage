package com.wave.itemgroup;

import com.wave.itemgroup.dao.ItemGroupData;

public interface ItemGroupService {

    public ItemGroupData getItemGroupData(Long id);
    public void saveItemGroupData(ItemGroupData itemData);
}
