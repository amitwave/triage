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
    Integer getAllReferralsCountByStatus(Status status, Long userId);

    List<ReferralData> getAllReferralsByUserId(Long userId);
    Integer getAllReferralCountByUserId(Long userId);

    List<ReferralData> getAllReferralsByStatus(Status status);
    Integer getAllReferralsCountByStatus(Status status);
}
