package com.wave.item;


import com.wave.item.dao.ItemDao;
import com.wave.item.dao.ItemData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao cityDao;

    @Override
    public ItemData getItemData(Long id) {
        return cityDao.getItemData(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveItemData(ItemData itemData) {
        cityDao.saveItemData(itemData);
    }
}
