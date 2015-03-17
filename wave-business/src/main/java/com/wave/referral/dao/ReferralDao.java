package com.wave.referral.dao;


import com.wave.referral.ReferralData;

public interface ReferralDao {

    public ReferralData getReferralData(Long id);
    public void saveReferralData(ReferralData itemData);
}
