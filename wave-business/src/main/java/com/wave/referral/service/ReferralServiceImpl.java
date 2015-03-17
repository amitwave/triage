package com.wave.referral.service;


import com.wave.referral.ReferralData;
import com.wave.referral.dao.ReferralDao;
import com.wave.user.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;


@Service
public class ReferralServiceImpl implements ReferralService {


    @Autowired
    private ReferralDao referralDao;

    @Override
    public ReferralData getReferralData(Long id) {
       return referralDao.getReferralData(id);
    }

    @Override
    public void saveReferralData(ReferralData itemData) {
        referralDao.saveReferralData(itemData);
    }
}
