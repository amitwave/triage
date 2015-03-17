package com.wave.referral.service;


import com.wave.referral.ReferralData;

public interface ReferralService {

    public ReferralData getReferralData(Long id);
    public void saveReferralData(ReferralData itemData);
}
