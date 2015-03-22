package com.wave.referral.service;


import com.wave.patient.dao.PatientDao;
import com.wave.referral.ReferralData;
import com.wave.referral.dao.ReferralDao;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.status.Status;
import com.wave.user.dao.UserDao;
import com.wave.user.dao.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class ReferralServiceImpl implements ReferralService {


    @Autowired
    private ReferralDao referralDao;

    @Autowired
    private UserDao userDao;


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

    @Override
    @Transactional
    public void checkoutReferralData(Long referralId, Long userId) {
        UserData userData = userDao.getUserData(userId);
        ReferralData referralData = getReferralData(referralId);
        List<ReferralStatusData> referralStatusDatas = referralData.getReferralStatusDatas();


        ReferralStatusData referralStatusData = referralStatusDatas.get(0);

        Status status = referralStatusData.getToStatus();
        if(Status.NEW.equals(status)){

            ReferralStatusData newReferralStatusData = new ReferralStatusData();
            newReferralStatusData.setLastUpdated(new Date());
            newReferralStatusData.setToStatus(Status.CHECKOUT);

            newReferralStatusData.setUser(userData);
            newReferralStatusData.setReferralData(referralData);
            referralStatusDatas.add(newReferralStatusData);

            referralData.setStatus(Status.CHECKOUT);
            referralData.setUser(userData);
        }else{
            throw new RuntimeException("invalid step");
        }

        referralDao.saveReferralData(referralData);
    }

    @Override
    public List<ReferralData> getAllReferralsByUserId(Long userId) {
        return referralDao.getAllReferralsByUserId(userId);
    }

    @Override
    public List<ReferralData> getAllClaimedAndOpenReferralsByUserId(Long userId) {
        return referralDao.getAllClaimedAndOpenReferralsByUserId(userId);
    }

    @Override
    public void releaseReferralData(Long referralId, Long userId) {
        UserData userData = userDao.getUserData(userId);
        ReferralData referralData = getReferralData(referralId);
        List<ReferralStatusData> referralStatusDatas = referralData.getReferralStatusDatas();


        ReferralStatusData referralStatusData = referralStatusDatas.get(0);

        Status status = referralStatusData.getToStatus();
        if(Status.CHECKOUT.equals(status) || Status.UPDATE.equals(status)
                || Status.CLAIM_VALIDATE.equals(status) || Status.IN_VALIDATION.equals(status) ){

            ReferralStatusData newReferralStatusData = new ReferralStatusData();
            newReferralStatusData.setLastUpdated(new Date());
            newReferralStatusData.setToStatus(Status.NEW);
            newReferralStatusData.setUser(userData);
            newReferralStatusData.setReferralData(referralData);
            referralStatusDatas.add(newReferralStatusData);

            referralData.setStatus(Status.NEW);
            referralData.setUser(null);
        }else{
            throw new RuntimeException("invalid step");
        }

        referralDao.saveReferralData(referralData);
    }


    @Override
    public List<ReferralData> getAllNewReferrals() {
        return referralDao.getAllNewReferrals();
    }
}
