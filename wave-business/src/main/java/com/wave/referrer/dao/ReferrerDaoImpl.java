package com.wave.referrer.dao;


import com.wave.referrer.ReferrerData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ReferrerDaoImpl extends AbstractDao<ReferrerData> implements ReferrerDao {

    @Override
    public ReferrerData getReferrerData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(ReferrerData.FIND_REFERRER_BY_ID);
        query.setParameter("id", id);
        return (ReferrerData) query.getResultList().get(0);
    }

    @Override
    public void saveReferrerData(ReferrerData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
