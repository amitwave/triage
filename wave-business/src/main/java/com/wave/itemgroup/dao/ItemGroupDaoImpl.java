package com.wave.itemgroup.dao;


import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ItemGroupDaoImpl extends AbstractDao<ItemGroupData> implements ItemGroupDao {

    @Override
    public ItemGroupData getItemGroupData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
        Query query = entityManager.createNamedQuery(ItemGroupData.FIND_ITEM_GROUP_BY_ID);
        query.setParameter("id", id);
        return (ItemGroupData) query.getResultList().get(0);

    }

    @Override
    public void saveItemGroupData(ItemGroupData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
