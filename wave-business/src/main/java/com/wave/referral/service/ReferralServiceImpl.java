package com.wave.referral.service;


import com.wave.patient.dao.PatientDao;
import com.wave.referral.ReferralData;
import com.wave.referral.dao.ReferralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ReferralServiceImpl implements ReferralService {


    @Autowired
    private ReferralDao referralDao;


    @Autowired
    private PatientDao patientDao;


    @Override
    public ReferralData getReferralData(Long id) {
       return referralDao.getReferralData(id);
    }

    @Override
    public List<ReferralData> getAllReferrals() {

        return referralDao.getAllReferrals();
    }

    @Override
    @Transactional
    public void saveReferralData(ReferralData referralData) {
        referralDao.saveReferralData(referralData);
    }
}
