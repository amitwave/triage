package com.wave.referral.service;


import com.wave.referral.ReferralData;
import com.wave.status.Status;

import java.util.List;

public interface ReferralService {

    public ReferralData getReferralData(Long id);
    public List<ReferralData> getAllReferrals();
    public void saveReferralData(ReferralData referralData);
    public void checkoutReferralData(Long referralId, Long userId);
    void releaseReferralData(Long referralId, Long userId);
    void validate(Long referralId, Long userId);
    void setReferralStatus(Long referralId, Long userId, Status status);




    List<ReferralData> getAllReferralsByStatus(Status status, Long userId);
    List<ReferralData> getAllReferralsByStatus(Status status, Long userId, Integer page);
    Long getAllReferralsCountByStatus(Status status, Long userId);

    List<ReferralData> getAllReferralsByUserId(Long userId);
    List<ReferralData> getAllReferralsByUserId(Long userId, Integer page);
    Long getAllReferralCountByUserId(Long userId);

    List<ReferralData> getAllReferralsByStatus(Status status);
    List<ReferralData> getAllReferralsByStatusAndPage(Status status, Integer page);
    List<ReferralData> getAllReferralsByProcessIds(List<String> processIds);
    Long getAllReferralsCountByStatus(Status status);


}
