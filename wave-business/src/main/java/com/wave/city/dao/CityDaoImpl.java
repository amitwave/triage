package com.wave.city.dao;


import com.wave.item.dao.ItemData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class CityDaoImpl extends AbstractDao<CityData> implements CityDao {

    @Override
    public CityData getCityData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(CityData.FIND_CITY_BY_ID);
        query.setParameter("id", id);
        return (CityData) query.getResultList().get(0);
    }

    @Override
    public void saveCityData(CityData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
