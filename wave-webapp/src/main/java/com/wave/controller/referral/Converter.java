package com.wave.controller.referral;

import com.wave.controller.command.PatientCommand;
import com.wave.controller.command.ReferralCommand;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referralstatus.ReferralStatusData;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by amit on 19/03/2015.
 */
public class Converter {

    public static ReferralCommand getReferralCommand(ReferralData referralData) {

        ReferralCommand referralCommand = new ReferralCommand();
        referralCommand.setId(referralData.getId());
        referralCommand.setActive(referralData.isActive());
        referralCommand.setUbrn(referralData.getUbrn());
        referralCommand.setDescription(referralData.getDescription());
        referralCommand.setType(referralData.getType());
        List<ReferralStatusData> referralStatusDatas = referralData.getReferralStatusDatas();
        if(referralStatusDatas != null && !CollectionUtils.isEmpty(referralStatusDatas)) {
            referralCommand.setStatus(referralStatusDatas.get(0).getToStatus());
        }
        PatientData patientData = referralData.getPatient();
        PatientCommand patientCommand = getPatientCommand(patientData);
        referralCommand.setPatient(patientCommand);

        return referralCommand;

    }


    public static PatientCommand getPatientCommand(PatientData patientData) {
        PatientCommand patientCommand = new PatientCommand();

        if(patientData != null) {
            patientCommand.setId(patientData.getId());
            patientCommand.setNhsNumber(patientData.getNhsNumber());
        }
        return patientCommand;
    }
}
