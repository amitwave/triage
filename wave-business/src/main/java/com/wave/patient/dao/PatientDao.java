package com.wave.patient.dao;


import com.wave.patient.PatientData;

public interface PatientDao {

    public PatientData getPatientData(Long id);
    public void savePatientData(PatientData itemData);
}
