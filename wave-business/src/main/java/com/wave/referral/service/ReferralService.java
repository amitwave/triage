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
    Long getAllReferralsCountByStatus(Status status, Long userId);

    List<ReferralData> getAllReferralsByUserId(Long userId);
    Long getAllReferralCountByUserId(Long userId);

    List<ReferralData> getAllReferralsByStatus(Status status);
    Long getAllReferralsCountByStatus(Status status);


}
