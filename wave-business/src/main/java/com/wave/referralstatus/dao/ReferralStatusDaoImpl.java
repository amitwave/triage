package com.wave.referralstatus.dao;


import com.wave.referral.ReferralData;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.status.Status;
import com.wave.user.AbstractDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ReferralStatusDaoImpl extends AbstractDao<ReferralStatusData> implements ReferralStatusDao {

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
    public void saveReferralData(ReferralData itemData) {

    }

    @Override
    public List<ReferralData> getAllReferralsByStatus(Status status, Long userId) {

        Query query = entityManager.createNamedQuery(ReferralData.FIND_ALL_REFERRALS);

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
        Query query = entityManager.createNamedQuery(ReferralStatusData.FIND_ALL_NEW_REFERRALS);
        List<ReferralStatusData> resultList = query.getResultList();
        List<ReferralData> referralDatas = new ArrayList<ReferralData>();

        for(ReferralStatusData referralStatusData : resultList){
            ReferralData referralData = referralStatusData.getReferralData();
            if(Status.NEW.equals(referralData.getReferralStatusDatas().get(0))) {
                referralDatas.add(referralData);
            }
        }
        return referralDatas;
    }

    @Override
    public List<ReferralData> getAllClaimedAndOpenReferralsByUserId(Long userId) {
        Query query = entityManager.createNamedQuery(ReferralData.FIND_ALL_OPEN_REFERRALS_BY_USER);
        query.setParameter("id", userId);
        return query.getResultList();
    }


}
