package com.wave.controller.referral;

import com.wave.controller.command.PatientCommand;
import com.wave.controller.command.ReferralCommand;
import com.wave.controller.command.RoleCommand;
import com.wave.controller.command.UserCommand;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referralstatus.ReferralStatusData;
import com.wave.role.RoleData;
import com.wave.user.dao.UserData;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by amit on 19/03/2015.
 */
public class Converter {

    public static List<ReferralCommand> getReferralCommands(List<ReferralData> referrals){
        List<ReferralCommand> referralCommands = new ArrayList<ReferralCommand>();

        if(referrals != null) {
            for (ReferralData referralData : referrals) {
                referralCommands.add(getReferralCommand(referralData));
            }
        }

        return  referralCommands;
    }
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

    public static UserCommand getUserCommand(UserData userData) {
        UserCommand userCommand = new UserCommand();
        userCommand.setEmail(userData.getEmail());
        userCommand.setName(userData.getUserName());
        userCommand.setDisplayName(userData.getDisplayName());

        List<RoleData> roles = userData.getRoles();
        List<RoleCommand> roleCommands = new ArrayList<RoleCommand>();
        for(RoleData role: roles) {
            roleCommands.add(getRoleCommand(role));
        }

        userCommand.setRoles(roleCommands);

        return userCommand;
    }

    public static RoleCommand getRoleCommand(RoleData role) {
        RoleCommand roleCommand = new RoleCommand();
        roleCommand.setName(role.getName());
        roleCommand.setDescription(role.getDescription());
        return roleCommand;
    }



}
