package com.wave.controller.utils;


import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.controller.command.*;
import com.wave.destination.IGRDestinationData;
import com.wave.master.EthnicityData;
import com.wave.master.TitleData;
import com.wave.name.NameData;
import com.wave.patient.PatientData;
import com.wave.referral.ReferralData;
import com.wave.referrer.ReferrerData;
import com.wave.role.RoleData;
import com.wave.user.dao.UserData;

import java.util.ArrayList;
import java.util.List;

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
        referralCommand.setCreateDate(referralData.getCreateDate());
        referralCommand.setActive(referralData.isActive());
        referralCommand.setUbrn(referralData.getUbrn());
        referralCommand.setDescription(referralData.getDescription());
        referralCommand.setType(referralData.getType());
        referralCommand.setStatus(referralData.getStatus());
        referralCommand.setUser(getUserCommand(referralData.getUser()));
        PatientData patientData = referralData.getPatient();

        PatientCommand patientCommand = getPatientCommand(patientData);
        referralCommand.setPatient(patientCommand);

        ReferrerCommand referrerCommand = getReferrerCommand(referralData.getReferrerData());
        referralCommand.setReferrer(referrerCommand);

        referralCommand.setIgrDestination(getIGRDestinationCommand(referralData.getIgrDestinationData()));

        return referralCommand;

    }


    public static PatientCommand getPatientCommand(PatientData patientData) {
        PatientCommand patientCommand = new PatientCommand();

        if(patientData != null) {
            patientCommand.setId(patientData.getId());
            patientCommand.setNhsNumber(patientData.getNhsNumber());
            patientCommand.setLastUpdated(patientData.getLastUpdated());
            patientCommand.setName(getNameCommand(patientData.getNameData()));
            patientCommand.setGender(patientData.getGender());
            AddressCommand addressCommand = getAddressCommand(patientData.getAddress());

            patientCommand.setAddress(addressCommand);

            patientCommand.setContactDetails(getContactCommand(patientData.getContactDetails()));

            patientCommand.setPrimarySpokenLanguage(patientData.getPrimarySpokenLanguage());
            patientCommand.setSecondarySpokenLanguage(patientData.getSecondarySpokenLanguage());
            patientCommand.setWrittenLanguage(patientData.getWrittenLanguage());
            patientCommand.setAssistanceRequired(patientData.isAssistanceRequired());
            patientCommand.setInterpreterRequired(patientData.isInterpreterRequired());

            patientCommand.setEthnicity(Converter.getEthnicityCommand(patientData.getEthnicity()));
        }
        return patientCommand;
    }

    public static ReferrerCommand getReferrerCommand(ReferrerData referrerData) {
        ReferrerCommand referrerCommand = new ReferrerCommand();

        if(referrerData != null) {
            referrerCommand.setId(referrerData.getId());
            referrerCommand.setLastUpdated(referrerData.getLastUpdated());
            referrerCommand.setName(getNameCommand(referrerData.getNameData()));

            referrerCommand.setPracticeCode(referrerData.getPracticeCode());
            referrerCommand.setPracticeName(referrerData.getPracticeName());
            referrerCommand.setSpeciality(referrerData.getSpeciality());

            AddressCommand addressCommand = getAddressCommand(referrerData.getAddress());

            referrerCommand.setAddress(addressCommand);

            referrerCommand.setContactDetails(getContactCommand(referrerData.getContactDetails()));


            referrerCommand.setRole(Converter.getRoleCommand(referrerData.getRoleData()));

        }
        return referrerCommand;
    }

    private static ContactCommand getContactCommand(ContactData contactDetails) {
        if(contactDetails == null) {
            return new ContactCommand();
        }

        ContactCommand contactCommand = new ContactCommand();

        contactCommand.setId(contactDetails.getId());
        contactCommand.setEmail(contactDetails.getEmail());
        contactCommand.setMobile(contactDetails.getMobile());
        contactCommand.setPhone(contactDetails.getPhone());
        contactCommand.setPreferred(contactDetails.getPreferred());
        contactCommand.setFax(contactDetails.getFax());
        return contactCommand;
    }

    private static AddressCommand getAddressCommand(AddressData addressData) {

        AddressCommand addressCommand = new AddressCommand();
        if(addressData == null) {
            return addressCommand;
        }
        addressCommand.setId(addressData.getId());
        addressCommand.setLine1(addressData.getLine1());
        addressCommand.setLine2(addressData.getLine2());
        addressCommand.setLine3(addressData.getLine3());
        addressCommand.setCity(addressData.getCity());
        addressCommand.setCounty(addressData.getCounty());
        addressCommand.setCountry(addressData.getCountry());
        addressCommand.setPostCode(addressData.getPostCode());
        return addressCommand;
    }

    private static NameCommand getNameCommand(NameData nameData) {
        NameCommand nameCommand = new NameCommand();
        if(nameData == null) {
            return  nameCommand;
        }
        nameCommand.setId(nameData.getId());
        nameCommand.setVersion(nameData.getVersion());
        nameCommand.setFirstName(nameData.getFirstName());
        nameCommand.setMiddleName(nameData.getMiddleName());
        nameCommand.setLastName(nameData.getLastName());
        nameCommand.setPreferredName(nameData.getPreferredName());
        nameCommand.setTitle(getTitleCommand(nameData.getTitle()));


        return nameCommand;
    }



    public static List<TitleCommand> getTitleCommands(List<TitleData> titles){
        List<TitleCommand> titleCommands = new ArrayList<TitleCommand>();

        if(titles != null) {
            for (TitleData titleData : titles) {
                if(titleData != null){
                    titleCommands.add(getTitleCommand(titleData));
                }
            }
        }

        return  titleCommands;
    }

    private static TitleCommand getTitleCommand(TitleData titleData) {

        TitleCommand titleCommand = new TitleCommand();

        if(titleData == null) {
            return titleCommand;
        }
        titleCommand.setId(titleData.getId());
        titleCommand.setName(titleData.getName());
        titleCommand.setDisplayName(titleData.getDisplayName());
        return titleCommand;
    }

    public static List<EthnicityCommand> getEthnicityCommands(List<EthnicityData> ethnicityDatas){
        List<EthnicityCommand> ethnicityCommands = new ArrayList<EthnicityCommand>();

        if(ethnicityDatas != null) {
            for (EthnicityData titleData : ethnicityDatas) {
                if(titleData != null){
                    ethnicityCommands.add(getEthnicityCommand(titleData));
                }
            }
        }
        return  ethnicityCommands;
    }

    private static EthnicityCommand getEthnicityCommand(EthnicityData ethnicityData) {
        EthnicityCommand ethnicityCommand = new EthnicityCommand();

        ethnicityCommand.setId(ethnicityData.getId());
        ethnicityCommand.setName(ethnicityData.getName());
        ethnicityCommand.setDisplayName(ethnicityData.getDisplayName());
        return ethnicityCommand;
    }

    private static NameData getNameData(NameCommand nameCommand) {
        NameData nameData = new NameData();
        nameData.setId(nameCommand.getId());
        nameData.setVersion(nameCommand.getVersion());
        nameData.setFirstName(nameCommand.getFirstName());
        nameData.setMiddleName(nameCommand.getMiddleName());
        nameData.setLastName(nameCommand.getLastName());
        nameData.setPreferredName(nameCommand.getPreferredName());
        nameData.setTitle(getTitleCommand(nameCommand.getTitle()));


        return nameData;
    }

    private static TitleData getTitleCommand(TitleCommand titleCommand) {
        TitleData titleData = new TitleData();
        titleData.setId(titleCommand.getId());
        titleData.setName(titleCommand.getName());
        titleData.setDisplayName(titleCommand.getDisplayName());
        return titleData;
    }

    public static UserCommand getUserCommand(UserData userData) {
        UserCommand userCommand = new UserCommand();
        if(userData == null){
            return userCommand;
        }
        userCommand.setEmail(userData.getEmail());
        userCommand.setName(userData.getUserName());
        userCommand.setDisplayName(userData.getDisplayName());

        List<RoleData> roles = userData.getRoles();
        List<RoleCommand> roleCommands = getAllRoleCommands(roles);

        userCommand.setRoles(roleCommands);

        return userCommand;
    }

    public static List<RoleCommand> getAllRoleCommands(List<RoleData> roles) {
        List<RoleCommand> roleCommands = new ArrayList<RoleCommand>();
        if(roles == null || roles.size() ==0 ){
            return roleCommands;
        }

        for(RoleData role: roles) {
            roleCommands.add(getRoleCommand(role));
        }

        return roleCommands;
    }

    public static RoleCommand getRoleCommand(RoleData role) {
        RoleCommand roleCommand = new RoleCommand();
        roleCommand.setId(role.getId());
        roleCommand.setName(role.getName());
        roleCommand.setDescription(role.getDescription());
        return roleCommand;
    }


    public static IGRDestinationCommand getIGRDestinationCommand(IGRDestinationData igrDestinationData){
        IGRDestinationCommand igrDestinationCommand = new IGRDestinationCommand();

        if(igrDestinationData != null) {
            igrDestinationCommand.setId(igrDestinationData.getId());
            igrDestinationCommand.setName(igrDestinationData.getName());
            igrDestinationCommand.setPracticeName(igrDestinationData.getPracticeName());
            igrDestinationCommand.setReferredTo(igrDestinationData.getReferredTo());
            igrDestinationCommand.setRegisteredName(igrDestinationData.getRegisteredName());
            igrDestinationCommand.setRegisteredPracticeName(igrDestinationData.getRegisteredPracticeName());
            igrDestinationCommand.setSpecialty(igrDestinationData.getSpecialty());
        }

        return igrDestinationCommand;
    }

}
