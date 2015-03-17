package com.wave.itemgroup;


import com.wave.itemgroup.dao.ItemGroupDao;
import com.wave.itemgroup.dao.ItemGroupData;

public class ItemGroupServiceImpl implements ItemGroupService {

    private ItemGroupDao cityDao;

    @Override
    public ItemGroupData getItemGroupData(Long id) {
        return cityDao.getItemGroupData(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveItemGroupData(ItemGroupData itemData) {
        cityDao.saveItemGroupData(itemData);
    }
}
