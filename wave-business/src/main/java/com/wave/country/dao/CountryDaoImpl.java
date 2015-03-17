package com.wave.country.dao;


import com.wave.city.dao.CityData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class CountryDaoImpl extends AbstractDao<CountryData> implements CountryDao {

    @Override
    public CountryData getCountryData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(CountryData.FIND_COUNTRY_BY_ID);
        query.setParameter("id", id);
        return (CountryData) query.getResultList().get(0);
    }

    @Override
    public void saveCountryData(CountryData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
