package com.wave.locality.dao;


import com.wave.country.dao.CountryData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class LocalityDaoImpl extends AbstractDao<LocalityData> implements LocalityDao {

    @Override
    public LocalityData getLocalityData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
         Query query = entityManager.createNamedQuery(LocalityData.FIND_LOCALITY_BY_ID);
        query.setParameter("id", id);
        return (LocalityData) query.getResultList().get(0);
    }

    @Override
    public void saveLocalityData(LocalityData itemData) {

        entityManager.persist(itemData);
        entityManager.flush();
    }
}
