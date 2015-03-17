package com.wave.referrer.dao;


import com.wave.patient.PatientData;
import com.wave.referrer.ReferrerData;

public interface ReferrerDao {

    public ReferrerData getReferrerData(Long id);
    public void saveReferrerData(ReferrerData itemData);
}
