package com.wave.referral.dao;


import com.wave.referral.ReferralData;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Repository
public class ReferralDaoImpl extends AbstractDao<ReferralData> implements ReferralDao {

    @Override
    public ReferralData getReferralData(Long id) {
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        // return super.findFirstByNamedQuery(UserData.FIND_BY_ID, params) ;
         Query query = entityManager.createNamedQuery(ReferralData.FIND_REFERRAL_BY_ID);
        query.setParameter("id", id);
        return (ReferralData) query.getResultList().get(0);
    }

    @Override
    public void saveReferralData(ReferralData itemData) {
        entityManager.persist(itemData);
        entityManager.flush();
    }
}
