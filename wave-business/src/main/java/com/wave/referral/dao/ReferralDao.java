package com.wave.referral.dao;


import com.wave.referral.ReferralData;

import java.util.List;

public interface ReferralDao {

    public ReferralData getReferralData(Long id);
    List<ReferralData> getAllReferrals();
    public void saveReferralData(ReferralData itemData);
}
