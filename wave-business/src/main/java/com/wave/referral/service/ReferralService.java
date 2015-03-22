package com.wave.referral.service;


import com.wave.referral.ReferralData;
import com.wave.status.Status;

import java.util.List;

public interface ReferralService {

    public ReferralData getReferralData(Long id);
    public List<ReferralData> getAllReferrals();
    public void saveReferralData(ReferralData referralData);
    public void checkoutReferralData(Long referralId, Long userId);
    List<ReferralData> getAllReferralsByUserId(Long userId);
    List<ReferralData> getAllNewReferrals();
    List<ReferralData> getAllClaimedAndOpenReferralsByUserId(Long userId);
    List<ReferralData> getAllValidatedReferrals(Long userId);
    List<ReferralData> getAllReferralsByStatus(Status status, Long userId);
    void releaseReferralData(Long referralId, Long userId);
    void validate(Long referralId, Long userId);
    void setReferralStatus(Long referralId, Long userId, Status status);
}
