package com.wave.item.dao;


import com.wave.itemgroup.dao.ItemGroupData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ItemDaoImpl extends AbstractDao<ItemData> implements ItemDao {

    @Override
    public ItemData getItemData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);

        Query query = entityManager.createNamedQuery(ItemData.FIND_ITEM_BY_ID);
        query.setParameter("id", id);
        return (ItemData) query.getResultList().get(0);

    }

    @Override
    public void saveItemData(ItemData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
