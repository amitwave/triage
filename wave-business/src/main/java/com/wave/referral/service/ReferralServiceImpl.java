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
    public List<ReferralData> getAllReferralsByStatus(Status status, Long userId) {
        return referralDao.getAllReferralsByStatus(status, userId);
    }

    @Override
    public void releaseReferralData(Long referralId, Long userId) {
        updateReferralData(referralId, userId, Status.NEW);
    }

    private void updateReferralData(Long referralId, Long userId, Status newStatus) {
        UserData userData = userDao.getUserData(userId);
        ReferralData referralData = getReferralData(referralId);
        List<ReferralStatusData> referralStatusDatas = referralData.getReferralStatusDatas();


        Status currentStatus = referralData.getStatus();
        if(Status.CHECKOUT.equals(currentStatus) || Status.REFERRAL_INCOMPLETE.equals(currentStatus)){

            ReferralStatusData newReferralStatusData = new ReferralStatusData();
            newReferralStatusData.setLastUpdated(new Date());
            newReferralStatusData.setToStatus(newStatus);
            newReferralStatusData.setUser(userData);
            newReferralStatusData.setReferralData(referralData);

            referralStatusDatas.add(newReferralStatusData);

            referralData.setStatus(newStatus);

                referralData.setUser(userData);
            referralDao.saveReferralData(referralData);
        }else{
            throw new RuntimeException("invalid step");
        }


    }

    @Override
    public void validate(Long referralId, Long userId) {
       /* UserData userData = userDao.getUserData(userId);
        ReferralData referralData = getReferralData(referralId);
        List<ReferralStatusData> referralStatusDatas = referralData.getReferralStatusDatas();

        Status status = referralData.getStatus();
        if(Status.CHECKOUT.equals(status)){

            ReferralStatusData newReferralStatusData = new ReferralStatusData();
            newReferralStatusData.setLastUpdated(new Date());
            newReferralStatusData.setToStatus(Status.VALIDATED);
            newReferralStatusData.setUser(userData);
            newReferralStatusData.setReferralData(referralData);
            referralStatusDatas.add(newReferralStatusData);

            referralData.setReferralStatus(Status.VALIDATED);

        }else{
            throw new RuntimeException("invalid step");
        }

        referralDao.saveReferralData(referralData);*/

        updateReferralData(referralId, userId, Status.VALIDATED);
    }

    @Override
    public List<ReferralData> getAllReferralsByStatus(Status status) {
        return referralDao.getAllReferralsByStatus(status);
    }

    @Override
    public Integer getAllReferralsCountByStatus(Status status) {
        return referralDao.getAllReferralsCountByStatus(status);
    }

    @Override
    public void setReferralStatus(Long referralId, Long userId, Status status) {
        updateReferralData(referralId, userId, Status.REFERRAL_INCOMPLETE);
    }


}
