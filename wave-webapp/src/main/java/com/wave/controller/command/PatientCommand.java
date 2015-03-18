package com.wave.controller.command;

import com.wave.address.AddressData;
import com.wave.contact.ContactData;
import com.wave.master.EthnicityData;
import com.wave.master.GenderData;
import com.wave.name.NameData;

import javax.persistence.*;
import java.util.Date;

public class PatientCommand {

    private Long id;
    private NameData nameData;
    private String nhsNumber;
    private EthnicityCommand ethnicity;
    private GenderCommand gender;
    private Date lastUpdated;
    private ContactCommand contactDetails;
    private AddressCommand address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NameData getNameData() {
        return nameData;
    }

    public void setNameData(NameData nameData) {
        this.nameData = nameData;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public EthnicityCommand getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(EthnicityCommand ethnicity) {
        this.ethnicity = ethnicity;
    }

    public GenderCommand getGender() {
        return gender;
    }

    public void setGender(GenderCommand gender) {
        this.gender = gender;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ContactCommand getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactCommand contactDetails) {
        this.contactDetails = contactDetails;
    }

    public AddressCommand getAddress() {
        return address;
    }

    public void setAddress(AddressCommand address) {
        this.address = address;
    }
}
