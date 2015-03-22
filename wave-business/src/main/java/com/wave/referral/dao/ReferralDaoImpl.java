package com.wave.referral.dao;


import com.wave.referral.ReferralData;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.status.Status;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.*;


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
    public List<ReferralData> getAllReferrals() {

        Query query = entityManager.createNamedQuery(ReferralData.FIND_ALL_REFERRALS);

        return query.getResultList();
    }

    @Override
    public List<ReferralData> getAllReferralsByStatus(Status status, Long userId) {

        Query query = entityManager.createNamedQuery(ReferralData.FIND_ALL_OPEN_REFERRALS_BY_USER_AND_STATUS);
        query.setParameter("id", userId);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List<ReferralData> getAllReferralsByUserId(Long userId) {
        Query query = entityManager.createNamedQuery(ReferralData.FIND_ALL_REFERRALS_BY_USER);
        query.setParameter("id", userId);
        return query.getResultList();
    }

    @Override
    public List<ReferralData> getAllNewReferrals() {
        Query query = entityManager.createNamedQuery(ReferralData.FIND_ALL_NEW_REFERRAL_DATA);
        return query.getResultList();
    }

    @Override
    public List<ReferralData> getAllClaimedAndOpenReferralsByUserId(Long userId) {
        Query query = entityManager.createNamedQuery(ReferralData.FIND_ALL_OPEN_REFERRALS_BY_USER);
        query.setParameter("id", userId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveReferralData(ReferralData itemData) {

        if(null == itemData.getId()) {
            super.save(itemData);
        }else{
            update(itemData);
        }
        entityManager.flush();
    }
}
