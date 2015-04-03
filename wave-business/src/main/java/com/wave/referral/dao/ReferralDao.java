package com.wave.referral.dao;


import com.wave.referral.ReferralData;
import com.wave.status.Status;

import java.util.List;

public interface ReferralDao {

    public ReferralData getReferralData(Long id);
    List<ReferralData> getAllReferrals();
    public void saveReferralData(ReferralData itemData);

    List<ReferralData> getAllClaimedAndOpenReferralsByUserId(Long userId);


    List<ReferralData> getAllReferralsByStatus(Status status, Long userId);
    Long getAllReferralsCountByStatus(Status status, Long userId);

    List<ReferralData> getAllReferralsByUserId(Long userId);
    Long getAllReferralCountByUserId(Long userId);

    List<ReferralData> getAllReferralsByStatus(Status status);
    Long getAllReferralsCountByStatus(Status status);
}
